package com.jraft;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;

public class JraftServer {

    private static final Logger logger = Logger.getLogger(JraftServer.class);

    private Server server;

    /* The port on which the server should run */
    private int port;

    public JraftServer(int port) {
        this.port = port;
    }

    /**
     * Start server
     * @throws IOException
     */
    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new JraftRpcImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            JraftServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    /**
     * Stop server
     */
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Block until shutdown
     * @throws InterruptedException
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
