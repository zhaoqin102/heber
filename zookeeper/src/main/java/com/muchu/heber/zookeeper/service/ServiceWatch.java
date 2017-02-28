package com.muchu.heber.zookeeper.service;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author 梁海鹏
 * @createTime 17-2-26 下午9:37
 */
public class ServiceWatch implements Watcher {


    @Override
    public void process(WatchedEvent event) {
        System.out.println("registered service");
        System.out.println(event.toString());
    }
}
