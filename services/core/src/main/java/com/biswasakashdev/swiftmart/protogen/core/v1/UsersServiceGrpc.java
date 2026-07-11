package com.biswasakashdev.swiftmart.protogen.core.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class UsersServiceGrpc {

  private UsersServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "core.v1.UsersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse> getCreateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccount",
      requestType = com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest.class,
      responseType = com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse> getCreateAccountMethod() {
    io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest, com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse> getCreateAccountMethod;
    if ((getCreateAccountMethod = UsersServiceGrpc.getCreateAccountMethod) == null) {
      synchronized (UsersServiceGrpc.class) {
        if ((getCreateAccountMethod = UsersServiceGrpc.getCreateAccountMethod) == null) {
          UsersServiceGrpc.getCreateAccountMethod = getCreateAccountMethod =
              io.grpc.MethodDescriptor.<com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest, com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UsersServiceMethodDescriptorSupplier("CreateAccount"))
              .build();
        }
      }
    }
    return getCreateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse> getAuthorizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Authorize",
      requestType = com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest.class,
      responseType = com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse> getAuthorizeMethod() {
    io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest, com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse> getAuthorizeMethod;
    if ((getAuthorizeMethod = UsersServiceGrpc.getAuthorizeMethod) == null) {
      synchronized (UsersServiceGrpc.class) {
        if ((getAuthorizeMethod = UsersServiceGrpc.getAuthorizeMethod) == null) {
          UsersServiceGrpc.getAuthorizeMethod = getAuthorizeMethod =
              io.grpc.MethodDescriptor.<com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest, com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Authorize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UsersServiceMethodDescriptorSupplier("Authorize"))
              .build();
        }
      }
    }
    return getAuthorizeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UsersServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsersServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UsersServiceStub>() {
        @java.lang.Override
        public UsersServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UsersServiceStub(channel, callOptions);
        }
      };
    return UsersServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static UsersServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsersServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UsersServiceBlockingV2Stub>() {
        @java.lang.Override
        public UsersServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UsersServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return UsersServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UsersServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsersServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UsersServiceBlockingStub>() {
        @java.lang.Override
        public UsersServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UsersServiceBlockingStub(channel, callOptions);
        }
      };
    return UsersServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UsersServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UsersServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UsersServiceFutureStub>() {
        @java.lang.Override
        public UsersServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UsersServiceFutureStub(channel, callOptions);
        }
      };
    return UsersServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createAccount(com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccountMethod(), responseObserver);
    }

    /**
     */
    default void authorize(com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAuthorizeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UsersService.
   */
  public static abstract class UsersServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UsersServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UsersService.
   */
  public static final class UsersServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UsersServiceStub> {
    private UsersServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsersServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsersServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAccount(com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void authorize(com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuthorizeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UsersService.
   */
  public static final class UsersServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<UsersServiceBlockingV2Stub> {
    private UsersServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsersServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsersServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse createAccount(com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse authorize(com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAuthorizeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service UsersService.
   */
  public static final class UsersServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UsersServiceBlockingStub> {
    private UsersServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsersServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsersServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse createAccount(com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse authorize(com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuthorizeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UsersService.
   */
  public static final class UsersServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UsersServiceFutureStub> {
    private UsersServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsersServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UsersServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse> createAccount(
        com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse> authorize(
        com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuthorizeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ACCOUNT = 0;
  private static final int METHODID_AUTHORIZE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ACCOUNT:
          serviceImpl.createAccount((com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse>) responseObserver);
          break;
        case METHODID_AUTHORIZE:
          serviceImpl.authorize((com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest) request,
              (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest,
              com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse>(
                service, METHODID_CREATE_ACCOUNT)))
        .addMethod(
          getAuthorizeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest,
              com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse>(
                service, METHODID_AUTHORIZE)))
        .build();
  }

  private static abstract class UsersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UsersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.biswasakashdev.swiftmart.protogen.core.v1.UsersProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UsersService");
    }
  }

  private static final class UsersServiceFileDescriptorSupplier
      extends UsersServiceBaseDescriptorSupplier {
    UsersServiceFileDescriptorSupplier() {}
  }

  private static final class UsersServiceMethodDescriptorSupplier
      extends UsersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UsersServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UsersServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UsersServiceFileDescriptorSupplier())
              .addMethod(getCreateAccountMethod())
              .addMethod(getAuthorizeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
