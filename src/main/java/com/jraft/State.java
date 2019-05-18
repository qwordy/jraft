package com.jraft;

public class State {

    public enum Role {
        Follower, Candidate, Leader
    }

    volatile Role role;

    volatile int currentTerm;

    public State() {
        this(Role.Follower, 0);
    }

    public State(Role role, int currentTerm) {
        this.role =role;
        this.currentTerm = currentTerm;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(int currentTerm) {
        this.currentTerm = currentTerm;
    }
}
