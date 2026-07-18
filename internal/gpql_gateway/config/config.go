package config

type Config struct {
	Port string

	CoreServiceAddr      string
	OrderServiceAddr     string
	CatelogueServiceAddr string
	JWTSecret            string
}
