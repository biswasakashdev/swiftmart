package templateengine

import (
	"bytes"
	"fmt"
	"html/template"
	"strings"

	"github.com/biswasakashdev/swiftmart/component-lib/internal/models"
)

// TemplateContext holds the structural data processed specifically for the engine compiler pass
type TemplateContext struct {
	ID           string
	Props        map[string]interface{}
	InlineStyles template.CSS
	ChildrenHTML template.HTML
}

// compileStyleString converts a map into standard valid CSS syntax strings
func compileStyleString(styles map[string]string) template.CSS {
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
func (tb *TemplateEngine) compileTreeToHTML(node *models.LayoutNode) (template.HTML, error) {

	// 1. RECURSION: Evaluate all nested children layers first
	var childrenBuilder strings.Builder
	for _, child := range node.Children {
		childHTML, err := tb.compileTreeToHTML(&child)
		if err != nil {
			return "", err
		}
		childrenBuilder.WriteString(string(childHTML))
	}

	rawHTMLTemplate, exists := tb.Registry.Get(node.Type)
	if !exists {
		// Fallback layout wrapper for unrecognized nodes so the compiler doesn't throw a fatal panic
		rawHTMLTemplate = `<div id="{{.ID}}" style="{{.InlineStyles}}">{{.ChildrenHTML}}</div>`
	}

	// 3. Initialize Go's parsing engine targeting the component layout string
	tmpl, err := template.New(node.ElementID).Parse(rawHTMLTemplate)
	if err != nil {
		return "", err
	}

	// 4. Populate compilation context fields
	contextData := TemplateContext{
		ID:           node.ElementID,
		Props:        node.Props,
		InlineStyles: compileStyleString(node.Styles),
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
