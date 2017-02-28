package com.muchu.heber.service.boot;

import com.muchu.heber.proto.ServerBoot;
import com.muchu.heber.service.service.UserServiceImpl;
import com.muchu.heber.zookeeper.service.ZookeeperService;
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
        ServerBoot serverBoot = context.getBean(ServerBoot.class);
        serverBoot.start();
        serverBoot.blockUntilShutdown();
    }
}
