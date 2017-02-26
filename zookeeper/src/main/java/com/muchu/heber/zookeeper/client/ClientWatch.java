package com.muchu.heber.zookeeper.client;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author 梁海鹏
 * @createTime 17-2-26 下午9:35
 */
public class ClientWatch implements Watcher{

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event.toString());
    }
}
