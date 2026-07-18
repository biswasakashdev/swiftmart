package models

import (
	"time"

	"go.mongodb.org/mongo-driver/v2/bson"
)

type RootLayout struct {
	ID          bson.ObjectID `bson:"_id,omitempty"`
	ShopID      string        `bson:"shop_id"`
	Title       string        `bson:"title"`
	Favicon     string        `bson:"favicon,omitempty"`
	Description string        `bson:"description"`
	Layout      LayoutNode    `bson:"layout"`
	CreatedAt   time.Time     `bson:"created_at"`
	UpdatedAt   time.Time     `bson:"updated_at"`
}

// LayoutNode represents a component instance in the layout tree
type LayoutNode struct {
	ElementID string            `bson:"element_id"`
	Type      string            `bson:"type"`
	Styles    map[string]string `bson:"styles,omitempty"`
	Props     map[string]any    `bson:"props,omitempty"`
	Children  []LayoutNode      `bson:"children,omitempty"`
}
