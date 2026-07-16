package repository

import (
	"context"

	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/types"
	"go.mongodb.org/mongo-driver/v2/bson"
	"go.mongodb.org/mongo-driver/v2/mongo"
)

type ComponentRepository struct {
	collection
}

func NewComponetRepository(dbClient *mongo.Client) *ComponentRepository {

	return
}

func (tr *TemplateRepository) FetchAllComponentBlueprintsFromDb(ctx context.Context) ([]ComponentBluePrint, error) {
	cursor, err := tr.collection.Find(ctx, bson.D{})
	if err != nil {
		return nil, err
	}
	defer cursor.Close(ctx)

	var componentBluePrints []ComponentBluePrint

	if err := cursor.All(ctx, &componentBluePrints); err != nil {
		return nil, err
	}

	return componentBluePrints, nil
}

// FetchLayoutTreeForShop fetches the layout tree for a specific shop ID
func (tr *TemplateRepository) FetchLayoutTreeForShop(ctx context.Context, shopID string) (*types.LayoutNode, error) {
	var layout struct {
		ShopID string            `bson:"shop_id"`
		Root   *types.LayoutNode `bson:"root"`
	}

	err := tr.layoutCollection.FindOne(ctx, bson.M{"shop_id": shopID}).Decode(&layout)
	if err != nil {
		if err == mongo.ErrNoDocuments {
			return nil, nil // No layout found for this shop
		}
		return nil, err
	}

	return layout.Root, nil
}
