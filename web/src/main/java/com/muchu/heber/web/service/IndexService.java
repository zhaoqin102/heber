package com.muchu.heber.web.service;

import com.muchu.heber.dao.mapper.UserInfoMapper;
import com.muchu.heber.dao.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 梁海鹏
 * @createTime ${DATA} 12:06
 */
@Service
public class IndexService {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public IndexService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public void index() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("12345678");
        userInfo.setUsername("zhaoqin102");
        userInfo.setRegisterTime(new Date());
        userInfoMapper.insert(userInfo);
        System.out.println(userInfo.getId());
    }
}
