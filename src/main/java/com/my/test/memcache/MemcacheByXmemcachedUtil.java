package com.my.test.memcache;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * Created by Chengfei.Sun on 17/05/11.
 */
public class MemcacheByXmemcachedUtil {
    public static void main(String[] args) {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"));
        MemcachedClient memcachedClient;
        try {
            memcachedClient = builder.build();

            memcachedClient.set("hello", 0, "Hello,xmemcached");
            String value = memcachedClient.get("hello");
            System.out.println("hello=" + value);

            memcachedClient.delete("hello");
            value = memcachedClient.get("hello");
            System.out.println("hello=" + value);
            
            memcachedClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
