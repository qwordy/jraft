package com.jraft;

public class State {

    enum Role {
        Follower, Candidate, Leader
    }

    Role role;

    int currentTerm;
}
