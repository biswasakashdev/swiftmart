package handlers

import (
	"fmt"
	"net/http"

	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/db/repository"
	templateengine "github.com/biswasakashdev/swiftmart/services/component-lib/internal/template_engine"
)

type ShopHandler struct {
	LayoutRepository *repository.LayoutRepository
	TemplateBuilder  *templateengine.TemplateBuilder
}

func NewShopHandler(
	layoutRepo *repository.LayoutRepository,
	templateBuilder *templateengine.TemplateBuilder,
) (*ShopHandler, error) {

	return &ShopHandler{
		LayoutRepository: layoutRepo,
		TemplateBuilder:  templateBuilder,
	}, nil
}

func (sh *ShopHandler) ShopHandler(w http.ResponseWriter, r *http.Request) {
	shopId := r.PathValue("shopId")

	fmt.Println("The shop id:", shopId)

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
	compiledTemplate, err := sh.TemplateBuilder.CompileTreeToHTML(layoutNode)
	if err != nil {
		http.Error(w, "Failed to compile template: "+err.Error(), http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "text/html; charset=utf-8")
	w.WriteHeader(http.StatusOK)
	w.Write([]byte(string(compiledTemplate)))
}
