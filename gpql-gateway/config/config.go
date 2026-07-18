package config

import (
	"github.com/joho/godotenv"
)

type Config struct {
	Port string

	CoreServiceAddr      string
	OrderServiceAddr     string
	CatelogueServiceAddr string
	JWTSecret            string
}

func Load() (*Config, error) {
	// Load .env file if it exists
	_ = godotenv.Load()

	cfg := &Config{
		Port:                 getEnv("PORT", "8080"),
		CoreServiceAddr:      getRequiredEnv("CORE_GRPC_ADDR"),
		OrderServiceAddr:     getRequiredEnv("ORDER_GRPC_ADDR"),
		CatelogueServiceAddr: getRequiredEnv("CATELOGUE_GRPC_ADDR"),
		JWTSecret:            getEnv("JWT_SECRET", "a-long-secrct"),
	}

	return cfg, nil
}
