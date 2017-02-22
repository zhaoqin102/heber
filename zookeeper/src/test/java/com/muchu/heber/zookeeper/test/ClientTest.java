package com.muchu.heber.zookeeper.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author 梁海鹏
 * @createTime 2017/2/20 14:31
 */
public class ClientTest {

    @Test
    public void test01() throws IOException, KeeperException, InterruptedException {
        String hostPort = "localhost:2181";
        ZooKeeper zooKeeper = new ZooKeeper(hostPort, 3000, event -> System.out.println("hello"));
        System.out.println(zooKeeper.getState());
        Stat exists = zooKeeper.exists("/date", false);
        if (exists != null) {
            byte[] dates = zooKeeper.getData("/date", event -> System.out.println(event.toString()), exists);
            System.out.println(new String(dates));
            List<String> date = zooKeeper.getChildren("/date", false);
            System.out.println(date.size());
            for (String data : date) {
                System.out.println(data);
            }
            zooKeeper.setData("/date", "hello world".getBytes(), -1);
        } else {
            zooKeeper.create("/date", "/date".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        zooKeeper.close();
    }
}
