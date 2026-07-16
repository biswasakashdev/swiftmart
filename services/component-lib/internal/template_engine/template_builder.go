package templateengine

import (
	"bytes"
	"context"
	"fmt"
	"html/template"
	"strings"
	"sync"

	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/db/repository"
	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/types"
)

// TemplateBuilder compiles layout trees to HTML using templates from the registry
type TemplateBuilder struct {
	mu           sync.RWMutex
	registry     map[string]string
	templateRepo *repository.TemplateRepository
}

// NewTemplateBuilder creates a new template builder
func NewTemplateBuilder(templateRepo *repository.TemplateRepository) *TemplateBuilder {
	tb := &TemplateBuilder{
		registry:     make(map[string]string),
		templateRepo: templateRepo,
	}

	// Initialize with built-in templates as fallback
	for k, v := range ComponentTemplateRegistry {
		tb.registry[k] = v
	}

	return tb
}

// LoadTemplatesFromDB loads templates from the database into the registry
func (tb *TemplateBuilder) LoadTemplatesFromDB(ctx context.Context) error {
	blueprints, err := tb.templateRepo.FetchAllComponentBlueprintsFromDb(ctx)
	if err != nil {
		return err
	}

	tb.mu.Lock()
	defer tb.mu.Unlock()

	for _, bp := range blueprints {
		tb.registry[bp.Name] = bp.Template
	}

	return nil
}

// GetTemplate retrieves a template from the registry
func (tb *TemplateBuilder) GetTemplate(componentType string) (string, bool) {
	tb.mu.RLock()
	defer tb.mu.RUnlock()
	tmpl, exists := tb.registry[componentType]
	return tmpl, exists
}

// UpdateTemplate updates a template in the registry (for runtime updates)
func (tb *TemplateBuilder) UpdateTemplate(componentType string, newTemplate string) {
	tb.mu.Lock()
	defer tb.mu.Unlock()
	tb.registry[componentType] = newTemplate
}

// CompileStyleString converts a map into standard valid CSS syntax strings
func CompileStyleString(styles map[string]string) template.CSS {
	if len(styles) == 0 {
		return ""
	}
	var sb strings.Builder
	for property, value := range styles {
		fmt.Fprintf(&sb, "%s:%s;", property, value)
	}
	return template.CSS(sb.String())
}

// CompileTreeToHTML processes the abstract node configuration and transforms it into raw target HTML layout output
func (tb *TemplateBuilder) CompileTreeToHTML(node *types.LayoutNode) (template.HTML, error) {
	if node == nil {
		return "", nil
	}

	// 1. RECURSION: Evaluate all nested children layers first
	var childrenBuilder strings.Builder
	for _, child := range node.Children {
		childHTML, err := tb.CompileTreeToHTML(child)
		if err != nil {
			return "", err
		}
		childrenBuilder.WriteString(string(childHTML))
	}

	// 2. Lookup the component's HTML blueprint text string from the registry map
	tb.mu.RLock()
	rawHTMLTemplate, exists := tb.registry[node.Type]
	tb.mu.RUnlock()

	if !exists {
		// Fallback layout wrapper for unrecognized nodes so the compiler doesn't throw a fatal panic
		rawHTMLTemplate = `<div id="{{.ID}}" style="{{.InlineStyles}}">{{.ChildrenHTML}}</div>`
	}

	// 3. Initialize Go's parsing engine targeting the component layout string
	tmpl, err := template.New(node.ID).Parse(rawHTMLTemplate)
	if err != nil {
		return "", err
	}

	// 4. Populate compilation context fields
	contextData := TemplateContext{
		ID:           node.ID,
		Props:        node.Props,
		InlineStyles: CompileStyleString(node.Styles),
		ChildrenHTML: template.HTML(childrenBuilder.String()),
	}

	// 5. Execute composition interpolation
	var resultBuffer bytes.Buffer
	err = tmpl.Execute(&resultBuffer, contextData)
	if err != nil {
		return "", err
	}

	return template.HTML(resultBuffer.String()), nil
}
