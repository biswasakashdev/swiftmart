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
	appRoutes "github.com/biswasakashdev/swiftmart/services/gateway/internal/routes"
	"github.com/go-chi/chi/v5"
	chiMiddleWare "github.com/go-chi/chi/v5/middleware"
	"github.com/vektah/gqlparser/v2/ast"
)

func main() {

	router := chi.NewRouter()

	router.Use(chiMiddleWare.Logger)

	cfg := cnfg.Load()

	usersClient := clients.NewUsersClient(&cfg)

	resolvr := resolvers.Resolver{
		UsersClient: usersClient,
	}

	/*
		Creating routes and handlers
	*/

	// Graphql handler
	srv := handler.New(gqlgen.NewExecutableSchema(gqlgen.Config{Resolvers: &resolvr}))

	srv.AddTransport(transport.Options{})
	srv.AddTransport(transport.GET{})
	srv.AddTransport(transport.POST{})

	srv.SetQueryCache(lru.New[*ast.QueryDocument](1000))

	srv.Use(extension.Introspection{})
	srv.Use(extension.AutomaticPersistedQuery{
		Cache: lru.New[string](100),
	})

	// Creating auth router

	authRouter := appRoutes.NewAuthHandler(usersClient, &cfg)

	// Add the graphql handler to the router
	router.Handle("/playground", playground.Handler("GraphQL playground", "/api/query"))
	router.Handle("/api/query", srv)

	// Add the auth handlers
	router.Mount("/api/v1/auth", authRouter)

	log.Printf("connect to http://localhost:%s/playground for GraphQL playground", cfg.Port)
	log.Fatal(http.ListenAndServe(":"+cfg.Port, router))

}
