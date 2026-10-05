# SwiftMart --- Development Phases

This file is the project's execution roadmap and current-progress
source.

> Status values: `PLANNED`, `IN PROGRESS`, `BLOCKED`, `COMPLETE`.

## Phase 0 --- Repository Foundation

Status: `COMPLETE`

Goals:

- Establish repository layout.
- Backend services under `/services`.
- React/pnpm application under `/web`.
- Add global documentation.
- Add service-specific `AGENTS.md` files.
- Add root Makefile.
- Establish `.gitignore`.
- Establish Buf configuration.
- Create initial proto package structure.

Exit criteria:

- Repository structure is agreed.
- Proto generation works.
- Common development commands are documented.

## Phase 1 --- Service Contracts

Status: `INPROGRESS`

Goals:

- Define accounts proto.
- Define catalogue proto.
- Define inventory proto.
- Define orders proto.
- Define semantic-search proto.
- Define template-agent proto
- Define template-engine proto
- Define shared/common types.
- Configure Buf linting and generation.
- Add Make targets.

Exit criteria:

- Proto definitions compile.
- Generated clients/servers can be produced for all required
  languages.
- No service maintains a duplicate contract definition.

## Phase 2 --- Accounts and Multi-Tenancy

Status: `PLANNED`

Build:

- User management.
- Store/business creation.
- Store membership.
- Roles.
- Permissions.
- Custom RBAC.
- Tenant isolation.

Exit criteria:

- A user can create/manage stores.
- Users can be assigned roles.
- Permissions can be evaluated.
- Cross-tenant access is rejected.

## Phase 3 --- Catalogue

Status: `PLANNED`

Build `/services/catalogue`:

- Product CRUD.
- Product metadata.
- Categories.
- Publication state.
- Catalogue gRPC API.
- Database ownership.
- Initial Redis caching.

Exit criteria:

- Products can be created and retrieved.
- Tenant isolation works.
- Cache behavior is tested.

## Phase 4 --- Inventory

Status: `PLANNED`

Build `/services/inventory`:

- Stock records.
- Stock updates.
- Availability.
- Inventory gRPC API.
- Transactional stock mutations.
- Integration boundary for order-driven stock changes.

Exit criteria:

- Inventory mutations are consistent.
- Concurrent updates are handled safely.

## Phase 5 --- Orders and Payments

Status: `PLANNED`

Build `/services/orders`:

- Order lifecycle.
- Order persistence.
- Razorpay integration.
- Payment state.
- Resilience4j circuit breaker.
- Timeout/error handling.

Exit criteria:

- Orders can be created.
- Payment failures are handled safely.
- Circuit breaker protects payment dependency.
- Duplicate payment/order processing is controlled.

## Phase 6 --- Kafka Stock Processing

Status: `PLANNED`

Build:

- Order events.
- Kafka topics.
- Consumers.
- Idempotent processing.
- Serialized stock mutation workflow.

Exit criteria:

- Concurrent purchases cannot incorrectly oversell stock.
- Duplicate events do not corrupt inventory.
- Failure/retry behavior is tested.

## Phase 7 --- GraphQL Gateway

Status: `PLANNED`

Build `/services/gateway`:

- GraphQL schema.
- Gateway authentication.
- API-key authentication.
- Tenant resolution.
- Authorization.
- gRPC downstream calls.
- Error mapping.
- Request/correlation context.

Exit criteria:

- External clients can operate the platform through GraphQL.
- Internal services remain inaccessible directly to normal clients.

## Phase 8 --- Semantic Search

Status: `PLANNED`

Build `/services/semantic-search`:

- Search ingestion.
- Semantic query parsing.
- Product retrieval.
- Recommendation logic.
- Search-history support where appropriate.

Exit criteria:

- Natural-language product queries return relevant results.
- Search does not violate catalogue ownership.

## Phase 9 --- React Control Center

Status: `PLANNED`

Build `/web`:

- Authentication.
- Store dashboard.
- Product management.
- Inventory management.
- Order management.
- User/role management.

Exit criteria:

- Merchant can manage the business without direct API interaction.
- Web application communicates only through the gateway/public API.

## Phase 10 --- Containerization

Status: `PLANNED`

Build:

- Dockerfiles for `/services/*`.
- Web container/build if required.
- Local service orchestration.
- Local databases/dependencies.
- Health checks.

Exit criteria:

- Full system starts locally in containers.

## Phase 11 --- Kubernetes

Status: `PLANNED`

Build:

- Deployments.
- Services.
- ConfigMaps.
- Secrets strategy.
- Ingress/API entry.
- Local Kubernetes deployment.

Exit criteria:

- Platform operates in local Kubernetes.

## Phase 12 --- ArgoCD / GitOps

Status: `PLANNED`

Build:

- Kubernetes manifests/Helm structure as appropriate.
- ArgoCD applications.
- Git-based deployment.
- Environment configuration.

Exit criteria:

- A committed change can flow through the deployment pipeline.

## Phase 13 --- Hardening

Status: `PLANNED`

Focus:

- Security review.
- Tenant-isolation tests.
- Load testing.
- Failure testing.
- Kafka failure/retry testing.
- Payment dependency failure testing.
- Redis failure testing.
- Observability.
- Documentation completeness.

## Current Work

```text
Current phase: Phase 0 — Repository Foundation
Current status: IN PROGRESS
Current focus:
- Establish agent documentation.
- Establish repository conventions.
- Establish shared proto/Make/Buf workflow.

Next:
- Define and validate service contracts.
```

Agents must update this section only when a project task explicitly
changes the active phase/status.
