# Web Agent Instructions

## Location

`/web`

## Role

The `/web` module is SwiftMart's React merchant/business control center.

Technology: - React - pnpm

## Responsibilities

-   Store management.
-   Product management.
-   Inventory management.
-   Order management.
-   User management.
-   Roles and permissions.

## Rules

-   Communicate through the public gateway/API.
-   Never call internal microservices directly.
-   Do not embed secrets in frontend code.
-   Do not store API keys insecurely.
-   Handle loading, errors and authorization failures.
-   Keep API/data access separate from UI components.
-   Follow existing React project conventions before introducing a new
    architecture.

## Build Artifacts

Do not commit: - `node_modules/` - `dist/` - `build/` - `coverage/` -
`.pnpm-store/`
