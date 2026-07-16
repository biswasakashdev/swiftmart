package templateengine

// LayoutNode represents a component instance returned from the database
type LayoutNode struct {
	ID       string            `json:"id"`
	Type     string            `json:"type"`
	Styles   map[string]string `json:"styles,omitempty"`
	Props    map[string]string `json:"props,omitempty"`
	Children []*LayoutNode     `json:"children,omitempty"`
}

// GetMockLayoutTree returns a pointer to a highly nested dynamic page layout layout tree
func GetMockLayoutTree() *LayoutNode {
	return &LayoutNode{
		ID:   "root_canvas",
		Type: "RootContainer",
		Styles: map[string]string{
			"background-color": "#f8fafc",
			"font-family":      "sans-serif",
			"padding":          "20px",
		},
		Children: []*LayoutNode{
			{
				ID:   "main_navbar",
				Type: "Navbar",
				Props: map[string]string{
					"storeName": "SwiftMart Retro",
				},
			},
			{
				ID:   "hero_section",
				Type: "HeroBanner",
				Styles: map[string]string{
					"background-color": "#0f172a",
					"color":            "#ffffff",
					"padding":          "60px 40px",
					"border-radius":    "12px",
					"margin-top":       "20px",
				},
				Props: map[string]string{
					"title":    "Step Into The Future",
					"subtitle": "Exclusive drops landing every single week.",
				},
				Children: []*LayoutNode{
					{
						ID:   "hero_cta_btn",
						Type: "ActionButton",
						Styles: map[string]string{
							"background-color": "#3b82f6",
							"padding":          "12px 24px",
							"border-radius":    "6px",
							"margin-top":       "20px",
							"display":          "inline-block",
						},
						Props: map[string]string{
							"label":     "Explore Collection",
							"hx-post":   "/api/v1/analytics/click/hero-cta",
							"hx-target": "#hero_section",
							"hx-swap":   "none",
						},
					},
				},
			},
			{
				ID:   "product_showcase_grid",
				Type: "DynamicGrid",
				Styles: map[string]string{
					"display":               "grid",
					"grid-template-columns": "repeat(auto-fit, minmax(280px, 1fr))",
					"gap":                   "20px",
					"margin-top":            "40px",
				},
				Children: []*LayoutNode{
					{
						ID:   "live_catalog_loader",
						Type: "HTMXLoader",
						Props: map[string]string{
							"hx-get":     "/api/v1/stores/retro-kicks/products?limit=6",
							"hx-trigger": "load",
							"hx-swap":    "outerHTML",
						},
					},
				},
			},
		},
	}
}
