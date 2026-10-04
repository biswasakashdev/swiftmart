# SwiftMart --- Architecture

## 1. Architectural Style

SwiftMart is a domain-oriented, multi-tenant microservice platform.

Core principles:

- Each service owns its domain and data.
- Services communicate through gRPC using Protocol Buffers.
- External consumers enter through the gateway.
- The gateway exposes GraphQL.
- The `/proto` directory is the shared contract source.
- No service directly queries another service's database.
- Asynchronous workflows use Kafka where ordering/serialization is
  important.
- Redis is a cache/read optimization, not the primary domain database.
- All backend services live under `/services`.
- The React/pnpm application lives at `/web`.

## 2. Repository Layout

```text
/
├── AGENTS.md
├── README.md
├── docs/
│   ├── requirements.md
│   ├── architecture.md
│   ├── rules.md
│   └── phases.md
├── Makefile
├── proto/
│   ├── gateway/
│   ├── accounts/
│   ├── orders/
│   ├── catalogue/
│   ├── inventory/
│   ├── semantic_search/
│   └── common/
├── services/
│   ├── gateway/
│   │   └── AGENTS.md
│   ├── accounts/
│   │   └── AGENTS.md
│   ├── orders/
│   │   └── AGENTS.md
│   ├── catalogue/
│   │   └── AGENTS.md
│   ├── inventory/
│   │   └── AGENTS.md
│   └── semantic-search/
│       └── AGENTS.md
├── web/
│   └── AGENTS.md
└── infrastructure/
    └── AGENTS.md
```

The exact existing directory names must be preserved if they differ from
the proposed structure. Documentation should describe the actual
repository rather than creating duplicate module directories.

## 3. Module Matrix

---

Location Module Technology Primary Responsibility

---

`/services/gateway` gateway Go External entry point, GraphQL,
authentication/authorization,
routing

`/services/accounts` accounts Java + Spring Boot WebFlux Users, stores, roles,
permissions

`/services/orders` orders Java + Spring Boot Orders, payment workflow, order
state

`/services/catalogue` catalogue Go Products and catalogue

`/services/inventory` inventory Java + Spring Boot Stock and inventory

`/services/semantic-search` semantic-search Java + Spring Boot Semantic search and
recommendations

`/web` web React + pnpm Merchant/business control
center

`/proto` proto Protocol Buffers + Buf Shared service contracts

`/infrastructure` infrastructure Docker/Kubernetes/ArgoCD Deployment/platform
infrastructure

---

## 4. Gateway

Location: `/services/gateway`

Technology:

- Go
- GraphQL
- gRPC client
- API-key authentication
- Authentication/authorization middleware

Responsibilities:

1.  Accept external HTTP/GraphQL requests.
2.  Authenticate requests.
3.  Resolve tenant/store identity.
4.  Authorize requests.
5.  Invoke downstream gRPC services.
6.  Return stable external responses.

The gateway is the normal entry point into internal domain services.

## 5. Accounts Service

Location: `/services/accounts`

Technology:

- Java
- Spring Boot
- Spring WebFlux
- gRPC server

Owns:

- Users.
- Stores/businesses.
- Store membership.
- Roles.
- Permissions.
- Account authorization metadata.

It must not own catalogue, inventory, or order state.

## 6. Orders Service

Location: `/services/orders`

Technology:

- Java
- Spring Boot
- gRPC
- Kafka
- Resilience4j
- Razorpay integration

Owns:

- Orders.
- Order state.
- Payment-related order state.
- Order processing.

Important behavior:

- Payment-provider calls are protected by resilience policies.
- Stock-changing operations use Kafka where required to serialize
  conflicting changes.
- Consumers are idempotent.

## 7. Catalogue Service

Location: `/services/catalogue`

Technology:

- Go
- gRPC
- Redis as applicable

Owns:

- Products.
- Product metadata.
- Categories.
- Publication/catalogue state.

Catalogue is the source of truth for product information.

## 8. Inventory Service

Location: `/services/inventory`

Technology:

- Java
- Spring Boot
- gRPC
- Database
- Redis where appropriate

Owns:

- Stock quantities.
- Inventory state.
- Stock availability.
- Inventory mutation rules.

Inventory changes must go through the inventory service.

## 9. Semantic Search

Location: `/services/semantic-search`

Technology:

- Java
- Spring Boot

Responsibilities:

- Semantic product retrieval.
- Natural-language query parsing.
- Search-history-based recommendations.
- Ranking/recommendation logic.

It communicates with domain services through contracts rather than
direct database coupling.

## 10. Web Application

Location: `/web`

Technology:

- React
- pnpm

Responsibilities:

- Merchant dashboard.
- Product management.
- Inventory management.
- Order management.
- User management.
- Role/permission management.
- Store management.

The web application communicates through the public gateway/API
boundary.

It must not directly access internal microservices or their databases.

## 11. Protocol Buffers

Location: `/proto`

All service contracts live here.

Rules:

- Proto definitions are the contract source of truth.
- Use Buf CLI for linting/generation.
- Generated code is produced through Make targets.
- Do not manually edit generated protobuf files.
- Breaking API changes must be deliberate and reviewed.

## 12. Communication

### Synchronous

```text
Web / External Storefront
          |
          v
GraphQL Gateway
          |
          +---- gRPC ----> Accounts
          |
          +---- gRPC ----> Catalogue
          |
          +---- gRPC ----> Inventory
          |
          +---- gRPC ----> Orders
          |
          +---- gRPC ----> Semantic Search
```

### Asynchronous

```text
Order request
     |
     v
Orders Service
     |
     v
Kafka
     |
     v
Stock-changing workflow
     |
     v
Inventory Service
```

## 13. Data Ownership

```text
Accounts      -> Accounts DB
Catalogue     -> Catalogue DB
Inventory     -> Inventory DB
Orders        -> Orders DB
Search        -> Search/index/vector infrastructure
```

No cross-service SQL queries are allowed.

## 14. External Integrations

- Razorpay: payment provider.
- Kafka: asynchronous order/stock processing.
- Redis: caching/read optimization.
- Kubernetes: runtime platform.
- ArgoCD: GitOps deployment.

## 15. Request Security Flow

```text
User / Storefront
      |
      v
GraphQL API
      |
      v
Authenticate API Key / User
      |
      v
Resolve Tenant + User
      |
      v
Authorize Permission
      |
      v
Gateway
      |
      v
gRPC
      |
      v
Domain Service
```

Every downstream request must preserve the context required for tenant
isolation and authorization.
