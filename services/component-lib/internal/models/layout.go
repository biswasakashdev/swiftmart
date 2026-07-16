package models

// LayoutNode represents a component instance in the layout tree
type LayoutNode struct {
	ID       string            `json:"id" bson:"id"`
	Type     string            `json:"type" bson:"type"`
	Styles   map[string]string `json:"styles,omitempty" bson:"styles,omitempty"`
	Props    map[string]string `json:"props,omitempty" bson:"props,omitempty"`
	Children []*LayoutNode     `json:"children,omitempty" bson:"children,omitempty"`
}
