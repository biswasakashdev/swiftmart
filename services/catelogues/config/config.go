package config

type Config struct {
	Port string

	UserServiceAddr    string
	OrderServiceAddr   string
	ProductServiceAddr string
	JWTSecret          string
}
