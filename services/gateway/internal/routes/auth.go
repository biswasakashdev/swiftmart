package routes

import (
	"context"
	"crypto/rand"
	"encoding/base64"
	"encoding/json"
	"errors"
	"log"
	"net/http"
	"time"

	"github.com/coreos/go-oidc/v3/oidc"
	"github.com/go-chi/chi/v5"
	"github.com/golang-jwt/jwt/v5"
	"golang.org/x/oauth2"

	"github.com/biswasakashdev/swiftmart/services/gateway/internal/config"
	"github.com/biswasakashdev/swiftmart/services/gateway/internal/dtos"
	"github.com/biswasakashdev/swiftmart/services/gateway/internal/util"
	accountspbv1 "github.com/biswasakashdev/swiftmart/services/gateway/proto_gen/accounts/v1"
)

type authHandler struct {
	userClient   accountspbv1.UserServiceClient
	googleCfg    *oauth2.Config
	secretKey    string
	oidcVerifier *oidc.IDTokenVerifier
}

func NewAuthHandler(userClient accountspbv1.UserServiceClient, cfg *config.Config) chi.Router {

	router := chi.NewRouter()

	/*
	* Configureing oauth2 and openid connect to implmemnent single signin

	 */

	// Initialize OIDC Provider via auto-discovery (fetches keys, endpoints)

	ctx := context.Background()
	provider, err := oidc.NewProvider(ctx, "https://accounts.google.com")

	if err != nil {
		log.Fatalf("Failed to query provider: %v", err)
	}

	// Configure OAuth2 endpoints from OIDC provider metadata
	oauthConfig := oauth2.Config{
		ClientID:     cfg.GoogleClientID,
		ClientSecret: cfg.GoogleClientSecret,
		RedirectURL:  cfg.GoogleRedirectURL,
		Endpoint:     provider.Endpoint(),
		Scopes:       []string{oidc.ScopeOpenID, oidc.ScopeProfile, oidc.ScopeEmail},
	}

	authHandle := authHandler{
		userClient:   userClient,
		googleCfg:    &oauthConfig,
		secretKey:    cfg.JwtSecret,
		oidcVerifier: provider.Verifier(&oidc.Config{ClientID: cfg.GoogleClientID}),
	}

	router.Get("/", authHandle.getAuthorization)
	router.Post("/", authHandle.login)
	router.Get("/oauth/google", authHandle.signInWithGoogle)
	router.Get("/oauth/google/callback", authHandle.handleCallback)
	router.Post("/register", authHandle.register)
	router.Delete("/", authHandle.logout)

	return router
}

var (
	ErrorServiceNotAvailable error = errors.New("Currently unavailable")
	ErrorInvlidData          error = errors.New("Invalid data")

	AccessTokenExpiration  = 5 * time.Minute
	RefreshTokenExpiration = 24 * time.Hour

	TokenTypeAccessToken  = "access"
	TokenTypeRefreshToken = "refresh"
)

type TokenClaims struct {
	UserID    string `json:"user_id"`
	Email     string `json:"email"`
	TokenType string `json:"token_type"`
	jwt.RegisteredClaims
}

func (ah *authHandler) generateToken(userID, email string, expiration time.Duration, tokenType string) (string, error) {
	claims := TokenClaims{
		UserID:    userID,
		Email:     email,
		TokenType: tokenType,
		RegisteredClaims: jwt.RegisteredClaims{
			Subject:   userID,
			IssuedAt:  jwt.NewNumericDate(time.Now()),
			ExpiresAt: jwt.NewNumericDate(time.Now().Add(expiration)),
		},
	}

	token := jwt.NewWithClaims(jwt.SigningMethodHS256, claims)

	return token.SignedString([]byte(ah.secretKey))
}

func (ah *authHandler) getAuthorization(w http.ResponseWriter, r *http.Request) {
}

func (ah *authHandler) register(w http.ResponseWriter, r *http.Request) {

	defer r.Body.Close()

	var userData dtos.RegisterUserReq
	// Decodes the stream directly into the struct
	err := json.NewDecoder(r.Body).Decode(&userData)
	if err != nil {
		util.BuildErrResponse(w, ErrorInvlidData.Error())
		return
	}

	req := accountspbv1.CreateUserRequest{
		Email:     userData.Email,
		FirstName: userData.FirstName,
		LastName:  userData.LastName,
		Password:  userData.Password,
	}

	ctx := r.Context()

	res, err := ah.userClient.CreateUser(ctx, &req)

	if err != nil {
		log.Printf("Failed to create user with error: %s", err.Error())
		util.BuildErrResponse(w, ErrorServiceNotAvailable.Error())
		return
	}

	util.BuildResponseBodyWithCode(w, dtos.RegisterUserRes{
		ID:        res.User.Id,
		FirstName: res.User.FirstName,
		LastName:  res.User.LastName,
		Email:     res.User.Email,
	}, http.StatusCreated)
}

func (ah *authHandler) login(w http.ResponseWriter, r *http.Request) {

	defer r.Body.Close()

	var userData dtos.LoginUserReq
	// Decodes the stream directly into the struct
	err := json.NewDecoder(r.Body).Decode(&userData)
	if err != nil {
		util.BuildErrResponse(w, ErrorInvlidData.Error())
		return
	}

	ctx := r.Context()

	res, err := ah.userClient.Verify(ctx, &accountspbv1.VerifyRequest{
		Email:    userData.Email,
		Password: userData.Password,
	})

	if err != nil {
		log.Printf("Failed to verify user with error: %s", err.Error())
		util.BuildErrResponse(w, ErrorServiceNotAvailable.Error())
		return
	}

	user := res.GetUser()

	accessToken, err := ah.generateToken(user.GetId(), user.GetEmail(), AccessTokenExpiration, TokenTypeAccessToken)
	if err != nil {
		log.Printf("Failed to generate access token with error: %s", err.Error())
		util.BuildErrResponse(w, ErrorServiceNotAvailable.Error())
		return
	}

	refreshToken, err := ah.generateToken(user.GetId(), user.GetEmail(), RefreshTokenExpiration, TokenTypeRefreshToken)
	if err != nil {
		log.Printf("Failed to generate refresh token with error: %s", err.Error())
		util.BuildErrResponse(w, ErrorServiceNotAvailable.Error())
		return
	}

	sessionToken := http.Cookie{
		Name:     "session_token",
		Value:    refreshToken,
		Path:     "/",
		Expires:  time.Now().Add(RefreshTokenExpiration),
		HttpOnly: true,
		Secure:   true,
		SameSite: http.SameSiteStrictMode,
	}
	http.SetCookie(w, &sessionToken)

	util.BuildResponseBodyWithCode(w, dtos.LoginUserRes{
		AccessToken:  accessToken,
		RefreshToken: refreshToken,
	}, http.StatusOK)

}

func (ah *authHandler) signInWithGoogle(w http.ResponseWriter, r *http.Request) {

	b := make([]byte, 16)
	if _, err := rand.Read(b); err != nil {
		http.Error(w, "Failed to generate state", http.StatusInternalServerError)
		return
	}
	state := base64.URLEncoding.EncodeToString(b)

	http.SetCookie(w, &http.Cookie{
		Name:     "oauthstate",
		Value:    state,
		Expires:  time.Now().Add(10 * time.Minute),
		HttpOnly: true,
		Secure:   false, // Set to true in production with HTTPS
		SameSite: http.SameSiteLaxMode,
		Path:     "/",
	})
	http.Redirect(w, r, ah.googleCfg.AuthCodeURL(state), http.StatusFound)
}

// Claims represents the identity claims returned in Google's ID token.
type Claims struct {
	Email         string `json:"email"`
	EmailVerified bool   `json:"email_verified"`
	Name          string `json:"name"`
	Picture       string `json:"picture"`
	Subject       string `json:"sub"` // Unique Google User ID
}

func (ah *authHandler) handleCallback(w http.ResponseWriter, r *http.Request) {
	// Verify CSRF state
	stateCookie, err := r.Cookie("oauthstate")
	if err != nil || r.URL.Query().Get("state") != stateCookie.Value {
		http.Error(w, "Invalid OAuth state", http.StatusBadRequest)
		return
	}

	// Exchange the authorization code for OAuth2 tokens
	oauth2Token, err := ah.googleCfg.Exchange(r.Context(), r.URL.Query().Get("code"))
	if err != nil {
		http.Error(w, "Failed to exchange code: "+err.Error(), http.StatusInternalServerError)
		return
	}

	// Extract the raw ID token from OAuth2 token response
	rawIDToken, ok := oauth2Token.Extra("id_token").(string)
	if !ok {
		http.Error(w, "No id_token found in token response", http.StatusInternalServerError)
		return
	}

	// Cryptographically verify ID token signature, expiration, and audience
	idToken, err := ah.oidcVerifier.Verify(r.Context(), rawIDToken)
	if err != nil {
		http.Error(w, "Failed to verify ID token: "+err.Error(), http.StatusInternalServerError)
		return
	}

	// Extract user claims
	var claims Claims
	if err := idToken.Claims(&claims); err != nil {
		http.Error(w, "Failed to decode claims: "+err.Error(), http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(map[string]any{
		"message": "Authentication successful",
		"user":    claims,
	})
}

func (ah *authHandler) logout(w http.ResponseWriter, r *http.Request) {

}
