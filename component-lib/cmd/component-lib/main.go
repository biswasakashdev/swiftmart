package main

import (
	"context"
	"fmt"
	"log"
	"net/http"

	"github.com/biswasakashdev/swiftmart/component-lib/config"
	"github.com/biswasakashdev/swiftmart/component-lib/internal/db"
	"github.com/biswasakashdev/swiftmart/component-lib/internal/handlers"
	"github.com/biswasakashdev/swiftmart/component-lib/internal/repository"
)

func main() {
	// Load configuration
	applicationConfig, err := config.Load()
	if err != nil {
		log.Fatal("Failed to start the application with error:", err)
	}

	// Connect to MongoDB
	dbClient, err := db.NewMongoClient(context.Background(), applicationConfig)
	if err != nil {
		log.Fatal("Failed to connect to database:", err)
	}

	// Initialize the repositories
	componentRepository := repository.NewComponetRepository(dbClient)
	layoutRepository := repository.NewLayoutRepository(dbClient)

	// Initialize shop handler
	shopHandler := handlers.NewShopHandler(layoutRepository, componentRepository)

	// Setup routes
	mux := http.NewServeMux()
	mux.HandleFunc("GET /shop-handler/{shopId}", shopHandler.ShopHandler)

	// Start server
	fmt.Println("Server is running on http://localhost:8080")
	log.Fatal(http.ListenAndServe(":8080", mux))
}
