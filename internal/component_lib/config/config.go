package config

import (
	"github.com/biswasakashdev/swiftmart/pkg/env"
	"github.com/joho/godotenv"
)

type Config struct {
	Port     string
	MongoURL string
}

func Load() (*Config, error) {
	// Load .env file if it exists
	_ = godotenv.Load()

	cfg := &Config{
		Port:     env.GetEnv("PORT", "8080"),
		MongoURL: env.GetRequiredEnv("MONGO_DB_URL"),
	}

	return cfg, nil
}
