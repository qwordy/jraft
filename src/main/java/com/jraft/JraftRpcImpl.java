package com.jraft;

import io.grpc.jraft.*;
import io.grpc.stub.StreamObserver;
import org.apache.log4j.Logger;

public class JraftRpcImpl extends JraftGrpc.JraftImplBase {

    private static final Logger logger = Logger.getLogger(JraftRpcImpl.class);

    @Override
    public void requestVote(RequestVoteRequest request, StreamObserver<RequestVoteReply> responseObserver) {
        logger.info("Server receives requestVote request");
        // TODO
        int term = 0;
        boolean voteGranted = false;
        if (voteGranted) {
            // Reschedule follower future task
            State.instance().followerStart();
        }
        RequestVoteReply reply = RequestVoteReply.newBuilder().setTerm(term).setVoteGranted(voteGranted).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void appendEntries(AppendEntriesRequest request, StreamObserver<AppendEntriesReply> responseObserver) {
        logger.info("Server receives appendEntries request");
        // Reschedule follower future task
        State.instance().followerStart();
        // TODO
        int term = 0;
        boolean success = false;
        AppendEntriesReply reply =  AppendEntriesReply.newBuilder().setTerm(term).setSuccess(success).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
