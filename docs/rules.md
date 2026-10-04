# SwiftMart --- Engineering Rules

These rules apply to every contributor and coding agent.

## 1. Source of Truth

Before modifying code:

1.  Read `requirements.md`.
2.  Read `architecture.md`.
3.  Read this file.
4.  Read the nearest applicable `AGENTS.md`.
5.  Read `phases.md` to understand current scope.

Do not invent architecture that conflicts with these documents.

## 2. Repository Structure

All backend services are under:

``` text
/services/
```

The React/pnpm frontend is the root-level:

``` text
/web/
```

Shared Protocol Buffers are under:

``` text
/proto/
```

Deployment/platform configuration is under:

``` text
/infrastructure/
```

Do not move modules between these locations without an explicit
architectural change.

## 3. Domain Isolation

Every service owns its domain.

Never:

-   Query another service's database.
-   Import another service's internal persistence package.
-   Reuse another service's domain entity as if it were local.
-   Bypass gRPC to access another service's business logic.

Use:

-   gRPC.
-   Shared Protocol Buffers.
-   Kafka events for asynchronous workflows.

## 4. Multi-Tenant Isolation

Tenant/store context must be explicit.

Every tenant-owned operation must verify:

-   Tenant/store identity.
-   User identity where applicable.
-   Required permission.

Never trust tenant IDs supplied by clients without authorization.

## 5. API Contracts

All internal RPC contracts belong under `/proto`.

Rules:

-   Edit `.proto` files rather than generated code.
-   Regenerate code with Buf/Make.
-   Do not manually patch generated protobuf code.
-   Avoid unnecessary breaking changes.
-   Keep package/version naming consistent.

## 6. Makefile

Common repository operations should be exposed through Make targets.

Expected categories:

``` text
make proto
make proto-lint
make proto-breaking
make test
make build
make docker-build
make docker-up
make k8s
```

Use the actual repository targets when they already exist; do not
duplicate commands unnecessarily.

## 7. Java Rules

Applies to:

``` text
/services/accounts
/services/orders
/services/inventory
/services/semantic-search
```

Use:

-   Standard Spring Boot project structure.
-   Clear package boundaries.
-   Constructor injection.
-   Immutable DTOs where practical.
-   Service/domain/repository separation.
-   Reactive APIs in WebFlux services.
-   Proper exception handling.
-   Unit and integration tests.

Do not:

-   Use field injection.
-   Put business logic in controllers.
-   Expose persistence entities directly as public API DTOs.
-   Block reactive threads with blocking calls.
-   Put unrelated domains into one service.

Ignore:

``` text
target/
*.class
```

## 8. Go Rules

Applies to:

``` text
/services/gateway
/services/catalogue
```

Use:

-   `cmd/` for application entrypoints where appropriate.
-   `internal/` for private implementation.
-   Small interfaces defined near their consumers.
-   Explicit error handling.
-   Context propagation.
-   Structured logging.
-   Tests alongside packages.

Avoid:

-   Global mutable state.
-   Huge handler functions.
-   Hidden goroutines.
-   Ignoring returned errors.
-   Leaking implementation details from internal packages.

Ignore:

``` text
bin/
dist/
*.exe
coverage.out
```

## 9. React/Web Rules

Applies to:

``` text
/web
```

The web application uses pnpm.

Use:

-   Component-based architecture.
-   Feature-oriented organization where practical.
-   Typed API models.
-   Reusable UI components.
-   Clear separation between API/data code and presentation.
-   Proper loading/error states.

Do not:

-   Call internal microservices directly.
-   Embed secrets in browser code.
-   Commit package-manager artifacts.

Ignore:

``` text
node_modules/
dist/
build/
coverage/
.pnpm-store/
```

## 10. Generated Files

Generated protobuf/client files must not be hand-edited.

Generated files should be reproducible from:

-   `/proto`
-   Buf configuration
-   Make targets
-   Service-specific generation configuration

## 11. Environment Variables

Do not make agents or application code depend on undeclared environment
variables.

Rules:

-   Do not silently read arbitrary environment variables.
-   Document every required runtime configuration.
-   Provide safe local-development defaults where appropriate.
-   Never commit secrets.
-   Never hard-code production credentials.
-   Do not use `.env` files as an undocumented source of required
    application behavior.

If configuration is needed, explicitly define it in the service's
configuration mechanism and document it.

## 12. Secrets

Never commit:

``` text
.env
.env.*
*.pem
*.key
*.crt
credentials.*
secrets.*
```

## 13. Repository Ignore Rules

The root `.gitignore` should cover:

``` text
# Java
/services/**/target/
*.class

# Node / React
/web/node_modules/
**/node_modules/
web/dist/
web/build/
web/coverage/
web/.pnpm-store/

# Go
/services/**/bin/
coverage.out

# IDE
.idea/
.vscode/
*.iml

# OS
.DS_Store
Thumbs.db

# Secrets
.env
.env.*
*.pem
*.key
*.secret

# Logs
*.log

# Temporary
tmp/
temp/
```

Keep this list aligned with actual repository tooling.

## 14. Docker

Each backend service should have a reproducible container build.

Rules:

-   Prefer multi-stage builds.
-   Do not bake secrets into images.
-   Keep runtime images minimal.
-   Pin important dependency/base-image versions where practical.
-   Do not run unnecessary processes inside one container.
-   Use health/readiness checks where appropriate.

## 15. Kubernetes

Rules:

-   One workload should have a clear ownership boundary.
-   Use Deployments for stateless services unless another workload type
    is justified.
-   Configure readiness/liveness appropriately.
-   Use Services for internal discovery.
-   Do not expose internal services publicly unless required.
-   Store Kubernetes manifests under the infrastructure/deployment area.
-   Never commit plaintext production secrets.

## 16. ArgoCD

ArgoCD is the GitOps deployment mechanism.

Rules:

-   Git is the desired-state source.
-   Do not manually modify live resources as a normal deployment
    process.
-   Deployment changes should be reviewable in Git.
-   Application definitions must identify the intended environment and
    manifests.

## 17. Logging

Never log:

-   API keys.
-   Passwords.
-   Payment credentials.
-   Authorization tokens.
-   Sensitive personal information.

Use correlation/request IDs for tracing requests across services.

## 18. Error Handling

Errors should:

-   Be explicit.
-   Preserve useful context.
-   Avoid leaking internals to external users.
-   Map correctly between gRPC and GraphQL boundaries.
-   Be distinguishable between client errors, dependency errors and
    internal errors.

## 19. Testing

New functionality should include appropriate tests.

At minimum where applicable:

-   Unit tests for business logic.
-   API/RPC tests.
-   Integration tests for persistence.
-   Contract tests for important service boundaries.
-   Consumer tests for Kafka processing.

Do not delete failing tests simply to make CI green.

## 20. Kafka

Kafka consumers must be designed for duplicate delivery.

Rules:

-   Assume at-least-once delivery unless explicitly guaranteed
    otherwise.
-   Make handlers idempotent.
-   Validate event payloads.
-   Handle retries deliberately.
-   Do not acknowledge messages before required processing is safely
    complete.

## 21. Redis

Use cache-aside or another explicitly documented strategy.

Rules:

-   Database remains the source of truth.
-   Define TTLs deliberately.
-   Handle cache misses.
-   Handle Redis failure without corrupting domain state.
-   Invalidate/update cache when domain data changes where necessary.

## 22. Resilience4j

Circuit breakers must protect external/downstream dependencies,
especially payment integration.

Configure deliberately:

-   Failure thresholds.
-   Slow-call thresholds.
-   Open/half-open/closed behavior.
-   Timeouts.
-   Retry policy where justified.

Do not blindly retry non-idempotent payment operations.

## 23. Code Generation Agents

When generating code:

1.  Inspect existing patterns first.
2.  Follow the nearest `AGENTS.md`.
3.  Reuse existing abstractions.
4.  Do not create duplicate utilities.
5.  Do not modify unrelated services.
6.  Update tests.
7.  Update proto contracts before generated implementations.
8.  Run the narrowest relevant tests.
9.  Report files changed and validation performed.

## 24. Change Scope

A task should modify the smallest number of services necessary.

If a change crosses service boundaries:

1.  Identify the contract change.
2.  Update `/proto`.
3.  Regenerate code.
4.  Update producers/consumers.
5.  Update tests.
6.  Update relevant documentation.

## 25. Documentation

Architectural decisions must be reflected in the project documentation
and relevant module `AGENTS.md` files.
