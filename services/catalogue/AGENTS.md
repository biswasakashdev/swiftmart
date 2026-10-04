# Catalogue Agent Instructions

## Location

`/services/catalogue`

## Role

The catalogue service owns product/catalogue data.

Technology: Go.

## Owns

-   Products.
-   Product metadata.
-   Categories.
-   Publication/catalogue state.

## Rules

-   Do not own inventory quantity.
-   Do not query other service databases.
-   Expose catalogue operations through gRPC.
-   Keep handlers thin.
-   Use explicit error handling.
-   Use context propagation.
-   Redis is a cache only; catalogue persistence remains the source of
    truth.

## Performance

Frequently read product data may use Redis.

Cache invalidation/update behavior must be deliberate and tested.
