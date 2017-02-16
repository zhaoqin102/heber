package com.muchu.heber.web.service;

import com.muchu.heber.proto.UserInfo;
import com.muchu.heber.web.proto.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 梁海鹏
 * @createdate 16-12-8 下午10:44
 */
@Service
public class UserService {

    private final UserClient userClient;

    @Autowired
    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserInfo getUserInfo(int id) {
        return userClient.getUserById((long) id);
    }

    public UserInfo insertUserInfo(String username, String password) {
        return null;
    }

    public UserInfo updateUserInfo(int id, String password) {
        return null;
    }
}
