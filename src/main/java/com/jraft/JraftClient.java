package com.jraft;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.jraft.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JraftClient {

    private final ManagedChannel channel;

    private final JraftGrpc.JraftBlockingStub blockingStub;

    public JraftClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = JraftGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Invoked by candidates to gather votes
     * @param term candidate’s term
     * @param candidateId candidate requesting vote
     * @param lastLogIndex index of candidate’s last log entry
     * @param lastLogTerm term of candidate’s last log entry
     * @return RequestVoteReply
     */
    public RequestVoteReply requestVote(int term, String candidateId, int lastLogIndex, int lastLogTerm) {
        RequestVoteRequest request = RequestVoteRequest.newBuilder()
                .setTerm(term)
                .setCandidateId(candidateId)
                .setLastLogIndex(lastLogIndex)
                .setLastLogTerm(lastLogTerm)
                .build();
        return blockingStub.requestVote(request);
    }

    /**
     * Invoked by leader to replicate log entries; also used as heartbeat
     * @param term leader’s term
     * @param leaderId so follower can redirect clients
     * @param prevLogIndex index of log entry immediately preceding new ones
     * @param prevLogTerm term of prevLogIndex entry
     * @param entries log entries to store (empty for heartbeat; may send more than one for efficiency)
     * @param leaderCommit leader’s commitIndex
     * @return AppendEntriesReply
     */
    public AppendEntriesReply appendEntries(int term, String leaderId, int prevLogIndex, int prevLogTerm, List<String> entries, int leaderCommit) {
        AppendEntriesRequest request = AppendEntriesRequest.newBuilder()
                .setTerm(term)
                .setLeaderId(leaderId)
                .setPrevLogIndex(prevLogIndex)
                .setPrevLogTerm(prevLogTerm)
                .addAllEntries(entries)
                .setLeaderCommit(leaderCommit)
                .build();
        return blockingStub.appendEntries(request);
    }

    /**
     * Just for heartbeats
     * @return
     */
    public AppendEntriesReply appendEntries() {
        AppendEntriesRequest request = AppendEntriesRequest.newBuilder().build();
        return blockingStub.appendEntries(request);
    }
}
