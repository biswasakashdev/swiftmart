# SwiftMart --- Global Agent Instructions

## Read First

Before making any change in this repository, read:

1.  `docs/requirements.md`
2.  `docs/architecture.md`
3.  `docs/rules.md`
4.  `docs/phases.md`
5.  The nearest module-specific `AGENTS.md`

## Mission

SwiftMart is a multi-tenant e-commerce platform that lets businesses
create stores, publish products, manage inventory, process
orders/payments and expose a GraphQL API without requiring merchants to
build their own backend.

The system is domain-oriented and service-owned. Preserve that
architecture.

## Repository Structure

The repository has three important application boundaries:

```text
/services/     Backend microservices
/web/          React + pnpm merchant application
/proto/        Shared Protocol Buffer contracts
```

Backend services:

```text
/services/gateway
/services/accounts
/services/orders
/services/catalogue
/services/inventory
/services/semantic-search
```

The React application is:

```text
/web
```

## Global Rules

- Never bypass service boundaries.
- Never access another service's database.
- Use gRPC for synchronous internal communication.
- Use shared Protocol Buffers under `/proto`.
- Use Buf and Make for code generation.
- Use Kafka for workflows requiring asynchronous
  processing/serialization.
- Preserve tenant context across service calls.
- Treat authorization as mandatory for protected operations.
- Do not expose internal services directly to normal clients.
- Keep generated code reproducible.
- Never commit secrets or local build artifacts.
- Do not introduce undocumented environment-variable dependencies.
- Follow the module-specific rules before editing a module.

## Change Procedure

When implementing a feature:

1.  Identify the owning domain.
2.  Identify the service under `/services` that owns that domain.
3.  Identify whether `/web` is also affected.
4.  Check whether the protobuf contract must change.
5.  Update `/proto` if required.
6.  Regenerate generated code using Make/Buf.
7.  Implement the smallest required changes.
8.  Update tests.
9.  Validate affected modules.
10. Update documentation if architecture/requirements changed.

## Do Not

- Create a new microservice merely to solve a small implementation
  problem.
- Duplicate domain state across services without an explicit reason.
- Put business logic in GraphQL resolvers.
- Put payment-provider logic throughout the order domain.
- Use Redis as an undocumented primary database.
- Assume Kafka delivers each message exactly once.
- Assume downstream services are always available.
- Log secrets.
- Make the React app call internal services directly.

## Definition of Done

A change is complete only when:

- It follows the architecture.
- Tenant isolation remains correct.
- Appropriate tests exist.
- Generated contracts are synchronized.
- No secrets/artifacts are introduced.
- Relevant documentation is updated.
- Relevant validation commands have been run.
