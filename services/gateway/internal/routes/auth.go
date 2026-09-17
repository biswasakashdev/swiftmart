package routes

import (
	"encoding/json"
	"errors"
	"net/http"

	"github.com/go-chi/chi/v5"

	"github.com/biswasakashdev/swiftmart/services/gateway/internal/dtos"
	"github.com/biswasakashdev/swiftmart/services/gateway/internal/util"
	accountspbv1 "github.com/biswasakashdev/swiftmart/services/gateway/proto_gen/accounts/v1"
)

type authHandler struct {
	userClient accountspbv1.UserServiceClient
}

func NewAuthHandler(userClient accountspbv1.UserServiceClient) chi.Router {

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

var (
	ErrorServiceNotAvailable error = errors.New("Currently unavailable")
	ErrorInvlidData          error = errors.New("Invalid data")
)

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
		util.BuildErrResponse(w, ErrorServiceNotAvailable.Error())
		return
	}

	util.BuildResponseWithBody(w, &dtos.RegisterUserRes{
		ID:        res.User.Id,
		FirstName: res.User.FirstName,
		LastName:  res.User.LastName,
		Email:     res.User.Email,
	})
}

func (ah *authHandler) login(w http.ResponseWriter, r *http.Request) {

}

func (ah *authHandler) signInWithGoogle(w http.ResponseWriter, r *http.Request) {

}

func (ah *authHandler) logout(w http.ResponseWriter, r *http.Request) {

}
