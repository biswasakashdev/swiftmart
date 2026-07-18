package repository

import (
	"context"

	"github.com/biswasakashdev/swiftmart/internal/component_lib/models"
	"go.mongodb.org/mongo-driver/v2/bson"
	"go.mongodb.org/mongo-driver/v2/mongo"
)

type LayoutRepository struct {
	collection *mongo.Collection
}

func NewLayoutRepository(dbClient *mongo.Client) *LayoutRepository {
	return &LayoutRepository{
		collection: dbClient.Database("swiftmart").Collection("layouts"),
	}
}

// FetchLayoutTreeForShop fetches the complete layout tree for a given shop ID
func (lr *LayoutRepository) FetchLayoutTreeForShop(ctx context.Context, shopID string) (*models.RootLayout, error) {
	var layout models.RootLayout

	filter := bson.M{"shop_id": shopID}
	err := lr.collection.FindOne(ctx, filter).Decode(&layout)
	if err != nil {
		if err == mongo.ErrNoDocuments {
			return nil, nil // No layout found for this shop
		}
		return nil, err
	}

	return &layout, nil
}
