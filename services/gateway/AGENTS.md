# Gateway Agent Instructions

## Location

`/services/gateway`

## Role

The gateway is SwiftMart's external entry point.

Technology: Go + GraphQL + gRPC.

## Owns

-   GraphQL API.
-   Request authentication.
-   API-key authentication.
-   Tenant/store context resolution.
-   Authorization enforcement.
-   Downstream gRPC orchestration.
-   External error mapping.

## Does Not Own

-   Product persistence.
-   Inventory persistence.
-   Order persistence.
-   Account persistence.

## Rules

-   Do not put domain persistence in the gateway.
-   Do not bypass gRPC to call databases.
-   Keep GraphQL resolvers thin.
-   Preserve request context and tenant identity.
-   Never log API keys/tokens.
-   Avoid GraphQL N+1 calls.
-   Use context-aware gRPC calls.
-   Keep external schema independent from internal implementation
    details.
