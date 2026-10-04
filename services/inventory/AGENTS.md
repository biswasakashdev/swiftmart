# Inventory Agent Instructions

## Location

`/services/inventory`

## Role

The inventory service owns stock state.

Technology: Java + Spring Boot.

## Owns

-   Stock quantities.
-   Inventory state.
-   Availability.
-   Stock mutation rules.

## Rules

-   No other service may write inventory data directly.
-   Enforce tenant/store ownership.
-   Use transactional consistency for stock mutations.
-   Integrate with Kafka-driven order processing where required.
-   Handle duplicate events safely.
-   Never assume a request can mutate stock without validating current
    state.

## Overselling

Inventory correctness has priority over convenience.

Any stock mutation workflow must explicitly address concurrent purchases
and duplicate processing.
