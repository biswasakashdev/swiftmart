package grpclients

import (
	cfg "github.com/biswasakashdev/swiftmart/internal/gpql_gateway/config"
	cateloguespb "github.com/biswasakashdev/swiftmart/proto_gen/go/catelogues/v1"
	corepb "github.com/biswasakashdev/swiftmart/proto_gen/go/core/v1"
	orderspb "github.com/biswasakashdev/swiftmart/proto_gen/go/orders/v1"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

type GrpcClients struct {
	ProductClient cateloguespb.ProductsServiceClient
	OrdersClient  orderspb.OrderServiceClient
	UsersClient   corepb.UsersServiceClient
	ShopClient    corepb.ShopsServiceClient
}

func NewGrpcClient(config *cfg.Config) (*GrpcClients, error) {
	coreConn, err := grpc.NewClient(
		config.CoreServiceAddr,
		grpc.WithTransportCredentials(insecure.NewCredentials()),
	)
	if err != nil {
		return nil, err
	}

	ordersConn, err := grpc.NewClient(
		config.OrderServiceAddr,
		grpc.WithTransportCredentials(insecure.NewCredentials()),
	)
	if err != nil {
		return nil, err
	}

	cateloguesConn, err := grpc.NewClient(
		config.CatelogueServiceAddr,
		grpc.WithTransportCredentials(insecure.NewCredentials()),
	)
	if err != nil {
		return nil, err
	}
	return &GrpcClients{
		UsersClient:   corepb.NewUsersServiceClient(coreConn),
		ProductClient: cateloguespb.NewProductsServiceClient(cateloguesConn),
		OrdersClient:  orderspb.NewOrderServiceClient(ordersConn),
		ShopClient:    corepb.NewShopsServiceClient(coreConn),
	}, nil
}
