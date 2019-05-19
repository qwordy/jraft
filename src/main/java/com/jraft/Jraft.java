package com.jraft;

import com.jraft.util.CmdLineParser;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.List;

public class Jraft {

    private State state;

    private Config config;

    private List<JraftClient> clients;

    private Jraft() throws Exception {
        config = Config.instance();
        JraftServer server = new JraftServer(config.getPort());
        server.start();
        initClients();
        state = State.instance();
        state.setConfig(config);
        state.setClients(clients);
        state.followerStart();
        server.blockUntilShutdown();
    }

    /**
     * Initialize clients
     */
    private void initClients() {
        List<Config.Addr> list = config.getAddrs();
        clients = new ArrayList<>();
        for (Config.Addr addr : list) {
            clients.add(new JraftClient(addr.host, addr.port));
        }
    }

    /***
     * Main function, entrance of Jraft, needs to finish following operations:
     *
     * 1. load configuration which is necessary for the services
     * 2. start local server services, like Election, Log and HeartBeat service
     * 3. start remote call threads to call services on other remote Nodes
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CmdLineParser cmdLineParser = CmdLineParser.getInstance();
        if (cmdLineParser.parse(args)) {
            String confPath = cmdLineParser.getOptValue("log", "conf/log4j.properties");
            PropertyConfigurator.configure(confPath);
            new Jraft();
        } else {
            cmdLineParser.showHelp();
        }
    }
}
