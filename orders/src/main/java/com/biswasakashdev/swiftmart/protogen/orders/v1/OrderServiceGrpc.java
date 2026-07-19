package com.biswasakashdev.swiftmart.protogen.orders.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class OrderServiceGrpc {

  private OrderServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "orders.v1.OrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest,
      com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> getCreateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrder",
      requestType = com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest.class,
      responseType = com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest,
      com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> getCreateOrderMethod() {
    io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest, com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> getCreateOrderMethod;
    if ((getCreateOrderMethod = OrderServiceGrpc.getCreateOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getCreateOrderMethod = OrderServiceGrpc.getCreateOrderMethod) == null) {
          OrderServiceGrpc.getCreateOrderMethod = getCreateOrderMethod =
              io.grpc.MethodDescriptor.<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest, com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("CreateOrder"))
              .build();
        }
      }
    }
    return getCreateOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest,
      com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> getGetAllOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllOrders",
      requestType = com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest.class,
      responseType = com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest,
      com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> getGetAllOrdersMethod() {
    io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest, com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> getGetAllOrdersMethod;
    if ((getGetAllOrdersMethod = OrderServiceGrpc.getGetAllOrdersMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetAllOrdersMethod = OrderServiceGrpc.getGetAllOrdersMethod) == null) {
          OrderServiceGrpc.getGetAllOrdersMethod = getGetAllOrdersMethod =
              io.grpc.MethodDescriptor.<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest, com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("GetAllOrders"))
              .build();
        }
      }
    }
    return getGetAllOrdersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest,
      com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrder",
      requestType = com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest.class,
      responseType = com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest,
      com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> getGetOrderMethod() {
    io.grpc.MethodDescriptor<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest, com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> getGetOrderMethod;
    if ((getGetOrderMethod = OrderServiceGrpc.getGetOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetOrderMethod = OrderServiceGrpc.getGetOrderMethod) == null) {
          OrderServiceGrpc.getGetOrderMethod = getGetOrderMethod =
              io.grpc.MethodDescriptor.<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest, com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("GetOrder"))
              .build();
        }
      }
    }
    return getGetOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub>() {
        @java.lang.Override
        public OrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceStub(channel, callOptions);
        }
      };
    return OrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static OrderServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingV2Stub>() {
        @java.lang.Override
        public OrderServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return OrderServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub>() {
        @java.lang.Override
        public OrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceBlockingStub(channel, callOptions);
        }
      };
    return OrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub>() {
        @java.lang.Override
        public OrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceFutureStub(channel, callOptions);
        }
      };
    return OrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOrderMethod(), responseObserver);
    }

    /**
     */
    default void getAllOrders(com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllOrdersMethod(), responseObserver);
    }

    /**
     */
    default void getOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrderService.
   */
  public static abstract class OrderServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OrderServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrderService.
   */
  public static final class OrderServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrderServiceStub> {
    private OrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void createOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllOrders(com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllOrdersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest request,
        io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrderService.
   */
  public static final class OrderServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OrderServiceBlockingV2Stub> {
    private OrderServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse createOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse getAllOrders(com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAllOrdersMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse getOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service OrderService.
   */
  public static final class OrderServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrderServiceBlockingStub> {
    private OrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse createOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse getAllOrders(com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllOrdersMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse getOrder(com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OrderService.
   */
  public static final class OrderServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrderServiceFutureStub> {
    private OrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse> createOrder(
        com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse> getAllOrders(
        com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllOrdersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse> getOrder(
        com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ORDER = 0;
  private static final int METHODID_GET_ALL_ORDERS = 1;
  private static final int METHODID_GET_ORDER = 2;

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
        case METHODID_CREATE_ORDER:
          serviceImpl.createOrder((com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_ORDERS:
          serviceImpl.getAllOrders((com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest) request,
              (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse>) responseObserver);
          break;
        case METHODID_GET_ORDER:
          serviceImpl.getOrder((com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse>) responseObserver);
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
          getCreateOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderRequest,
              com.biswasakashdev.swiftmart.protogen.orders.v1.CreateOrderResponse>(
                service, METHODID_CREATE_ORDER)))
        .addMethod(
          getGetAllOrdersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersRequest,
              com.biswasakashdev.swiftmart.protogen.orders.v1.GetAllOrdersResponse>(
                service, METHODID_GET_ALL_ORDERS)))
        .addMethod(
          getGetOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderRequest,
              com.biswasakashdev.swiftmart.protogen.orders.v1.GetOrderResponse>(
                service, METHODID_GET_ORDER)))
        .build();
  }

  private static abstract class OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.biswasakashdev.swiftmart.protogen.orders.v1.OrdersProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderService");
    }
  }

  private static final class OrderServiceFileDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier {
    OrderServiceFileDescriptorSupplier() {}
  }

  private static final class OrderServiceMethodDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrderServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
              .addMethod(getCreateOrderMethod())
              .addMethod(getGetAllOrdersMethod())
              .addMethod(getGetOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
