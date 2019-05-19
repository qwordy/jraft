package com.jraft.pojo;

public class LogEntry {

    private final int index;

    private final int term;

    private final String cmd;

    public LogEntry() {
        this(0, 0, null);
    }

    public LogEntry(int index, int term, String cmd) {
        this.index = index;
        this.term = term;
        this.cmd = cmd;
    }

    public int getIndex() {
        return index;
    }

    public int getTerm() {
        return term;
    }

    public String getCmd() {
        return cmd;
    }
}
