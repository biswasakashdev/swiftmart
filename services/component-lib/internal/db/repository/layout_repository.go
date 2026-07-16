package repository

import (
	"context"

	"github.com/biswasakashdev/swiftmart/services/component-lib/internal/types"
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
func (lr *LayoutRepository) FetchLayoutTreeForShop(ctx context.Context, shopID string) (*types.LayoutNode, error) {
	var layoutNode types.LayoutNode

	filter := bson.M{"shop_id": shopID}
	err := lr.collection.FindOne(ctx, filter).Decode(&layoutNode)
	if err != nil {
		if err == mongo.ErrNoDocuments {
			return nil, nil // No layout found for this shop
		}
		return nil, err
	}

	return &layoutNode, nil
}