// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jraft.proto

package io.grpc.jraft;

public final class JraftProto {
  private JraftProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_jraft_RequestVoteRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_jraft_RequestVoteRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_jraft_RequestVoteReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_jraft_RequestVoteReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_jraft_AppendEntriesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_jraft_AppendEntriesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_jraft_AppendEntriesReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_jraft_AppendEntriesReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013jraft.proto\022\005jraft\"b\n\022RequestVoteReque" +
      "st\022\014\n\004term\030\001 \001(\005\022\023\n\013candidateId\030\002 \001(\t\022\024\n" +
      "\014lastLogIndex\030\003 \001(\005\022\023\n\013lastLogTerm\030\004 \001(\005" +
      "\"5\n\020RequestVoteReply\022\014\n\004term\030\001 \001(\005\022\023\n\013vo" +
      "teGranted\030\002 \001(\010\"\210\001\n\024AppendEntriesRequest" +
      "\022\014\n\004term\030\001 \001(\005\022\020\n\010leaderId\030\002 \001(\t\022\024\n\014prev" +
      "LogIndex\030\003 \001(\005\022\023\n\013prevLogTerm\030\004 \001(\005\022\017\n\007e" +
      "ntries\030\005 \003(\t\022\024\n\014leaderCommit\030\006 \001(\005\"3\n\022Ap" +
      "pendEntriesReply\022\014\n\004term\030\001 \001(\005\022\017\n\007succes" +
      "s\030\002 \001(\0102\227\001\n\005Jraft\022C\n\013RequestVote\022\031.jraft" +
      ".RequestVoteRequest\032\027.jraft.RequestVoteR" +
      "eply\"\000\022I\n\rAppendEntries\022\033.jraft.AppendEn" +
      "triesRequest\032\031.jraft.AppendEntriesReply\"" +
      "\000B\035\n\rio.grpc.jraftB\nJraftProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_jraft_RequestVoteRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_jraft_RequestVoteRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_jraft_RequestVoteRequest_descriptor,
        new java.lang.String[] { "Term", "CandidateId", "LastLogIndex", "LastLogTerm", });
    internal_static_jraft_RequestVoteReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_jraft_RequestVoteReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_jraft_RequestVoteReply_descriptor,
        new java.lang.String[] { "Term", "VoteGranted", });
    internal_static_jraft_AppendEntriesRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_jraft_AppendEntriesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_jraft_AppendEntriesRequest_descriptor,
        new java.lang.String[] { "Term", "LeaderId", "PrevLogIndex", "PrevLogTerm", "Entries", "LeaderCommit", });
    internal_static_jraft_AppendEntriesReply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_jraft_AppendEntriesReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_jraft_AppendEntriesReply_descriptor,
        new java.lang.String[] { "Term", "Success", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
