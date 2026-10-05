# SwiftMart --- Project Requirements

## 1. Project Overview

SwiftMart is a multi-tenant e-commerce platform designed to let
businesses create and operate one or more online stores without needing
to build and maintain their own backend.

The platform allows a business to:

- Create and manage multiple e-commerce stores.
- Manage users and customizable roles.
- Publish products and stock.
- Manage inventory.
- Process customer orders.
- Accept payments through Razorpay.
- Search and discover products using semantic search.
- Manage the business through a React-based console.
- Scale domain services independently.

The core architectural principle is **domain ownership**: each
microservice owns its domain data and business rules. Other services
must not directly access another service's database.

## 2. Primary Goals

1.  Build a production-oriented multi-tenant e-commerce platform.
2.  Keep business domains isolated into independently deployable
    services.
3.  Use gRPC and Protocol Buffers for internal service communication.
4.  Prevent inventory overselling during concurrent order processing.
5.  Make payment processing resilient to third-party failures.
6.  Reduce database read load with Redis caching.
7.  Provide semantic product search and recommendations.
8.  Containerize the platform and deploy it to Kubernetes.
9.  Use ArgoCD for GitOps-based deployment.
10. Provide a React control center for managing stores, products,
    inventory, users and roles.
11. Make the platform usable without requiring merchants to write
    backend code.

## 3. Functional Requirements

### 3.1 Multi-Tenancy

- A platform user can create multiple e-commerce stores.
- Each store represents an isolated business tenant.
- Tenant-owned data must always be scoped to the correct tenant/store.
- Authorization must prevent users from accessing another tenant's
  resources.
- Services must preserve tenant context across gRPC calls.

### 3.2 Accounts and Identity

The accounts service manages:

- User accounts.
- Store/business membership.
- Roles.
- Permissions.
- Customizable role-based access control.
- Authentication-related domain data.
- Authorization metadata required by downstream services.

Users must be able to assign different permissions to members of their
business.

### 3.3 Gateway

The gateway is the platform entry point.

Responsibilities:

- Receive client requests.
- Authenticate requests.
- Resolve tenant/store context.
- Authorize requests.
- Expose GraphQL.
- Translate GraphQL operations into downstream gRPC calls.
- Protect downstream services from unauthorized traffic.
- Apply resilience and request policies where appropriate.

Clients should not need direct access to internal services.

### 3.4 Catalogue

The catalogue service owns product/catalogue information.

Responsibilities include:

- Product creation and updates.
- Product descriptions and metadata.
- Product categorization.
- Product publication state.
- Product information used by storefronts.
- Product data required by search.

The catalogue service owns its catalogue database.

### 3.5 Inventory

The inventory service owns stock state.

Responsibilities include:

- Stock quantities.
- Inventory updates.
- Stock reservations/decrements as defined by the order workflow.
- Inventory consistency.
- Product stock availability.

Inventory must not be modified directly by unrelated services through
database access.

### 3.6 Orders

The orders service owns:

- Order creation.
- Order state.
- Order lifecycle.
- Payment-related order state.
- Order processing.
- Communication with inventory and payment-related flows.
- Kafka-driven order processing where required.

Order processing must prevent overselling by serializing relevant
stock-changing operations.

### 3.7 Payments

Razorpay is the external payment provider.

Requirements:

- Integrate Razorpay through a clearly isolated payment integration
  boundary.
- Do not spread Razorpay-specific implementation throughout domain
  code.
- Handle third-party failures and delays gracefully.
- Use Resilience4j circuit breaker behavior in the order/payment flow.
- When the payment dependency is failing or excessively slow, trip the
  circuit and prevent unnecessary additional requests from reaching
  the failing dependency.

### 3.8 Kafka Order Processing

Kafka is used to process order-related stock changes.

Goals:

- Serialize conflicting stock changes.
- Reduce race conditions during concurrent purchases.
- Avoid overselling.
- Support asynchronous processing where appropriate.
- Keep consumers idempotent.

Messages should contain enough information to process an event safely
without relying on another service's database.

### 3.9 Redis

Redis is used primarily to reduce read pressure on databases.

Expected uses include:

- Frequently accessed product/catalogue data.
- Cache-aside patterns where appropriate.
- Short-lived data required for performance.
- Permission/authorization data where appropriate.

Caching must never become an uncontrolled second source of truth.

### 3.10 Semantic Search

The semantic-search service provides:

- Semantic product search.
- Natural-language product queries.
- Product recommendations based on search behavior/history where
  supported.
- Parsing of user intent into meaningful product search criteria.
- Integration with catalogue data through service/API boundaries
  rather than direct database ownership violations.

The implementation should keep search infrastructure replaceable.

### 3.11 GraphQL

GraphQL is the external query interface.

Requirements:

- Provide a stable client-facing schema.
- Resolve fields through appropriate downstream service calls.
- Avoid exposing internal service contracts directly.
- Respect tenant and authorization context.
- Avoid accidental N+1 downstream calls.
- Use batching/caching techniques where appropriate.
- Return useful errors without exposing internal implementation
  details.

### 3.13 React Client Console

The React application provides the merchant/business control center.

It should allow authorized users to manage:

- Stores.
- Products.
- Inventory.
- Orders.
- Users.
- Roles.
- Permissions.
- Business configuration.

The client communicates through the public gateway/API boundary.

### 3.14 Template Agent

Template Agent is an AI-agent which build personalised store fronts with multi pages, in HTMX and TailwindCSS based on the needs of the merchant/business owner. It should be able to generate a custom theme for the store based on the merchant's requirements and with url slug and store.

User can give prompt about the store want to build and the agent will generate the store fronts with pages like home, about, contact, products, category, etc. Pages should be interlinked and should be able to navigate through the pages. The template agent will use semantic search service to get the product data from the catalogue service and use the inventory service to get the stock data. Use redis for caching the product data and inventory data.

### 3.15 Template Engine

It compile the generated page componenets and map the url with the template and build the page on runtime and collects data from other services using grpc and return a complete html page which can be directly served to the client. It should also support cache the page on redis for fast access. It should also be able to handle dynamic data which changes frequently and should be able to update the page on runtime.

## 4. Non-Functional Requirements

### Scalability

Services must be independently scalable.

### Availability

Failure in one downstream dependency should not unnecessarily take down
unrelated domains.

### Security

- Authenticate external requests.
- Authorize every protected operation.
- Enforce tenant isolation.
- Do not expose secrets in logs.
- Do not hard-code credentials.
- Validate all externally supplied input.

### Observability

The architecture should support:

- Structured logging.
- Correlation/request IDs.
- Metrics.
- Distributed tracing where introduced.
- Health/readiness endpoints.

### Performance

- Use gRPC internally.
- Use Redis for suitable high-read workloads.
- Avoid unnecessary database round trips.
- Avoid GraphQL N+1 patterns.
- Use asynchronous Kafka processing where it improves
  correctness/scalability.

## 5. Infrastructure Requirements

- Dockerize services.
- Run the platform locally on Kubernetes.
- Use Kubernetes-native configuration.
- Use Makefiles for common development commands.
- Use Buf CLI for Protocol Buffer generation.
- Keep all shared `.proto` definitions under `/proto`.
- Use ArgoCD for GitOps deployment.
- Build a pipeline capable of deploying service changes from a commit.

## 6. Repository Requirements

The repository root contains:

- `/proto` --- shared Protocol Buffer definitions.
- `/Makefile` --- common repository commands.
- Service directories.
- Client directory.
- Infrastructure/deployment configuration.
- Agent documentation.

The exact service directory names must remain consistent with
`architecture.md`.

## 7. Success Criteria

SwiftMart is successful when a merchant can:

1.  Create a business/store.
2.  Add users.
3.  Create custom roles and permissions.
4.  Publish products.
5.  Maintain stock.
6.  Receive/process orders.
7.  Accept payments.
8.  Search products semantically.
9.  Manage the business from the React console.
10. Expose the store through the GraphQL API.
11. Connect a custom storefront using an API key without implementing a
    separate backend.
12. Deploy the platform locally through containers/Kubernetes and
    through the GitOps pipeline.
