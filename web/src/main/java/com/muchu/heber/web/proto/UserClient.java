package com.muchu.heber.web.proto;

import com.muchu.heber.proto.Request;
import com.muchu.heber.proto.UserInfo;
import com.muchu.heber.proto.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author 梁海鹏
 * @createTime 2017/2/15 10:41
 */
public class UserClient {

    private static final Logger logger = LoggerFactory.getLogger(UserClient.class);

    private final ManagedChannel channel;

    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public UserClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true));
    }

    /**
     * Construct client for accessing RouteGuide server using the existing channel.
     */
    UserClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public UserInfo getUserById(long id) {
        Request request = Request.newBuilder().setId(id).build();
        UserInfo userInfo = null;
        try {
            userInfo = blockingStub.getUserInfoById(request);
        } catch (StatusRuntimeException e) {
            logger.error("RPC failed: {0}", e.getStatus());
        }
        logger.info("Greeting: " + userInfo.getUsername());
        return userInfo;
    }

}
