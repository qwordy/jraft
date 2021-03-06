// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: jraft.proto

package io.grpc.jraft;

public interface AppendEntriesRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:jraft.AppendEntriesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 term = 1;</code>
   */
  int getTerm();

  /**
   * <code>string leaderId = 2;</code>
   */
  java.lang.String getLeaderId();
  /**
   * <code>string leaderId = 2;</code>
   */
  com.google.protobuf.ByteString
      getLeaderIdBytes();

  /**
   * <code>int32 prevLogIndex = 3;</code>
   */
  int getPrevLogIndex();

  /**
   * <code>int32 prevLogTerm = 4;</code>
   */
  int getPrevLogTerm();

  /**
   * <code>repeated string entries = 5;</code>
   */
  java.util.List<java.lang.String>
      getEntriesList();
  /**
   * <code>repeated string entries = 5;</code>
   */
  int getEntriesCount();
  /**
   * <code>repeated string entries = 5;</code>
   */
  java.lang.String getEntries(int index);
  /**
   * <code>repeated string entries = 5;</code>
   */
  com.google.protobuf.ByteString
      getEntriesBytes(int index);

  /**
   * <code>int32 leaderCommit = 6;</code>
   */
  int getLeaderCommit();
}
