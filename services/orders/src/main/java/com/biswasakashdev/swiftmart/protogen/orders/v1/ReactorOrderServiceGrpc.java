package com.biswasakashdev.swiftmart.protogen.orders.v1;

import static com.biswasakashdev.swiftmart.protogen.orders.v1.OrderServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: orders/v1/orders.proto")
public final class ReactorOrderServiceGrpc {
    private ReactorOrderServiceGrpc() {}

    public static ReactorOrderServiceStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorOrderServiceStub(channel);
    }

    public static final class ReactorOrderServiceStub extends io.grpc.stub.AbstractStub<ReactorOrderServiceStub> {
        private OrderServiceGrpc.OrderServiceStub delegateStub;

        private ReactorOrderServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = OrderServiceGrpc.newStub(channel);
        }

        private ReactorOrderServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = OrderServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorOrderServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorOrderServiceStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> createOrder(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::createOrder, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> getAllOrders(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getAllOrders, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> getOrder(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getOrder, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> createOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::createOrder, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> getAllOrders(com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getAllOrders, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> getOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getOrder, getCallOptions());
        }

    }

    public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> createOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest request) {
            return createOrder(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> createOrder(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> getAllOrders(com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest request) {
            return getAllOrders(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> getAllOrders(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> getOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest request) {
            return getOrder(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> getOrder(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.biswasakashdev.swiftmart.protogen.orders.v1.OrderServiceGrpc.getCreateOrderMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest,
                                            com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse>(
                                            this, METHODID_CREATE_ORDER)))
                    .addMethod(
                            com.biswasakashdev.swiftmart.protogen.orders.v1.OrderServiceGrpc.getGetAllOrdersMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest,
                                            com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse>(
                                            this, METHODID_GET_ALL_ORDERS)))
                    .addMethod(
                            com.biswasakashdev.swiftmart.protogen.orders.v1.OrderServiceGrpc.getGetOrderMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest,
                                            com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse>(
                                            this, METHODID_GET_ORDER)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

        protected Throwable onErrorMap(Throwable throwable) {
            return com.salesforce.reactorgrpc.stub.ServerCalls.prepareError(throwable);
        }
    }

    public static final int METHODID_CREATE_ORDER = 0;
    public static final int METHODID_GET_ALL_ORDERS = 1;
    public static final int METHODID_GET_ORDER = 2;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final OrderServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE_ORDER:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest) request,
                            (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse>) responseObserver,
                            serviceImpl::createOrder, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_ALL_ORDERS:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest) request,
                            (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse>) responseObserver,
                            serviceImpl::getAllOrders, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_ORDER:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest) request,
                            (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse>) responseObserver,
                            serviceImpl::getOrder, serviceImpl::onErrorMap);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
