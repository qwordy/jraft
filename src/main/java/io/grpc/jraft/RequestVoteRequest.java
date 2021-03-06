// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jraft.proto

package io.grpc.jraft;

/**
 * Protobuf type {@code jraft.RequestVoteRequest}
 */
public  final class RequestVoteRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:jraft.RequestVoteRequest)
    RequestVoteRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestVoteRequest.newBuilder() to construct.
  private RequestVoteRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestVoteRequest() {
    candidateId_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestVoteRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            term_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            candidateId_ = s;
            break;
          }
          case 24: {

            lastLogIndex_ = input.readInt32();
            break;
          }
          case 32: {

            lastLogTerm_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.jraft.JraftProto.internal_static_jraft_RequestVoteRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.jraft.JraftProto.internal_static_jraft_RequestVoteRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.jraft.RequestVoteRequest.class, io.grpc.jraft.RequestVoteRequest.Builder.class);
  }

  public static final int TERM_FIELD_NUMBER = 1;
  private int term_;
  /**
   * <code>int32 term = 1;</code>
   */
  public int getTerm() {
    return term_;
  }

  public static final int CANDIDATEID_FIELD_NUMBER = 2;
  private volatile java.lang.Object candidateId_;
  /**
   * <code>string candidateId = 2;</code>
   */
  public java.lang.String getCandidateId() {
    java.lang.Object ref = candidateId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      candidateId_ = s;
      return s;
    }
  }
  /**
   * <code>string candidateId = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCandidateIdBytes() {
    java.lang.Object ref = candidateId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      candidateId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LASTLOGINDEX_FIELD_NUMBER = 3;
  private int lastLogIndex_;
  /**
   * <code>int32 lastLogIndex = 3;</code>
   */
  public int getLastLogIndex() {
    return lastLogIndex_;
  }

  public static final int LASTLOGTERM_FIELD_NUMBER = 4;
  private int lastLogTerm_;
  /**
   * <code>int32 lastLogTerm = 4;</code>
   */
  public int getLastLogTerm() {
    return lastLogTerm_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (term_ != 0) {
      output.writeInt32(1, term_);
    }
    if (!getCandidateIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, candidateId_);
    }
    if (lastLogIndex_ != 0) {
      output.writeInt32(3, lastLogIndex_);
    }
    if (lastLogTerm_ != 0) {
      output.writeInt32(4, lastLogTerm_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (term_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, term_);
    }
    if (!getCandidateIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, candidateId_);
    }
    if (lastLogIndex_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, lastLogIndex_);
    }
    if (lastLogTerm_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, lastLogTerm_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.jraft.RequestVoteRequest)) {
      return super.equals(obj);
    }
    io.grpc.jraft.RequestVoteRequest other = (io.grpc.jraft.RequestVoteRequest) obj;

    if (getTerm()
        != other.getTerm()) return false;
    if (!getCandidateId()
        .equals(other.getCandidateId())) return false;
    if (getLastLogIndex()
        != other.getLastLogIndex()) return false;
    if (getLastLogTerm()
        != other.getLastLogTerm()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TERM_FIELD_NUMBER;
    hash = (53 * hash) + getTerm();
    hash = (37 * hash) + CANDIDATEID_FIELD_NUMBER;
    hash = (53 * hash) + getCandidateId().hashCode();
    hash = (37 * hash) + LASTLOGINDEX_FIELD_NUMBER;
    hash = (53 * hash) + getLastLogIndex();
    hash = (37 * hash) + LASTLOGTERM_FIELD_NUMBER;
    hash = (53 * hash) + getLastLogTerm();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.jraft.RequestVoteRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.jraft.RequestVoteRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.jraft.RequestVoteRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.jraft.RequestVoteRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.jraft.RequestVoteRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code jraft.RequestVoteRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:jraft.RequestVoteRequest)
      io.grpc.jraft.RequestVoteRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.jraft.JraftProto.internal_static_jraft_RequestVoteRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.jraft.JraftProto.internal_static_jraft_RequestVoteRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.jraft.RequestVoteRequest.class, io.grpc.jraft.RequestVoteRequest.Builder.class);
    }

    // Construct using io.grpc.jraft.RequestVoteRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      term_ = 0;

      candidateId_ = "";

      lastLogIndex_ = 0;

      lastLogTerm_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.jraft.JraftProto.internal_static_jraft_RequestVoteRequest_descriptor;
    }

    @java.lang.Override
    public io.grpc.jraft.RequestVoteRequest getDefaultInstanceForType() {
      return io.grpc.jraft.RequestVoteRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.grpc.jraft.RequestVoteRequest build() {
      io.grpc.jraft.RequestVoteRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.grpc.jraft.RequestVoteRequest buildPartial() {
      io.grpc.jraft.RequestVoteRequest result = new io.grpc.jraft.RequestVoteRequest(this);
      result.term_ = term_;
      result.candidateId_ = candidateId_;
      result.lastLogIndex_ = lastLogIndex_;
      result.lastLogTerm_ = lastLogTerm_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.jraft.RequestVoteRequest) {
        return mergeFrom((io.grpc.jraft.RequestVoteRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.jraft.RequestVoteRequest other) {
      if (other == io.grpc.jraft.RequestVoteRequest.getDefaultInstance()) return this;
      if (other.getTerm() != 0) {
        setTerm(other.getTerm());
      }
      if (!other.getCandidateId().isEmpty()) {
        candidateId_ = other.candidateId_;
        onChanged();
      }
      if (other.getLastLogIndex() != 0) {
        setLastLogIndex(other.getLastLogIndex());
      }
      if (other.getLastLogTerm() != 0) {
        setLastLogTerm(other.getLastLogTerm());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.jraft.RequestVoteRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.jraft.RequestVoteRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int term_ ;
    /**
     * <code>int32 term = 1;</code>
     */
    public int getTerm() {
      return term_;
    }
    /**
     * <code>int32 term = 1;</code>
     */
    public Builder setTerm(int value) {
      
      term_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 term = 1;</code>
     */
    public Builder clearTerm() {
      
      term_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object candidateId_ = "";
    /**
     * <code>string candidateId = 2;</code>
     */
    public java.lang.String getCandidateId() {
      java.lang.Object ref = candidateId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        candidateId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string candidateId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCandidateIdBytes() {
      java.lang.Object ref = candidateId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        candidateId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string candidateId = 2;</code>
     */
    public Builder setCandidateId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      candidateId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string candidateId = 2;</code>
     */
    public Builder clearCandidateId() {
      
      candidateId_ = getDefaultInstance().getCandidateId();
      onChanged();
      return this;
    }
    /**
     * <code>string candidateId = 2;</code>
     */
    public Builder setCandidateIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      candidateId_ = value;
      onChanged();
      return this;
    }

    private int lastLogIndex_ ;
    /**
     * <code>int32 lastLogIndex = 3;</code>
     */
    public int getLastLogIndex() {
      return lastLogIndex_;
    }
    /**
     * <code>int32 lastLogIndex = 3;</code>
     */
    public Builder setLastLogIndex(int value) {
      
      lastLogIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 lastLogIndex = 3;</code>
     */
    public Builder clearLastLogIndex() {
      
      lastLogIndex_ = 0;
      onChanged();
      return this;
    }

    private int lastLogTerm_ ;
    /**
     * <code>int32 lastLogTerm = 4;</code>
     */
    public int getLastLogTerm() {
      return lastLogTerm_;
    }
    /**
     * <code>int32 lastLogTerm = 4;</code>
     */
    public Builder setLastLogTerm(int value) {
      
      lastLogTerm_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 lastLogTerm = 4;</code>
     */
    public Builder clearLastLogTerm() {
      
      lastLogTerm_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:jraft.RequestVoteRequest)
  }

  // @@protoc_insertion_point(class_scope:jraft.RequestVoteRequest)
  private static final io.grpc.jraft.RequestVoteRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.jraft.RequestVoteRequest();
  }

  public static io.grpc.jraft.RequestVoteRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestVoteRequest>
      PARSER = new com.google.protobuf.AbstractParser<RequestVoteRequest>() {
    @java.lang.Override
    public RequestVoteRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RequestVoteRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestVoteRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RequestVoteRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.grpc.jraft.RequestVoteRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

