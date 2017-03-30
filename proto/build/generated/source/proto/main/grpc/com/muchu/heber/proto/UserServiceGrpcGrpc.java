package com.muchu.heber.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: UserService.proto")
public final class UserServiceGrpcGrpc {

  private UserServiceGrpcGrpc() {}

  public static final String SERVICE_NAME = "proto.UserServiceGrpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.muchu.heber.proto.RequestId,
      com.muchu.heber.proto.GrpcUserInfo> METHOD_GET_USER_INFO_BY_ID =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto.UserServiceGrpc", "GetUserInfoById"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.muchu.heber.proto.RequestId.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.muchu.heber.proto.GrpcUserInfo.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceGrpcStub newStub(io.grpc.Channel channel) {
    return new UserServiceGrpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceGrpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceGrpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceGrpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceGrpcFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceGrpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserInfoById(com.muchu.heber.proto.RequestId request,
        io.grpc.stub.StreamObserver<com.muchu.heber.proto.GrpcUserInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_INFO_BY_ID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_USER_INFO_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.muchu.heber.proto.RequestId,
                com.muchu.heber.proto.GrpcUserInfo>(
                  this, METHODID_GET_USER_INFO_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceGrpcStub extends io.grpc.stub.AbstractStub<UserServiceGrpcStub> {
    private UserServiceGrpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceGrpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceGrpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceGrpcStub(channel, callOptions);
    }

    /**
     */
    public void getUserInfoById(com.muchu.heber.proto.RequestId request,
        io.grpc.stub.StreamObserver<com.muchu.heber.proto.GrpcUserInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER_INFO_BY_ID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceGrpcBlockingStub extends io.grpc.stub.AbstractStub<UserServiceGrpcBlockingStub> {
    private UserServiceGrpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceGrpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceGrpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceGrpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.muchu.heber.proto.GrpcUserInfo getUserInfoById(com.muchu.heber.proto.RequestId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER_INFO_BY_ID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceGrpcFutureStub extends io.grpc.stub.AbstractStub<UserServiceGrpcFutureStub> {
    private UserServiceGrpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceGrpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceGrpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceGrpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.muchu.heber.proto.GrpcUserInfo> getUserInfoById(
        com.muchu.heber.proto.RequestId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER_INFO_BY_ID, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_INFO_BY_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceGrpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceGrpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_INFO_BY_ID:
          serviceImpl.getUserInfoById((com.muchu.heber.proto.RequestId) request,
              (io.grpc.stub.StreamObserver<com.muchu.heber.proto.GrpcUserInfo>) responseObserver);
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

  private static final class UserServiceGrpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.muchu.heber.proto.ServiceGrpc.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceGrpcDescriptorSupplier())
              .addMethod(METHOD_GET_USER_INFO_BY_ID)
              .build();
        }
      }
    }
    return result;
  }
}
