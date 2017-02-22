package com.muchu.heber.service.service;

import com.muchu.heber.dao.mapper.UserInfoMapper;
import com.muchu.heber.proto.Request;
import com.muchu.heber.proto.UserInfo;
import com.muchu.heber.proto.UserServiceGrpc;
import com.muchu.heber.service.zookeeper.ZookeeperRegistered;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author 梁海鹏
 * @createTime 2017/2/15 10:35
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private Server server;

    private int port;

    private final UserInfoMapper userInfoMapper;

    private final ZookeeperRegistered zookeeperRegistered;

    @Autowired
    public UserService(UserInfoMapper userInfoMapper, ZookeeperRegistered zookeeperRegistered) {
        this.userInfoMapper = userInfoMapper;
        this.zookeeperRegistered = zookeeperRegistered;
    }

    public void start() throws IOException {
    /* The port on which the server should run */
        server = ServerBuilder.forPort(port)
                .addService(new UserServiceImpl())
                .build()
                .start();
        boolean isRegistered = zookeeperRegistered.registeredService("userService", port + "");
        if (!isRegistered) {
            throw new RuntimeException("registered service fail");
        }
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            UserService.this.stop();
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

    class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

        @Override
        public void getUserInfoById(Request req, StreamObserver<UserInfo> responseObserver) {
            //获取用户信息
            com.muchu.heber.dao.model.UserInfo user = userInfoMapper.selectByPrimaryKey((int) req.getId());
            UserInfo userInfo = null;
            if (user != null)
                userInfo = UserInfo.newBuilder().setUsername(user.getUsername()).setPassword(user.getPassword()).build();
            responseObserver.onNext(userInfo);
            responseObserver.onCompleted();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
