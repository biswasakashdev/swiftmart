package resolvers

import accountsv1 "github.com/biswasakashdev/swiftmart/services/gateway/proto_gen/accounts/v1"

// This file will not be regenerated automatically.
//
// It serves as dependency injection for your app, add any dependencies you require
// here.

type Resolver struct {
	UsersClient accountsv1.UserServiceClient
}
