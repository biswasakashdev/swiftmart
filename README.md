# 🌟 Swiftmart

**Tagline:** _An AI-driven e-commerce SaaS that converts users’ simple prompts into beautiful templates._

---

## 🚀 Overview

Swiftmart is a multi-tenant e-commerce platform inspired by Shopify. It empowers users to create multiple shops with AI-generated dynamic templates, combining modern Spring Boot microservices, gRPC communication, and a GraphQL gateway for seamless scalability.

---

## 🏗️ Architecture

- **Spring Boot Services**
  - Located in the `/services` directory.
  - Built using both **Spring WebFlux** (reactive) and **Spring Web** (traditional).

- **AI Integration**
  - Powered by **LangChain4j**.
  - Uses **Google Gemini** models for template generation.

- **GraphQL Gateway**
  - Central entry point for admin requests:
    - Create store
    - Manage products
    - Update variants & stocks
    - Update orders & inventory
  - **Downstreams requests via gRPC** to other services.
  - gRPC also powers **service-to-service communication** internally.

- **Template Builder**
  - Converts user prompts into JSON-based templates using LLMs.
  - Stores templates in **MongoDB**.

- **Template Engine**
  - Transforms AI-generated JSON schemas into **HTMX** + **Thymeleaf** templates.

- **Semantic Search**
  - Internal semantic search service for improved product discovery.

---

## 📊 Architecture Diagram (Textual)

```
          +-------------------+
          |   GraphQL Gateway |
          +-------------------+
                   |
             (gRPC downstream)
   -------------------------------------
   |            |            |         |
+------+   +-----------+  +--------+  +----------------+
|Store |   |Template   |  |Template|  |Semantic Search |
|Mgmt  |   |Builder    |  |Engine  |  |Service         |
+------+   +-----------+  +--------+  +----------------+
   |             |             |             |
   |             v             v             v
   |        MongoDB       HTMX/Thymeleaf   Product DB
   |
   v
Tenant DB (multi-tenant schema)
```

---

## 🔧 Tech Stack

- **Backend:** Spring Boot (WebFlux + Web)
- **AI:** LangChain4j + Google Gemini
- **Gateway:** GraphQL + gRPC downstream
- **Database:** MongoDB (templates), relational DB for tenants/products
- **Frontend:** HTMX + Thymeleaf
- **Deployment:** Docker, Kubernetes, GitHub Actions (CI/CD)

---

## ⚙️ Installation

To run the application locally:

```bash
docker compose up -d
```

Then open your browser at:

```
http://localhost:3000
```

---

## 🌐 Deployment

- CI/CD pipeline built with **GitHub Actions**.
- Deployed locally using **Kubernetes**.
- Containerized scaling ensures multi-tenant workloads run smoothly.

---

## 📖 Usage

- **Create a Store:** GraphQL mutation → gRPC → Store service.
- **Generate Templates:** Prompt → Gemini via LangChain4j → JSON → MongoDB.
- **Render Templates:** JSON → HTMX + Thymeleaf via Template Engine.
- **Search Products:** Semantic search service enhances relevance.

---

## 🛠️ Contributing

Contributions are welcome!

- Fork the repo
- Create a feature branch
- Submit a pull request

---

## 🗺️ Roadmap

- Analytics dashboard
- Marketplace integration
- AI-driven personalization
- Plugin/module ecosystem

---

## 🙌 Acknowledgements

- **Spring Boot** (WebFlux + Web)
- **LangChain4j**
- **Google Gemini**
- **HTMX & Thymeleaf**
- **MongoDB**
- **Docker & Kubernetes**
- **GraphQL & gRPC**
