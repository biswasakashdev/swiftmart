# Infrastructure Agent Instructions

## Role

This directory contains deployment and platform configuration.

Technology:

-   Docker
-   Kubernetes
-   ArgoCD
-   Supporting local-development infrastructure

## Rules

-   Keep service deployment configuration close to the service only when
    repository conventions require it; otherwise centralize platform
    configuration here.
-   Do not commit plaintext production secrets.
-   Prefer reproducible container builds.
-   Keep Kubernetes resources declarative.
-   ArgoCD is the GitOps deployment mechanism.
-   Do not treat manual kubectl changes as the normal deployment
    workflow.
-   Configuration must be documented.
-   Health/readiness behavior should match the application.

## Local Development

Local Kubernetes should be usable without production credentials.

Use safe local configuration and explicit documentation for required
dependencies.
