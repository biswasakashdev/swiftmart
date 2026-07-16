package main

import (
	"context"
	"fmt"
	"log"
	"net/http"

	"github.com/biswasakashdev/swiftmart/services/component-lib/config"
	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/component_registry"
	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/db"
	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/db/repository"
	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/handlers"
	templateengine "github.com/biswasakashdev/swiftmart/services/component-lib/internal/template_engine"
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

	// Initialize template repository
	templateRepository := repository.NewTemplateRepository(dbClient)

	// Initialize template builder
	templateBuilder := templateengine.NewTemplateBuilder(templateRepository)

	// Load templates from DB
	ctx := context.Background()
	if err := templateBuilder.LoadTemplatesFromDB(ctx); err != nil {
		log.Fatal("Failed to load templates from DB:", err)
	}

	// Initialize layout repository
	layoutRepository := repository.NewLayoutRepository(templateRepository)

	// Initialize component registry
	componentRegistry, err := componentregistry.NewComponentRegistry(dbClient)
	if err != nil {
		log.Fatal("Failed to initialize the component registry:", err)
	}

	// Initialize shop handler
	shopHandler := handlers.NewShopHandler(layoutRepository, templateBuilder)

	// Setup routes
	mux := http.NewServeMux()
	mux.HandleFunc("GET /shop-handler/{shopId}", shopHandler.ShopHandler)

	// Start server
	fmt.Println("Server is running on http://localhost:8080")
	log.Fatal(http.ListenAndServe(":8080", mux))
}