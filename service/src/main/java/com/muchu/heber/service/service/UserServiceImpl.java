package com.muchu.heber.service.service;

import com.muchu.heber.dao.mapper.UserInfoMapper;
import com.muchu.heber.proto.Request;
import com.muchu.heber.proto.UserInfo;
import com.muchu.heber.proto.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 梁海鹏
 * @createTime 2017/2/27 15:28
 */
@Service
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

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
