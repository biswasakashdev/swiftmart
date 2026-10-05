FROM golang:1.24-alpine AS builder

WORKDIR /app

COPY . .

RUN go mod download

RUN CGO_ENABLED=0 GOOS=linux go build -o ./app ./cmd/gateway/main.go

FROM alpine:3.24

COPY --from=builder /app/app /app

ENTRYPOINT ["/app"]