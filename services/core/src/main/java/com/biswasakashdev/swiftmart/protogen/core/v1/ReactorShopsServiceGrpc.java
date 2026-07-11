package com.biswasakashdev.swiftmart.protogen.core.v1;

import static com.biswasakashdev.swiftmart.protogen.core.v1.ShopsServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: core/v1/Shops.proto")
public final class ReactorShopsServiceGrpc {
    private ReactorShopsServiceGrpc() {}

    public static ReactorShopsServiceStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorShopsServiceStub(channel);
    }

    public static final class ReactorShopsServiceStub extends io.grpc.stub.AbstractStub<ReactorShopsServiceStub> {
        private ShopsServiceGrpc.ShopsServiceStub delegateStub;

        private ReactorShopsServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = ShopsServiceGrpc.newStub(channel);
        }

        private ReactorShopsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = ShopsServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorShopsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorShopsServiceStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> createShop(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::createShop, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> getAllShops(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getAllShops, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> getShop(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getShop, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> createShop(com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::createShop, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> getAllShops(com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getAllShops, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> getShop(com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getShop, getCallOptions());
        }

    }

    public static abstract class ShopsServiceImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> createShop(com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest request) {
            return createShop(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> createShop(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> getAllShops(com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest request) {
            return getAllShops(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> getAllShops(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> getShop(com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest request) {
            return getShop(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> getShop(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.biswasakashdev.swiftmart.protogen.core.v1.ShopsServiceGrpc.getCreateShopMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest,
                                            com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse>(
                                            this, METHODID_CREATE_SHOP)))
                    .addMethod(
                            com.biswasakashdev.swiftmart.protogen.core.v1.ShopsServiceGrpc.getGetAllShopsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest,
                                            com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse>(
                                            this, METHODID_GET_ALL_SHOPS)))
                    .addMethod(
                            com.biswasakashdev.swiftmart.protogen.core.v1.ShopsServiceGrpc.getGetShopMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest,
                                            com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse>(
                                            this, METHODID_GET_SHOP)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

        protected Throwable onErrorMap(Throwable throwable) {
            return com.salesforce.reactorgrpc.stub.ServerCalls.prepareError(throwable);
        }
    }

    public static final int METHODID_CREATE_SHOP = 0;
    public static final int METHODID_GET_ALL_SHOPS = 1;
    public static final int METHODID_GET_SHOP = 2;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final ShopsServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(ShopsServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE_SHOP:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest) request,
                            (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse>) responseObserver,
                            serviceImpl::createShop, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_ALL_SHOPS:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest) request,
                            (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse>) responseObserver,
                            serviceImpl::getAllShops, serviceImpl::onErrorMap);
                    break;
                case METHODID_GET_SHOP:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest) request,
                            (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse>) responseObserver,
                            serviceImpl::getShop, serviceImpl::onErrorMap);
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
