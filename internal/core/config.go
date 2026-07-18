package core

import (
	"github.com/biswasakashdev/swiftmart/pkg/env"
	"github.com/joho/godotenv"
)

type Config struct {
	Port string

	UserServiceAddr    string
	OrderServiceAddr   string
	ProductServiceAddr string
	JWTSecret          string
}

func Load() (*Config, error) {

	// Ignore error if .env doesn't exist
	_ = godotenv.Load()

	cfg := &Config{
		Port:               env.GetEnv("PORT", "8080"),
		UserServiceAddr:    env.GetRequiredEnv("USER_SERVICE_ADDR"),
		ProductServiceAddr: env.GetRequiredEnv("PRODUCT_SERVICE_ADDR"),
		OrderServiceAddr:   env.GetRequiredEnv("ORDER_SERVICE_ADDR"),
		JWTSecret:          env.GetRequiredEnv("JWT_SECRET"),
	}

	return cfg, nil
}
