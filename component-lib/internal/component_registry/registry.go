package componentregistry

import (
	"context"
	"sync"
	"time"

	"github.com/biswasakashdev/swiftmart/component-lib/internal/repository"
)

// ComponentRegistry manages component templates in memory for fast access
type ComponentRegistry struct {
	mu         sync.RWMutex
	components map[string]string
}

func NewComponentRegistry(componentRepo *repository.ComponentRepository) (*ComponentRegistry, error) {

	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()

	componentList, err := componentRepo.FetchAllComponentBlueprintsFromDb(ctx)

	if err != nil {
		return nil, err
	}

	componentMap := make(map[string]string)

	for _, components := range componentList {
		componentMap[components.Type] = components.Template
	}

	return &ComponentRegistry{
		components: componentMap,
	}, nil
}

// Get fetches an HTML template string directly from RAM instantly
func (cr *ComponentRegistry) Get(componentType string) (string, bool) {
	cr.mu.RLock()
	// Using defer ensures the RUnlock runs even if you add more logic later
	defer cr.mu.RUnlock()

	component, exists := cr.components[componentType]
	return component, exists
}

// Update adds a new component template or updates an existing one.
// It uses a full write lock to ensure thread safety during modification.
func (cr *ComponentRegistry) Update(componentType, template string) {
	cr.mu.Lock()
	defer cr.mu.Unlock() // Guarantees the lock is released when the function finishes

	cr.components[componentType] = template
}
