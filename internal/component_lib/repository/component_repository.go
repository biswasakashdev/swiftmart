package repository

import (
	"context"

	"github.com/biswasakashdev/swiftmart/internal/component_lib/models"
	"go.mongodb.org/mongo-driver/v2/bson"
	"go.mongodb.org/mongo-driver/v2/mongo"
)

type ComponentRepository struct {
	collection *mongo.Collection
}

func NewComponetRepository(dbClient *mongo.Client) *ComponentRepository {
	return &ComponentRepository{
		collection: dbClient.Database("swiftmart").Collection("layouts"),
	}
}

func (tr *ComponentRepository) FetchAllComponentBlueprintsFromDb(ctx context.Context) ([]models.ComponentBluePrint, error) {
	cursor, err := tr.collection.Find(ctx, bson.D{})
	if err != nil {
		return nil, err
	}
	defer cursor.Close(ctx)

	var componentBluePrints []models.ComponentBluePrint

	if err := cursor.All(ctx, &componentBluePrints); err != nil {
		return nil, err
	}

	return componentBluePrints, nil
}
