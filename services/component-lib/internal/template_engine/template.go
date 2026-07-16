package templateengine

import (
	"bytes"
	"fmt"
	"html/template"
	"strings"
)

// ComponentTemplateRegistry defines the raw layout blueprints.
// These can easily live in MongoDB instead of the codebase.
var ComponentTemplateRegistry = map[string]string{
	"RootContainer": `<div id="{{.ID}}" style="{{.InlineStyles}}">{{.ChildrenHTML}}</div>`,

	"Navbar": `<nav id="{{.ID}}" style="{{.InlineStyles}}" class="flex justify-between p-4 bg-white shadow-sm rounded-lg">
					<span class="font-bold text-xl text-slate-800">{{index .Props "storeName"}}</span>
			   </nav>`,

	"HeroBanner": `<section id="{{.ID}}" style="{{.InlineStyles}}">
						<h1 class="text-4xl font-extrabold mb-2">{{index .Props "title"}}</h1>
						<p class="text-slate-300 text-lg">{{index .Props "subtitle"}}</p>
						{{.ChildrenHTML}}
				   </section>`,

	"ActionButton": `<button id="{{.ID}}" style="{{.InlineStyles}}" class="text-white font-semibold cursor-pointer border-none"
						{{if index .Props "hx-get"}}hx-get="{{index .Props "hx-get"}}"{{end}}
						{{if index .Props "hx-post"}}hx-post="{{index .Props "hx-post"}}"{{end}}
						{{if index .Props "hx-trigger"}}hx-trigger="{{index .Props "hx-trigger"}}"{{end}}
						{{if index .Props "hx-target"}}hx-target="{{index .Props "hx-target"}}"{{end}}
						{{if index .Props "hx-swap"}}hx-swap="{{index .Props "hx-swap"}}"{{end}}>
						{{index .Props "label"}}
					</button>`,

	"DynamicGrid": `<div id="{{.ID}}" style="{{.InlineStyles}}">{{.ChildrenHTML}}</div>`,

	"HTMXLoader": `<div id="{{.ID}}" class="w-full text-center py-8 text-slate-400 animate-pulse bg-white rounded-lg border border-dashed"
						hx-get="{{index .Props "hx-get"}}"
						hx-trigger="{{index .Props "hx-trigger"}}"
						hx-swap="{{index .Props "hx-swap"}}">
						Loading dynamic elements...
				   </div>`,
}

// TemplateContext holds the structural data processed specifically for the engine compiler pass
type TemplateContext struct {
	ID           string
	Props        map[string]string
	InlineStyles template.CSS
	ChildrenHTML template.HTML
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
func CompileTreeToHTML(node *LayoutNode) (template.HTML, error) {
	if node == nil {
		return "", nil
	}

	// 1. RECURSION: Evaluate all nested children layers first
	var childrenBuilder strings.Builder
	for _, child := range node.Children {
		childHTML, err := CompileTreeToHTML(child)
		if err != nil {
			return "", err
		}
		childrenBuilder.WriteString(string(childHTML))
	}

	// 2. Lookup the component's HTML blueprint text string from the registry map
	rawHTMLTemplate, exists := ComponentTemplateRegistry[node.Type]
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
