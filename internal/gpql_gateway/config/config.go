package config

import (
	"github.com/biswasakashdev/swiftmart/pkg/env"
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
		Port:                 env.GetEnv("PORT", "8080"),
		CoreServiceAddr:      env.GetRequiredEnv("CORE_GRPC_ADDRESS"),
		OrderServiceAddr:     env.GetRequiredEnv("ORDER_GRPC_ADDRESS"),
		CatelogueServiceAddr: env.GetRequiredEnv("CATELOGUE_GRPC_ADDRESS"),
		JWTSecret:            env.GetEnv("JWT_SECRET", "a-long-secrct"),
	}

	return cfg, nil
}
