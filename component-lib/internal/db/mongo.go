package db

import (
	"context"
	"time"

	"github.com/biswasakashdev/swiftmart/component-lib/config"
	"go.mongodb.org/mongo-driver/v2/mongo"
	"go.mongodb.org/mongo-driver/v2/mongo/options"
)

func NewMongoClient(ctx context.Context, conf *config.Config) (*mongo.Client, error) {
	// Generate client
	client, err := mongo.Connect(
		options.Client().
			ApplyURI(conf.MongoURL),
	)
	if err != nil {
		return nil, err
	}

	pingCtx, cancel := context.WithTimeout(ctx, 5*time.Second)
	defer cancel()

	if err := client.Ping(pingCtx, nil); err != nil {
		_ = client.Disconnect(ctx)
		return nil, err
	}

	return client, nil
}
