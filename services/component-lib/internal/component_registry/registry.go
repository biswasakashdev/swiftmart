package componentregistry

import (
	"context"
	"sync"

	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/db/repository"
	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/template_engine"
	"go.mongodb.org/mongo-driver/v2/mongo"
)

// ComponentRegistry manages component templates in memory for fast access
type ComponentRegistry struct {
	mu          sync.RWMutex
	templateBuilder *template_engine.TemplateBuilder
}

// Get fetches an HTML template string directly from RAM instantly
func (cr *ComponentRegistry) Get(componentType string) (string, bool) {
	return cr.templateBuilder.GetTemplate(componentType)
}

// Update runtime re-hydration (called at boot OR via webhook/cache invalidation event)
func (cr *ComponentRegistry) Update(componentType string, newComponent repository.ComponentBluePrint) {
	cr.templateBuilder.UpdateTemplate(componentType, newComponent.Template)
}

func NewComponentRegistry(client *mongo.Client) (*ComponentRegistry, error) {
	templateRepository := repository.NewTemplateRepository(client)

	templateBuilder := template_engine.NewTemplateBuilder(templateRepository)

	// Load templates from DB
	ctx := context.Background()
	if err := templateBuilder.LoadTemplatesFromDB(ctx); err != nil {
		return nil, err
	}

	newComponentRegistry := ComponentRegistry{
		templateBuilder: templateBuilder,
	}

	return &newComponentRegistry, nil
}