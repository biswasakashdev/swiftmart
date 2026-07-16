package main

import (
	"fmt"
	"log"
	"net/http"

	te "github.com/biswasakashdev/swiftmart/services/component-lib/internal/template_engine"
)

func shopHandler(w http.ResponseWriter, r *http.Request) {

	shopId := r.PathValue("shopId")

	fmt.Println("The shop id", shopId)
	layoutNode := te.GetMockLayoutTree()

	compiledTemplate, err := te.CompileTreeToHTML(layoutNode)

	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
	}

	w.Write([]byte(string(compiledTemplate)))

	w.WriteHeader(http.StatusOK)

}

func main() {
	// 1. Associate the URL path "/" with the helloHandler function
	mux := http.NewServeMux()
	mux.HandleFunc("GET /shop-handler/{shopId}", shopHandler)

	// 2. Log that the server is starting
	fmt.Println("Server is running on http://localhost:8080")

	// 3. Start the server on port 8080 and log any fatal errors if it fails
	log.Fatal(http.ListenAndServe(":8080", mux))
}
