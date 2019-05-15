package com.jraft.util;

import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;

public class CmdLineParser {

    private volatile static CmdLineParser clp;

    private final CommandLineParser parser;
    private final Options options;

    private String idConfFile;

    private String serversConfFile;

    private final Map<String, String> otherArgsMap;

    public static CmdLineParser getInstance() {
        if (clp == null) {
            synchronized (CmdLineParser.class) {
                if (clp == null) {
                    clp = new CmdLineParser();
                }
            }
        }
        return clp;
    }

    private CmdLineParser() {

        otherArgsMap = new HashMap<>();

        parser = new DefaultParser();
        options = new Options();
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE information" );
        Option id = Option.builder("i")
                .longOpt("id-conf")
                .hasArg(true)
                .required(true)
                .desc("Specify id configure file")
                .build();
        Option sc = Option.builder("s")
                .longOpt("servers-conf")
                .hasArg(true)
                .required(true)
                .desc("Specify service configure file")
                .build();
        options.addOption(id);
        options.addOption(sc);
    }

    private void reset() {
        idConfFile = null;
        serversConfFile = null;
        otherArgsMap.clear();
    }

    public boolean parse(String[] args) {
        reset();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("h")) {
                return false;
            } else {
                if(cmd.hasOption("i")) {
                    idConfFile = cmd.getOptionValue("i");
                }
                if (cmd.hasOption("s")) {
                    serversConfFile = cmd.getOptionValue("s");
                }
                for (Option opt: cmd.getOptions()) {
                    otherArgsMap.put(opt.getLongOpt(), cmd.getOptionValue(opt.getOpt()));
                }
                return true;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    public void showHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "java wordcount [OPTION] <FILENAME>", options);
    }

    public String getIdConfFile() {
        return idConfFile;
    }

    public String getServersConfFile() {
        return serversConfFile;
    }

    public String getArgsOption(String opt) {
        return otherArgsMap.get(opt);
    }

}
