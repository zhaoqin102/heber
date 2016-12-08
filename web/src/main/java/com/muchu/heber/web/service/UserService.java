package com.muchu.heber.web.service;

import com.muchu.heber.dao.mapper.UserInfoMapper;
import com.muchu.heber.dao.model.UserInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 梁海鹏
 * @createdate 16-12-8 下午10:44
 */
@Service
public class UserService {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfo getUserInfo(int id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public UserInfo insertUserInfo(String username, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(DigestUtils.md5Hex(password));
        userInfo.setRegisterTime(new Date());
        userInfoMapper.insert(userInfo);
        return userInfo;
    }
}
