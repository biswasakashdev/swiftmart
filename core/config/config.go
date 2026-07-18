package config

import (
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
		Port:               getEnv("PORT", "8080"),
		UserServiceAddr:    getRequiredEnv("USER_SERVICE_ADDR"),
		ProductServiceAddr: getRequiredEnv("PRODUCT_SERVICE_ADDR"),
		OrderServiceAddr:   getRequiredEnv("ORDER_SERVICE_ADDR"),
		JWTSecret:          getRequiredEnv("JWT_SECRET"),
	}

	return cfg, nil
}
