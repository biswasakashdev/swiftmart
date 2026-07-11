package com.biswasakashdev.swiftmart.protogen.users.v1;

import static com.biswasakashdev.swiftmart.protogen.users.v1.UsersServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: users/v1/main.proto")
public final class ReactorUsersServiceGrpc {
    private ReactorUsersServiceGrpc() {}

    public static ReactorUsersServiceStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorUsersServiceStub(channel);
    }

    public static final class ReactorUsersServiceStub extends io.grpc.stub.AbstractStub<ReactorUsersServiceStub> {
        private UsersServiceGrpc.UsersServiceStub delegateStub;

        private ReactorUsersServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = UsersServiceGrpc.newStub(channel);
        }

        private ReactorUsersServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = UsersServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorUsersServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorUsersServiceStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse> createAccount(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::createAccount, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse> authorize(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::authorize, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse> createAccount(com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::createAccount, getCallOptions());
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse> authorize(com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::authorize, getCallOptions());
        }

    }

    public static abstract class UsersServiceImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse> createAccount(com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest request) {
            return createAccount(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse> createAccount(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse> authorize(com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest request) {
            return authorize(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse> authorize(reactor.core.publisher.Mono<com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.biswasakashdev.swiftmart.protogen.users.v1.UsersServiceGrpc.getCreateAccountMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest,
                                            com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse>(
                                            this, METHODID_CREATE_ACCOUNT)))
                    .addMethod(
                            com.biswasakashdev.swiftmart.protogen.users.v1.UsersServiceGrpc.getAuthorizeMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest,
                                            com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse>(
                                            this, METHODID_AUTHORIZE)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

        protected Throwable onErrorMap(Throwable throwable) {
            return com.salesforce.reactorgrpc.stub.ServerCalls.prepareError(throwable);
        }
    }

    public static final int METHODID_CREATE_ACCOUNT = 0;
    public static final int METHODID_AUTHORIZE = 1;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final UsersServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(UsersServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE_ACCOUNT:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest) request,
                            (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse>) responseObserver,
                            serviceImpl::createAccount, serviceImpl::onErrorMap);
                    break;
                case METHODID_AUTHORIZE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest) request,
                            (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse>) responseObserver,
                            serviceImpl::authorize, serviceImpl::onErrorMap);
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
