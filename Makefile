gen-proto-gatway:
	buf generate --template services/gateway/buf.gen.yaml
gen-proto-accounts:
	buf generate --template services/accounts/buf.gen.yaml

gen-proto-all: gen-proto-accounts gen-proto-gatway
