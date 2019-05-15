package com.jraft;

import com.jraft.util.CmdLineParser;

public class Jraft {

    private State state;

    private Config config;

    private Jraft() throws Exception {
        config = Config.instance();
        JraftServer server = new JraftServer(config.getPort());
        server.start();
        server.blockUntilShutdown();
    }

    public static void main(String[] args) throws Exception {
        CmdLineParser cmdLineParser = CmdLineParser.getInstance();
        if (cmdLineParser.parse(args)) {
            new Jraft();
        } else {
            cmdLineParser.showHelp();
        }
    }
}
