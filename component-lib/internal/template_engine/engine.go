package templateengine

import (
	"bytes"
	"html/template"

	componentregistry "github.com/biswasakashdev/swiftmart/component-lib/internal/component_registry"
	"github.com/biswasakashdev/swiftmart/component-lib/internal/models"
)

// Global Document Shell Frame Template
const BaseDocumentShell = `<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Core SEO & Page Metadata -->
    <title>{{.Title}}</title>
    <meta name="description" content="{{.Description}}">

    {{if .Favicon}}
    <link rel="icon" type="image/x-icon" href="{{.Favicon}}">
    {{end}}

    <!-- Core Interactive Platform Requirements -->
    <script src="https://unpkg.com/htmx.org@2.0.0" defer></script>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body class="bg-slate-50 antialiased min-h-screen">

    <!-- The Compiled User Component Layout AST Tree Mount Point -->
    {{.BodyHTML}}

</body>
</html>`

// TemplateEngine compiles layout trees to HTML using templates from the registry
type TemplateEngine struct {
	Registry *componentregistry.ComponentRegistry
}

// NewTemplateEngine creates a new template builder
func NewTemplateEngine(componentReg *componentregistry.ComponentRegistry) *TemplateEngine {
	tb := &TemplateEngine{
		Registry: componentReg,
	}
	return tb
}

// ShellContext organizes compilation values for parsing interpolation passes cleanly
type ShellContext struct {
	Title            string
	Description      string
	Favicon          string
	HeaderInjections template.HTML
	BodyHTML         template.HTML
}

// BuildPage compiles the final HTML string wrapper for the client shopper's browser request
func (tb *TemplateEngine) BuildPage(root *models.RootLayout) (template.HTML, error) {
	if root == nil {
		return template.HTML(""), nil
	}

	// 1. Compile the main dynamic structural node layout block body content
	// Swapping the internal method pointer with whatever name your package uses
	compiledBody, err := tb.compileTreeToHTML(&root.Layout)
	if err != nil {
		return template.HTML(""), err
	}

	// 2. Parse the base document layout shell framework blueprint
	tmpl, err := template.New("base_shell").Parse(BaseDocumentShell)
	if err != nil {
		return template.HTML(""), err
	}

	// 3. Assemble variables configuration map safely targeting context layout variables
	context := ShellContext{
		Title:       root.Title,
		Description: root.Description,
		Favicon:     root.Favicon,
		BodyHTML:    compiledBody,
	}

	// 4. Run interpolation assembly execution
	var finalBuffer bytes.Buffer
	err = tmpl.Execute(&finalBuffer, context)
	if err != nil {
		return template.HTML(""), err
	}

	// 5. Package output wrapper down as safe raw valid HTML data bytes ready to write to browser stream
	return template.HTML(finalBuffer.String()), nil
}
