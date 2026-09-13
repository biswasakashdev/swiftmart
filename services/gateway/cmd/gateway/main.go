package main

import (
	"log"
	"net/http"

	"github.com/99designs/gqlgen/graphql/handler"
	"github.com/99designs/gqlgen/graphql/handler/extension"
	"github.com/99designs/gqlgen/graphql/handler/lru"
	"github.com/99designs/gqlgen/graphql/handler/transport"
	"github.com/99designs/gqlgen/graphql/playground"
	"github.com/biswasakashdev/swiftmart/services/gateway/internal/clients"
	cnfg "github.com/biswasakashdev/swiftmart/services/gateway/internal/config"
	"github.com/biswasakashdev/swiftmart/services/gateway/internal/gqlgen"
	"github.com/biswasakashdev/swiftmart/services/gateway/internal/resolvers"
	"github.com/vektah/gqlparser/v2/ast"
)

func main() {

	cfg := cnfg.Load()

	usersClient := clients.NewUsersClient(&cfg)

	resolvr := resolvers.Resolver{
		UsersClient: usersClient,
	}

	srv := handler.New(gqlgen.NewExecutableSchema(gqlgen.Config{Resolvers: &resolvr}))

	srv.AddTransport(transport.Options{})
	srv.AddTransport(transport.GET{})
	srv.AddTransport(transport.POST{})

	srv.SetQueryCache(lru.New[*ast.QueryDocument](1000))

	srv.Use(extension.Introspection{})
	srv.Use(extension.AutomaticPersistedQuery{
		Cache: lru.New[string](100),
	})

	http.Handle("/", playground.Handler("GraphQL playground", "/query"))
	http.Handle("/query", srv)

	log.Printf("connect to http://localhost:%s/ for GraphQL playground", cfg.Port)
	log.Fatal(http.ListenAndServe(":"+cfg.Port, nil))

}
