package com.muchu.heber.service;

import com.muchu.heber.registry.Registered;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁海鹏
 * @createTime 2017/2/27 15:03
 */
public class GRPCServerBoot {

    private Logger logger = LoggerFactory.getLogger(GRPCServerBoot.class);

    private Server server;

    private int port;

    private Registered registered;

    private String serverName;

    private List<BindableService> services = new ArrayList<>();

    public void start() throws IOException {
        ServerBuilder<?> builder = ServerBuilder.forPort(port);
        boolean isRegistered = registered.registeredServer(serverName, port);
        if (!isRegistered) {
            throw new RuntimeException("registered service fail");
        }
        for (BindableService service : services) {
            builder.addService(service);
        }
        server = builder
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public List<BindableService> getServices() {
        return services;
    }

    public void setServices(List<BindableService> services) {
        this.services = services;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
