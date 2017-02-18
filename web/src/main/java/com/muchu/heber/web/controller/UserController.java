package com.muchu.heber.web.controller;

import com.muchu.heber.proto.UserInfo;
import com.muchu.heber.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 梁海鹏
 * @createdate 16-12-8 下午10:24
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserInfo getUserInfo(@PathVariable("id") int id) {
        if (id < 1) {
            return null;
        }
        return userService.getUserInfo(id);
    }

    @PutMapping
    public UserInfo insertUserInfo(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return null;
        }
        return userService.insertUserInfo(username, password);
    }

    @PostMapping("/{id}")
    public UserInfo updateUserInfo(@PathVariable("id") int id, String password) {
        if (id < 1) {
            return null;
        }
        return userService.updateUserInfo(id, password);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserInfo(@PathVariable("id") int id) {
        return id >= 1;
    }
}
