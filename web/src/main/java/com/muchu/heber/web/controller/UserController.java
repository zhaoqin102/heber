package com.muchu.heber.web.controller;

import com.muchu.heber.dao.model.UserInfo;
import com.muchu.heber.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁海鹏
 * @createdate 16-12-8 下午10:24
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/${id}", method = RequestMethod.GET)
    public UserInfo getUserInfo(@PathVariable("id") int id) {
        if (id < 1) {
            return null;
        }
        return userService.getUserInfo(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserInfo insertUserInfo(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return null;
        }
        return userService.insertUserInfo(username, password);
    }
}
