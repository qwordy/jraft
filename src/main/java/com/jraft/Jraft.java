package com.jraft;

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
        new Jraft();
    }
}
