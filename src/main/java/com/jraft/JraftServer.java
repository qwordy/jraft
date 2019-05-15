package com.jraft;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class JraftServer {

    private Server server;

    /* The port on which the server should run */
    private int port;

    public JraftServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new JraftRpcImpl())
                .build()
                .start();
//        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            JraftServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
