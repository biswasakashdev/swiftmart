package models

import (
	"time"

	"go.mongodb.org/mongo-driver/v2/bson"
)

type ComponentBluePrint struct {
	ID        bson.ObjectID `bson:"_id,omitempty"`
	Name      string        `bson:"name"`
	Template  string        `bson:"template"`
	CreatedAt time.Time     `bson:"created_at"`
	UpdatedAt time.Time     `bson:"updated_at"`
}
