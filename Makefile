gpql-gateway-proto-gen:
	buf generate --template gpql-gateway/buf.gen.yaml

core-proto-gen:
	buf generate --template services/core/buf.gen.yaml

orders-proto-gen:
	buf generate --template services/orders/buf.gen.yaml

catelogues-proto-gen:
	buf generate --template services/catelogues/buf.gen.yaml
