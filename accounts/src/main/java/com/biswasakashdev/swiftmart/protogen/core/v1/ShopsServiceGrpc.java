package com.biswasakashdev.swiftmart.protogen.core.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ShopsServiceGrpc {

  private ShopsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "core.v1.ShopsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> getCreateShopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateShop",
      requestType = com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest.class,
      responseType = com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> getCreateShopMethod() {
    io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest, com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> getCreateShopMethod;
    if ((getCreateShopMethod = ShopsServiceGrpc.getCreateShopMethod) == null) {
      synchronized (ShopsServiceGrpc.class) {
        if ((getCreateShopMethod = ShopsServiceGrpc.getCreateShopMethod) == null) {
          ShopsServiceGrpc.getCreateShopMethod = getCreateShopMethod =
              io.grpc.MethodDescriptor.<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest, com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateShop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ShopsServiceMethodDescriptorSupplier("CreateShop"))
              .build();
        }
      }
    }
    return getCreateShopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> getGetAllShopsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllShops",
      requestType = com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest.class,
      responseType = com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> getGetAllShopsMethod() {
    io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest, com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> getGetAllShopsMethod;
    if ((getGetAllShopsMethod = ShopsServiceGrpc.getGetAllShopsMethod) == null) {
      synchronized (ShopsServiceGrpc.class) {
        if ((getGetAllShopsMethod = ShopsServiceGrpc.getGetAllShopsMethod) == null) {
          ShopsServiceGrpc.getGetAllShopsMethod = getGetAllShopsMethod =
              io.grpc.MethodDescriptor.<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest, com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllShops"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ShopsServiceMethodDescriptorSupplier("GetAllShops"))
              .build();
        }
      }
    }
    return getGetAllShopsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> getGetShopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetShop",
      requestType = com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest.class,
      responseType = com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest,
      com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> getGetShopMethod() {
    io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest, com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> getGetShopMethod;
    if ((getGetShopMethod = ShopsServiceGrpc.getGetShopMethod) == null) {
      synchronized (ShopsServiceGrpc.class) {
        if ((getGetShopMethod = ShopsServiceGrpc.getGetShopMethod) == null) {
          ShopsServiceGrpc.getGetShopMethod = getGetShopMethod =
              io.grpc.MethodDescriptor.<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest, com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetShop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ShopsServiceMethodDescriptorSupplier("GetShop"))
              .build();
        }
      }
    }
    return getGetShopMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ShopsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShopsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShopsServiceStub>() {
        @java.lang.Override
        public ShopsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShopsServiceStub(channel, callOptions);
        }
      };
    return ShopsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static ShopsServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShopsServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShopsServiceBlockingV2Stub>() {
        @java.lang.Override
        public ShopsServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShopsServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return ShopsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ShopsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShopsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShopsServiceBlockingStub>() {
        @java.lang.Override
        public ShopsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShopsServiceBlockingStub(channel, callOptions);
        }
      };
    return ShopsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ShopsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShopsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShopsServiceFutureStub>() {
        @java.lang.Override
        public ShopsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShopsServiceFutureStub(channel, callOptions);
        }
      };
    return ShopsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createShop(com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateShopMethod(), responseObserver);
    }

    /**
     */
    default void getAllShops(com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllShopsMethod(), responseObserver);
    }

    /**
     */
    default void getShop(com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShopMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ShopsService.
   */
  public static abstract class ShopsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ShopsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ShopsService.
   */
  public static final class ShopsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ShopsServiceStub> {
    private ShopsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShopsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShopsServiceStub(channel, callOptions);
    }

    /**
     */
    public void createShop(com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateShopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllShops(com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllShopsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getShop(com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShopMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ShopsService.
   */
  public static final class ShopsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ShopsServiceBlockingV2Stub> {
    private ShopsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShopsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShopsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse createShop(com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateShopMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse getAllShops(com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAllShopsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse getShop(com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetShopMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ShopsService.
   */
  public static final class ShopsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ShopsServiceBlockingStub> {
    private ShopsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShopsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShopsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse createShop(com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateShopMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse getAllShops(com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllShopsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse getShop(com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShopMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ShopsService.
   */
  public static final class ShopsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ShopsServiceFutureStub> {
    private ShopsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShopsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShopsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse> createShop(
        com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateShopMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse> getAllShops(
        com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllShopsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse> getShop(
        com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShopMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SHOP = 0;
  private static final int METHODID_GET_ALL_SHOPS = 1;
  private static final int METHODID_GET_SHOP = 2;

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
        case METHODID_CREATE_SHOP:
          serviceImpl.createShop((com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest) request,
              (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_SHOPS:
          serviceImpl.getAllShops((com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest) request,
              (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse>) responseObserver);
          break;
        case METHODID_GET_SHOP:
          serviceImpl.getShop((com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest) request,
              (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse>) responseObserver);
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
          getCreateShopMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopRequest,
              com.biswasakashdev.swiftmart.protogen.core.v1.CreateShopResponse>(
                service, METHODID_CREATE_SHOP)))
        .addMethod(
          getGetAllShopsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsRequest,
              com.biswasakashdev.swiftmart.protogen.core.v1.GetAllShopsResponse>(
                service, METHODID_GET_ALL_SHOPS)))
        .addMethod(
          getGetShopMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.biswasakashdev.swiftmart.protogen.core.v1.GetShopRequest,
              com.biswasakashdev.swiftmart.protogen.core.v1.GetShopResponse>(
                service, METHODID_GET_SHOP)))
        .build();
  }

  private static abstract class ShopsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ShopsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.biswasakashdev.swiftmart.protogen.core.v1.ShopsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ShopsService");
    }
  }

  private static final class ShopsServiceFileDescriptorSupplier
      extends ShopsServiceBaseDescriptorSupplier {
    ShopsServiceFileDescriptorSupplier() {}
  }

  private static final class ShopsServiceMethodDescriptorSupplier
      extends ShopsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ShopsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ShopsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ShopsServiceFileDescriptorSupplier())
              .addMethod(getCreateShopMethod())
              .addMethod(getGetAllShopsMethod())
              .addMethod(getGetShopMethod())
              .build();
        }
      }
    }
    return result;
  }
}
