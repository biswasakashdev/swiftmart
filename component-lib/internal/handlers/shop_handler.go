package handlers

import (
	"log"
	"net/http"

	componentregistry "github.com/biswasakashdev/swiftmart/component-lib/internal/component_registry"
	"github.com/biswasakashdev/swiftmart/component-lib/internal/repository"
	templateengine "github.com/biswasakashdev/swiftmart/component-lib/internal/template_engine"
)

type ShopHandler struct {
	LayoutRepository *repository.LayoutRepository
	TemplateEngine   *templateengine.TemplateEngine
}

func NewShopHandler(
	layoutRepo *repository.LayoutRepository,
	componentRepo *repository.ComponentRepository,
) *ShopHandler {

	// Initialize the component registry
	componentRegistry, err := componentregistry.NewComponentRegistry(componentRepo)

	if err != nil {
		log.Fatal("Failed to fetch the components", err.Error())
	}

	// Create template engine
	templateEngine := templateengine.NewTemplateEngine(componentRegistry)

	return &ShopHandler{
		LayoutRepository: layoutRepo,
		TemplateEngine:   templateEngine,
	}
}

func (sh *ShopHandler) ShopHandler(w http.ResponseWriter, r *http.Request) {
	shopId := r.PathValue("shopId")
	ctx := r.Context()
	// Fetch layout tree for the shop from database
	layoutNode, err := sh.LayoutRepository.FetchLayoutTreeForShop(ctx, shopId)
	if err != nil {
		http.Error(w, "Failed to fetch layout: "+err.Error(), http.StatusInternalServerError)
		return
	}

	// If no layout found, return 404
	if layoutNode == nil {
		http.Error(w, "Shop layout not found", http.StatusNotFound)
		return
	}

	// Compile the layout tree to HTML
	compiledTemplate, err := sh.TemplateEngine.BuildPage(layoutNode)
	if err != nil {
		http.Error(w, "Failed to compile template: "+err.Error(), http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "text/html; charset=utf-8")
	w.WriteHeader(http.StatusOK)
	w.Write([]byte(string(compiledTemplate)))
}
