package com.sun.dev.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.data.Stat;

/**
 * Created by sunchengfei on 2018/10/16.
 */
public class CuratorTest {
    public static void main(String[] args) {
        CuratorFrameworkFactory.Builder cBuilder = CuratorFrameworkFactory.builder()
                .connectString("dz-zk.test.vip.sankuai.com:2181")
                .retryPolicy(new RetryNTimes(10000, 3 * 1000))
                .connectionTimeoutMs(30 * 1000).sessionTimeoutMs(60 * 1000);

        CuratorFramework zkClient = cBuilder.build();
        zkClient.start();
        try {
            System.out.println("start");
            Stat stat = zkClient.checkExists().forPath("/baby");
            System.out.println("end");
            System.out.println(stat.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
