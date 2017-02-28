package com.muchu.heber.proto;

import com.muchu.heber.Client.ClientConfig;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author 梁海鹏
 * @createTime 2017/2/27 15:49
 */
public class ClientBoot {

    private Logger logger = LoggerFactory.getLogger(ClientBoot.class);

    private ManagedChannel channel;

    private ClientConfig clientConfig;

    public void start() {
        String userService = clientConfig.getServiceList("userService");
        System.out.println("==================>port:" + userService);
        if (userService == null || userService.isEmpty()) {
            throw new RuntimeException("userService no provider");
        }
        ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(userService)).usePlaintext(true);
        channel = channelBuilder.build();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public ManagedChannel getChannel() {
        if (channel == null)
            start();
        return channel;
    }

    public void setChannel(ManagedChannel channel) {
        this.channel = channel;
    }

    public ClientConfig getClientConfig() {
        return clientConfig;
    }

    public void setClientConfig(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }
}
