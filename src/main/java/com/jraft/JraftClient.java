package com.jraft;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.jraft.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JraftClient {

    private static final Logger logger = Logger.getLogger(JraftClient.class);

    private final ManagedChannel channel;

    private final JraftGrpc.JraftBlockingStub blockingStub;

    // Async stub
    private final JraftGrpc.JraftStub stub;

    public JraftClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = JraftGrpc.newBlockingStub(channel);
        stub = JraftGrpc.newStub(channel);
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
        logger.info(String.format("requestVote %d %s %d %d", term, candidateId, lastLogIndex, lastLogTerm));
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
