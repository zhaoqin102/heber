package com.muchu.heber.web.proto;

import com.muchu.heber.proto.Request;
import com.muchu.heber.proto.UserInfo;
import com.muchu.heber.proto.UserServiceGrpc;
import com.muchu.heber.web.zookeeper.ZookeeperRegistered;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 梁海鹏
 * @createTime 2017/2/15 10:41
 */
public class UserClient {

    private static final Logger logger = LoggerFactory.getLogger(UserClient.class);

    private final ManagedChannel channel;

    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    @Autowired
    public UserClient(ZookeeperRegistered zookeeperRegistered) {
        String userService = zookeeperRegistered.getServiceList("userService");
        System.out.println("==================>port:" + userService);
        if (userService == null || userService.isEmpty()) {
            throw new RuntimeException("userService no provider");
        }
        ManagedChannelBuilder<?> localhost = ManagedChannelBuilder.forAddress("localhost", Integer.parseInt(userService)).usePlaintext(true);
        channel = localhost.build();
        blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public UserInfo getUserById(long id) {
        Request request = Request.newBuilder().setId(id).build();
        UserInfo userInfo = null;
        try {
            userInfo = blockingStub.getUserInfoById(request);
        } catch (StatusRuntimeException e) {
            logger.error("RPC failed: {0}", e.getStatus());
        }
        assert userInfo != null;
        logger.info("Greeting: " + userInfo.getUsername());
        return userInfo;
    }

}
