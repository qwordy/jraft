package com.jraft;

import com.jraft.util.CmdLineParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Config {

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
                addrs.add(new Addr(terms[0], Integer.valueOf(terms[1])));
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

    private static class Addr {
        String host;
        int port;

        public Addr(String host, int port) {
            this.host = host;
            this.port = port;
        }
    }
}
