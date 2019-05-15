package io.grpc.jraft;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The Jraft service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: jraft.proto")
public final class JraftGrpc {

  private JraftGrpc() {}

  public static final String SERVICE_NAME = "jraft.Jraft";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.jraft.RequestVoteRequest,
      io.grpc.jraft.RequestVoteReply> getRequestVoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestVote",
      requestType = io.grpc.jraft.RequestVoteRequest.class,
      responseType = io.grpc.jraft.RequestVoteReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.jraft.RequestVoteRequest,
      io.grpc.jraft.RequestVoteReply> getRequestVoteMethod() {
    io.grpc.MethodDescriptor<io.grpc.jraft.RequestVoteRequest, io.grpc.jraft.RequestVoteReply> getRequestVoteMethod;
    if ((getRequestVoteMethod = JraftGrpc.getRequestVoteMethod) == null) {
      synchronized (JraftGrpc.class) {
        if ((getRequestVoteMethod = JraftGrpc.getRequestVoteMethod) == null) {
          JraftGrpc.getRequestVoteMethod = getRequestVoteMethod = 
              io.grpc.MethodDescriptor.<io.grpc.jraft.RequestVoteRequest, io.grpc.jraft.RequestVoteReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "jraft.Jraft", "RequestVote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.jraft.RequestVoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.jraft.RequestVoteReply.getDefaultInstance()))
                  .setSchemaDescriptor(new JraftMethodDescriptorSupplier("RequestVote"))
                  .build();
          }
        }
     }
     return getRequestVoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.jraft.AppendEntriesRequest,
      io.grpc.jraft.AppendEntriesReply> getAppendEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AppendEntries",
      requestType = io.grpc.jraft.AppendEntriesRequest.class,
      responseType = io.grpc.jraft.AppendEntriesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.jraft.AppendEntriesRequest,
      io.grpc.jraft.AppendEntriesReply> getAppendEntriesMethod() {
    io.grpc.MethodDescriptor<io.grpc.jraft.AppendEntriesRequest, io.grpc.jraft.AppendEntriesReply> getAppendEntriesMethod;
    if ((getAppendEntriesMethod = JraftGrpc.getAppendEntriesMethod) == null) {
      synchronized (JraftGrpc.class) {
        if ((getAppendEntriesMethod = JraftGrpc.getAppendEntriesMethod) == null) {
          JraftGrpc.getAppendEntriesMethod = getAppendEntriesMethod = 
              io.grpc.MethodDescriptor.<io.grpc.jraft.AppendEntriesRequest, io.grpc.jraft.AppendEntriesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "jraft.Jraft", "AppendEntries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.jraft.AppendEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.jraft.AppendEntriesReply.getDefaultInstance()))
                  .setSchemaDescriptor(new JraftMethodDescriptorSupplier("AppendEntries"))
                  .build();
          }
        }
     }
     return getAppendEntriesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JraftStub newStub(io.grpc.Channel channel) {
    return new JraftStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JraftBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new JraftBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JraftFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new JraftFutureStub(channel);
  }

  /**
   * <pre>
   * The Jraft service definition
   * </pre>
   */
  public static abstract class JraftImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestVote(io.grpc.jraft.RequestVoteRequest request,
        io.grpc.stub.StreamObserver<io.grpc.jraft.RequestVoteReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestVoteMethod(), responseObserver);
    }

    /**
     */
    public void appendEntries(io.grpc.jraft.AppendEntriesRequest request,
        io.grpc.stub.StreamObserver<io.grpc.jraft.AppendEntriesReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAppendEntriesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestVoteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.jraft.RequestVoteRequest,
                io.grpc.jraft.RequestVoteReply>(
                  this, METHODID_REQUEST_VOTE)))
          .addMethod(
            getAppendEntriesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.jraft.AppendEntriesRequest,
                io.grpc.jraft.AppendEntriesReply>(
                  this, METHODID_APPEND_ENTRIES)))
          .build();
    }
  }

  /**
   * <pre>
   * The Jraft service definition
   * </pre>
   */
  public static final class JraftStub extends io.grpc.stub.AbstractStub<JraftStub> {
    private JraftStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JraftStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JraftStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JraftStub(channel, callOptions);
    }

    /**
     */
    public void requestVote(io.grpc.jraft.RequestVoteRequest request,
        io.grpc.stub.StreamObserver<io.grpc.jraft.RequestVoteReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestVoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void appendEntries(io.grpc.jraft.AppendEntriesRequest request,
        io.grpc.stub.StreamObserver<io.grpc.jraft.AppendEntriesReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAppendEntriesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Jraft service definition
   * </pre>
   */
  public static final class JraftBlockingStub extends io.grpc.stub.AbstractStub<JraftBlockingStub> {
    private JraftBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JraftBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JraftBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JraftBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.jraft.RequestVoteReply requestVote(io.grpc.jraft.RequestVoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getRequestVoteMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.jraft.AppendEntriesReply appendEntries(io.grpc.jraft.AppendEntriesRequest request) {
      return blockingUnaryCall(
          getChannel(), getAppendEntriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Jraft service definition
   * </pre>
   */
  public static final class JraftFutureStub extends io.grpc.stub.AbstractStub<JraftFutureStub> {
    private JraftFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JraftFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JraftFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JraftFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.jraft.RequestVoteReply> requestVote(
        io.grpc.jraft.RequestVoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestVoteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.jraft.AppendEntriesReply> appendEntries(
        io.grpc.jraft.AppendEntriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAppendEntriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_VOTE = 0;
  private static final int METHODID_APPEND_ENTRIES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JraftImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JraftImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_VOTE:
          serviceImpl.requestVote((io.grpc.jraft.RequestVoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.jraft.RequestVoteReply>) responseObserver);
          break;
        case METHODID_APPEND_ENTRIES:
          serviceImpl.appendEntries((io.grpc.jraft.AppendEntriesRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.jraft.AppendEntriesReply>) responseObserver);
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

  private static abstract class JraftBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JraftBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.jraft.JraftProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Jraft");
    }
  }

  private static final class JraftFileDescriptorSupplier
      extends JraftBaseDescriptorSupplier {
    JraftFileDescriptorSupplier() {}
  }

  private static final class JraftMethodDescriptorSupplier
      extends JraftBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JraftMethodDescriptorSupplier(String methodName) {
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
      synchronized (JraftGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JraftFileDescriptorSupplier())
              .addMethod(getRequestVoteMethod())
              .addMethod(getAppendEntriesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
