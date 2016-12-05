package com.muchu.heber.web.service;

import com.muchu.heber.dao.mapper.UserInfoMapper;
import com.muchu.heber.dao.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 梁海鹏
 * @createTime ${DATA} 12:06
 */
@Service
public class IndexService {

    private final UserInfoMapper userInfoMapper;

    private Logger logger = LoggerFactory.getLogger(IndexService.class);

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

    @Transactional
    public void update(boolean isSleep, String password) {

        try {
            UserInfo userInfo = userInfoMapper.selectForUpdate(77);
            if (isSleep) {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException ignored) {
                }
            }
            if (userInfo != null) {
                logger.info("userInfo.password:" + userInfo.getPassword());
                userInfo.setPassword(password);
                userInfoMapper.update(userInfo);
            }
        } catch (Exception e) {
            logger.info("lock:", e);
        }
    }
}
