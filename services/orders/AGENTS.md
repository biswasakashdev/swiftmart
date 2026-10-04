# Orders Agent Instructions

## Location

`/services/orders`

## Role

The orders service owns order lifecycle and payment-related order state.

Technology: Java + Spring Boot.

## Owns

-   Orders.
-   Order state transitions.
-   Payment-related order state.
-   Order processing.
-   Kafka order events.

## External Payment

Razorpay-specific code must stay behind a clear payment integration
boundary.

Use Resilience4j to protect calls to payment dependencies.

Never blindly retry a non-idempotent payment operation.

## Kafka

Consumers must be idempotent. Assume duplicate delivery can happen.

A stock-changing event must contain sufficient information to process
the operation safely.

## Rules

-   Do not modify inventory database directly.
-   Do not query catalogue database directly.
-   Keep order state transitions explicit.
-   Validate tenant ownership.
-   Protect external dependencies with timeouts/circuit breaking.
-   Keep payment provider concerns separate from core order domain
    logic.
