package com.jraft;

import io.grpc.jraft.*;
import io.grpc.stub.StreamObserver;

public class JraftRpcImpl extends JraftGrpc.JraftImplBase {
    @Override
    public void requestVote(RequestVoteRequest request, StreamObserver<RequestVoteReply> responseObserver) {
        super.requestVote(request, responseObserver);
    }

    @Override
    public void appendEntries(AppendEntriesRequest request, StreamObserver<AppendEntriesReply> responseObserver) {
        super.appendEntries(request, responseObserver);
    }
}
