package main

import (
	"github.com/biswasakashdev/swiftmart/services/gateway/internal/clients"
	cnfg "github.com/biswasakashdev/swiftmart/services/gateway/internal/config"
)


func main(){

	cfg := cnfg.Load()

	usersClient :=clients.NewUsersClient(&cfg)


}