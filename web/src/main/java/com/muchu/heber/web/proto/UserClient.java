package com.muchu.heber.web.proto;

import com.muchu.heber.proto.ClientBoot;
import com.muchu.heber.proto.Request;
import com.muchu.heber.proto.UserInfo;
import com.muchu.heber.proto.UserServiceGrpc;
import com.muchu.heber.zookeeper.client.ZookeeperClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author 梁海鹏
 * @createTime 2017/2/15 10:41
 */
public class UserClient {

    private Logger logger = LoggerFactory.getLogger(UserClient.class);

    private UserServiceGrpc.UserServiceBlockingStub blockingStub;

    @Autowired
    public UserClient(ClientBoot clientBoot) {
        blockingStub = UserServiceGrpc.newBlockingStub(clientBoot.getChannel());
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
        logger.info("Greeting: {0}",userInfo.getUsername());
        return userInfo;
    }

}
