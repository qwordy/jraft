package com.jraft.handler;

import com.jraft.State;
import com.jraft.pojo.LogEntry;
import com.jraft.util.Tuple;
import io.grpc.jraft.RequestVoteRequest;

/**=
 * this class is the handler for vote request message
 */
public class VoteMessageHandler {

    /**
     * current state on the server
     */
    private static final State currentState = State.instance();

    public Tuple.Tuple2<Integer, Boolean> votedFor(RequestVoteRequest request) {
        // TODO: use currentState to synchronize multiple vote request
        int requestTerm = request.getTerm();
        synchronized (currentState) {
            int currentTerm = currentState.getCurrentTerm();
            if (requestTerm < currentTerm) {
                return Tuple.getTuple(currentTerm, false);
            } else if (requestTerm > currentTerm) {
                currentState.setCurrentTerm(requestTerm);
                currentState.setRole(State.Role.Follower);
                currentTerm = requestTerm;
            } else {
                if (null != currentState.getVotedFor()) {
                    return Tuple.getTuple(currentTerm, false);
                }
            }

            LogEntry lastLogEntry = currentState.getLastLog();
            if (null != lastLogEntry) {
                // if last log entry existed
                if (lastLogEntry.getIndex() > request.getLastLogIndex() ||
                        lastLogEntry.getTerm() > request.getLastLogTerm()) {
                    return Tuple.getTuple(currentTerm, false);
                }
            }
            currentState.setVotedFor(request.getCandidateId());
            return Tuple.getTuple(currentTerm, true);
        }
    }
}
