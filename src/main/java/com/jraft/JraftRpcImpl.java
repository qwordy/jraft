package com.jraft;

import com.jraft.handler.VoteMessageHandler;
import com.jraft.util.Tuple;
import io.grpc.jraft.*;
import io.grpc.stub.StreamObserver;
import org.apache.log4j.Logger;

public class JraftRpcImpl extends JraftGrpc.JraftImplBase {

    private static final Logger logger = Logger.getLogger(JraftRpcImpl.class);

    private final VoteMessageHandler voteMessageHandler = new VoteMessageHandler();

    @Override
    public void requestVote(RequestVoteRequest request, StreamObserver<RequestVoteReply> responseObserver) {
        // TODO
        Tuple.Tuple2<Integer, Boolean> voteHandlerResult = voteMessageHandler.votedFor(request);
        int term = voteHandlerResult.getFirst();
        boolean voteGranted = voteHandlerResult.getSecond();
        logger.info(String.format("Server receives requestVote request from candidate %s, vote result" +
                "  term %d, vote granted %b", request.getCandidateId(), term, voteGranted));
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
