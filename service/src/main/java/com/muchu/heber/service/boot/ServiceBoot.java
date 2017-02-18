package com.muchu.heber.service.boot;

import com.muchu.heber.service.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author 梁海鹏
 * @createTime 2017/2/15 11:37
 */
public class ServiceBoot {

    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:service.xml", "classpath:dao.xml");
        UserService userService = context.getBean(UserService.class);
        userService.setPort(50051);
        userService.start();
        userService.blockUntilShutdown();
    }
}
