package clients

import (
	"log"

	accountspbv1 "github.com/biswasakashdev/swiftmart/services/gateway/proto_gen/accounts/v1"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"

	cnfg "github.com/biswasakashdev/swiftmart/services/gateway/internal/config"
)

func NewUsersClient(cfg *cnfg.Config) accountspbv1.UserServiceClient {
	conn, err := grpc.NewClient(cfg.UsersClient, grpc.WithTransportCredentials(insecure.NewCredentials()))

	if err != nil {
		log.Fatal("Error to build the client connection")
	}
	return accountspbv1.NewUserServiceClient(conn)

}
