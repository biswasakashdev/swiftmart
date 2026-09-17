package handler

import (
	"net/http"

	"github.com/go-chi/chi/v5"

	accountspbv1 "github.com/biswasakashdev/swiftmart/services/gateway/proto_gen/accounts/v1"
)

type authHandler struct {
	userClient *accountspbv1.UserServiceClient
}

func NewAuthHandler(userClient *accountspbv1.UserServiceClient) chi.Router {

	router := chi.NewRouter()

	authHandle := authHandler{
		userClient: userClient,
	}

	router.Get("/", authHandle.getAuthorization)
	router.Post("/", authHandle.login)
	router.Post("/oauth/google", authHandle.signInWithGoogle)
	router.Post("/register", authHandle.register)
	router.Delete("/", authHandle.logout)

	return router
}

func (ah *authHandler) getAuthorization(w http.ResponseWriter, r *http.Request) {

}

func (ah *authHandler) register(w http.ResponseWriter, r *http.Request) {

}

func (ah *authHandler) login(w http.ResponseWriter, r *http.Request) {

}

func (ah *authHandler) signInWithGoogle(w http.ResponseWriter, r *http.Request) {

}

func (ah *authHandler) logout(w http.ResponseWriter, r *http.Request) {

}
