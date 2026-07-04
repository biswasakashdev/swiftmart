package main

import (
	"log"
	"net/http"

	"github.com/99designs/gqlgen/graphql/handler"
	"github.com/99designs/gqlgen/graphql/handler/extension"
	"github.com/99designs/gqlgen/graphql/handler/lru"
	"github.com/99designs/gqlgen/graphql/handler/transport"
	"github.com/99designs/gqlgen/graphql/playground"
	cfg "github.com/biswasakashdev/swiftmart/services/gpql-gateway/config"
	"github.com/biswasakashdev/swiftmart/services/gpql-gateway/graph"
	grpclients "github.com/biswasakashdev/swiftmart/services/gpql-gateway/grpc_clients"
	"github.com/vektah/gqlparser/v2/ast"
)

func main() {

	applicationConfig, err := cfg.Load()

	if err != nil {
		log.Fatal(err)
	}

	grpcClients, err := grpclients.NewGrpcClient(applicationConfig)

	if err != nil {
		log.Fatal(err)
	}

	resolver := &graph.Resolver{
		Clients: grpcClients,
	}

	srv := handler.New(
		graph.NewExecutableSchema(
			graph.Config{
				Resolvers: resolver,
			},
		),
	)

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

	log.Printf("connect to http://localhost:%s/ for GraphQL playground", applicationConfig.Port)
	log.Fatal(http.ListenAndServe(":"+applicationConfig.Port, nil))
}
