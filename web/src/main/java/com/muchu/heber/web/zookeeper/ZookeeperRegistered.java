package com.muchu.heber.web.zookeeper;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author 梁海鹏
 * @createTime 2017/2/22 10:09
 */
public class ZookeeperRegistered {

    private String url;

    private String path;

    /**
     * 获取zookeeper注册中心地址
     *
     * @return zookeeper注册中心地址
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (url == null) {
            throw new RuntimeException("zookeeper url must not null");
        }
        this.url = url;
    }

    /**
     * 获取服务器保存位置
     *
     * @return 服务器列表保存位置
     */
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        if (path == null) {
            throw new RuntimeException("zookeeper path must not null");
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        this.path = path;
    }

    /**
     * 注册服务
     *
     * @param serviceName 服务名
     * @return 服务列表
     */
    public String getServiceList(String serviceName) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(this.url, 3000, event -> {
                System.out.println("zookeeper connection success");
                System.out.println("start registered service");
            });
            Stat exists = zooKeeper.exists(this.path + serviceName, false);
            if (exists != null) {
                byte[] data = zooKeeper.getData(this.path + serviceName, event -> {
                }, new Stat());
                return new String(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
