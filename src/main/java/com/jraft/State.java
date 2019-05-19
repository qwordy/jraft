package com.jraft;

import com.jraft.pojo.LogEntry;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class State {

    private static final Logger logger = Logger.getLogger(State.class);

    public enum Role {
        Follower, Candidate, Leader
    }

    private Role role;

    /**
     * Latest term server has seen (initialized to 0
     * on first boot, increases monotonically)
     */
    private int currentTerm;

    /**
     * candidateId that received vote in current term (or null if none)
     */
    private String votedFor;

    /**
     * Log entries; each entry contains command
     * for state machine, and term when entry
     * was received by leader (first index is 1)
     */
    private List<LogEntry> log;

    /**
     * Index of highest log entry known to be
     * committed (initialized to 0, increases
     * monotonically)
     */
    private int commitIndex;

    /**
     * Index of highest log entry applied to state
     * machine (initialized to 0, increases
     * monotonically)
     */
    private int lastApplied;

    /**
     * Index of highest log entry applied to state
     * machine (initialized to 0, increases
     * monotonically)
     */

    private Config config;

    private List<JraftClient> clients;

    private ScheduledFuture<?> followerFuture;

    private static State state = new State();

    private State() {
        this(Role.Follower, 0);
    }

    private State(Role role, int currentTerm) {
        this.role =role;
        this.currentTerm = currentTerm;
    }

    public static State instance() {
        return state;
    }

    /**
     * Schedule follower future task (timeout, switch role to candidate)
     */
    public void followerStart() {
        if (followerFuture != null) {
            followerFuture.cancel(false);
        }
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        followerFuture = scheduler.schedule(() -> {
            logger.info("Follower timeout");
            role = Role.Candidate;
            candidateStart();
        }, Config.electionTimeout, TimeUnit.SECONDS);
    }

    public void candidateStart() {
        currentTerm++;
        // TODO Vote for self
        // TODO Reset election timer
        for (JraftClient client : clients) {
            // TODO 0, 0
            client.requestVote(currentTerm, config.getName(), 0, 0);
            logger.info("requestVote done");
        }
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

    public String getVotedFor() {
        return votedFor;
    }

    public void setVotedFor(String votedFor) {
        this.votedFor = votedFor;
    }

    public List<LogEntry> getLog() {
        return log;
    }

    public void appendLogs(List<LogEntry> logEntries) {
        this.log.addAll(logEntries);
    }

    public void appendLog(LogEntry logEntry) {
        this.log.add(logEntry);
    }

    public LogEntry getLastLog() {
        if (log.isEmpty()) {
            return null;
        } else {
            return log.get(log.size() - 1);
        }
    }

    public int getCommitIndex() {
        return commitIndex;
    }

    public void setCommitIndex(int commitIndex) {
        this.commitIndex = commitIndex;
    }

    public int getLastApplied() {
        return lastApplied;
    }

    public void setLastApplied(int lastApplied) {
        this.lastApplied = lastApplied;
    }

    public List<JraftClient> getClients() {
        return clients;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public void setClients(List<JraftClient> clients) {
        this.clients = clients;
    }

    public ScheduledFuture<?> getFollowerFuture() {
        return followerFuture;
    }

    public void setFollowerFuture(ScheduledFuture<?> followerFuture) {
        this.followerFuture = followerFuture;
    }
}
