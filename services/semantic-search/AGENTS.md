# Semantic Search Agent Instructions

## Location

`/services/semantic-search`

## Role

The semantic-search service provides natural-language product search and
recommendations.

Technology: Java + Spring Boot.

## Responsibilities

-   Semantic query processing.
-   Product retrieval/ranking.
-   Search-history-based recommendations.
-   User intent parsing.

## Rules

-   Do not become the source of truth for catalogue product state.
-   Do not directly query catalogue's database.
-   Consume data through documented APIs/events/indexing workflows.
-   Keep search infrastructure replaceable.
-   Separate indexing from query-serving logic.
-   Do not leak tenant data across searches.

## Tenant Isolation

Search results must always be scoped correctly to the requesting
store/tenant.
