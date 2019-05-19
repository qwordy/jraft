package com.jraft;

import com.jraft.util.CmdLineParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Config {

    /**
     * 1. As a follower, if election timeout elapses without receiving
     * AppendEntries RPC from current leader or granting vote to candidate:
     * convert to candidate and start election <br>
     * 2. As a candidate, if election timeout elapses: start new election <br>
     * (In second)
     */
    public final static int electionTimeout = 5;

    private static Config config = new Config();

    // Server name (id)
    private String name;

    // The port on which the server should run
    private int port;

    // Server list
    private List<Addr> addrs;

    private Config() {
        // Load properties
        Properties pro = new Properties();
        try (FileReader fr = new FileReader(CmdLineParser.getInstance().getIdConfFile())) {
            pro.load(fr);
            name = pro.getProperty("name");
            port = Integer.valueOf(pro.getProperty("port"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Load server list
        addrs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(CmdLineParser.getInstance().getServersConfFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] terms = line.split("\\s+");
                // Exclude itself
                if (!terms[2].equals(name)) {
                    addrs.add(new Addr(terms[0], Integer.valueOf(terms[1]), terms[2]));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Config instance() {
        return config;
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return port;
    }

    public List<Addr> getAddrs() {
        return addrs;
    }

    public static class Addr {
        String host, name;
        int port;

        public Addr(String host, int port, String name) {
            // e.g. localhost 9001 server1
            this.host = host;
            this.port = port;
            this.name = name;
        }
    }
}
