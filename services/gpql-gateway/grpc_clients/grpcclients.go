package grpclients

import (
	cfg "github.com/biswasakashdev/swiftmart/services/gpql-gateway/config"
	orderspb "github.com/biswasakashdev/swiftmart/services/gpql-gateway/proto_gen/orders/v1"
	productspb "github.com/biswasakashdev/swiftmart/services/gpql-gateway/proto_gen/products/v1"
	userspb "github.com/biswasakashdev/swiftmart/services/gpql-gateway/proto_gen/users/v1"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

type GrpcClients struct {
	ProductClient productspb.ProductsServiceClient
	OrdersClient  orderspb.OrderServiceClient
	UserClient    userspb.UsersServiceClient
}

func NewGrpcClient(config *cfg.Config) (*GrpcClients, error) {
	usersConn, err := grpc.NewClient(
		"localhost:50051",
		grpc.WithTransportCredentials(insecure.NewCredentials()),
	)
	if err != nil {
		return nil, err
	}

	ordersConn, err := grpc.NewClient(
		"localhost:50052",
		grpc.WithTransportCredentials(insecure.NewCredentials()),
	)
	if err != nil {
		return nil, err
	}

	productsConn, err := grpc.NewClient(
		"localhost:50053",
		grpc.WithTransportCredentials(insecure.NewCredentials()),
	)
	if err != nil {
		return nil, err
	}
	return &GrpcClients{
		UserClient:    userspb.NewUsersServiceClient(usersConn),
		ProductClient: productspb.NewProductsServiceClient(productsConn),
		OrdersClient:  orderspb.NewOrderServiceClient(ordersConn),
	}, nil
}
