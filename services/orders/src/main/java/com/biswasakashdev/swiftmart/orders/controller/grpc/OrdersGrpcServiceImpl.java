package com.biswasakashdev.swiftmart.orders.controller.grpc;

import com.biswasakashdev.swiftmart.protogen.orders.v1.*;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class OrdersGrpcServiceImpl extends ReactorOrderServiceGrpc.OrderServiceImplBase {
    @Override
    public Mono<CreateOrderResponse> createOrder(Mono<CreateOrderRequest> request) {
        return super.createOrder(request);
    }

    @Override
    public Mono<GetAllOrdersResponse> getAllOrders(Mono<GetAllOrdersRequest> request) {
        return super.getAllOrders(request);
    }

    @Override
    public Mono<GetOrderResponse> getOrder(Mono<GetOrderRequest> request) {
        return super.getOrder(request);
    }
}
