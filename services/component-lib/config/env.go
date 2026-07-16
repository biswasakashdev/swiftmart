package config

import (
	"fmt"
	"os"

	"github.com/joho/godotenv"
)

func Load() (*Config, error) {

	// Ignore error if .env doesn't exist
	_ = godotenv.Load()

	cfg := &Config{
		Port:     getEnv("PORT", "8080"),
		MongoURL: getRequiredEnv("MONGO_DB_URL"),
	}

	return cfg, nil
}

func getEnv(key, defaultValue string) string {
	if value := os.Getenv(key); value != "" {
		return value
	}
	return defaultValue
}

func getRequiredEnv(key string) string {
	value := os.Getenv(key)
	if value == "" {
		panic(fmt.Sprintf("%s environment variable is required", key))
	}
	return value
}
