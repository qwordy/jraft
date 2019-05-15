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

    public RequestVoteReply requestVote(int term, String candidateId, int lastLogIndex, int lastLogTerm) {
        RequestVoteRequest request = RequestVoteRequest.newBuilder()
                .setTerm(term)
                .setCandidateId(candidateId)
                .setLastLogIndex(lastLogIndex)
                .setLastLogTerm(lastLogTerm)
                .build();
        return blockingStub.requestVote(request);
    }

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
