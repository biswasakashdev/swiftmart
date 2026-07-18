package config

import (
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
		Port:     getEnv("PORT", "8080"),
		MongoURL: getRequiredEnv("MONGO_DB_URL"),
	}

	return cfg, nil
}
