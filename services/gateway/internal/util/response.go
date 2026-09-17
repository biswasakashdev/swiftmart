package util

import (
	"encoding/json"
	"net/http"
)

func BuildErrorResWithMessage(w http.ResponseWriter, err string) {
	BuildErrResponseWithCode(w, err, http.StatusInternalServerError)
}

func BuildErrResponse(w http.ResponseWriter, err string) {
	BuildErrResponseWithCode(w, err, http.StatusInternalServerError)
}

func BuildErrResponseWithCode(w http.ResponseWriter, err string, code int) {
	w.WriteHeader(code)
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(map[string]string{
		"err": err,
	})
}

func BuildResponseWithBody(w http.ResponseWriter, body any) {
	BuildResponseBodyWithCode(w, body, http.StatusOK)
}

func BuildResponseBodyWithCode(w http.ResponseWriter, body any, code int) {
	w.WriteHeader(code)
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(body)
}
