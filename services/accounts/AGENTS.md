# Accounts Agent Instructions

## Location

`/services/accounts`

## Role

The accounts service owns identity/account and authorization-domain
data.

Technology: Java + Spring Boot WebFlux.

## Owns

-   Users.
-   Stores/businesses.
-   Store memberships.
-   Roles.
-   Permissions.
-   Account authorization metadata.

## Rules

-   Never own catalogue/inventory/order state.
-   Enforce tenant/store relationships.
-   Use constructor injection.
-   Keep RPC endpoints thin.
-   Keep business logic in service/domain layers.
-   Do not expose persistence entities directly.
-   Do not block WebFlux threads.
-   Validate authorization-sensitive operations.

## Testing

Test user creation, store creation, membership, role assignment,
permission evaluation and cross-tenant access rejection.
