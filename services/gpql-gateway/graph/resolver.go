package graph

import grpclients "github.com/biswasakashdev/swiftmart/services/gpql-gateway/grpc_clients"

// This file will not be regenerated automatically.
//
// It serves as dependency injection for your app, add any dependencies you require
// here.

type Resolver struct {
	Clients *grpclients.GrpcClients
}
