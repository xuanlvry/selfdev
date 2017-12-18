package com.my.test.memcache;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

/**
 * Created by Chengfei.Sun on 17/05/11.
 */
public class MemcacheByJavaClientUtil {
    private static MemCachedClient client;

    static {
//        SockIOPool pool = SockIOPool.getInstance("poolName");
//        pool.setServers(new String[]{"localhost:11211"});
//        pool.setFailover(true);
//        pool.setInitConn(10); // 设置初始连接
//        pool.setMinConn(5);   // 设置最小连接
//        pool.setMaxConn(250); // 设置最大连接
//        pool.setMaxIdle(1000 * 60 * 60 * 3); // 设置每个连接最大空闲时间3个小时
//        pool.setMaintSleep(30);
//        pool.setNagle(false);
//        pool.setSocketTO(3000);
//        pool.setAliveCheck(true);
//        pool.initialize();

//        client = new MemCachedClient("poolName");
    }

    public static void add(String key, Object value) {
        client.set(key, value);
    }

    public static void add(String key, Object value, int milliseconds) {
        client.set(key, value, milliseconds);
    }

    public static void remove(String key) {
        client.delete(key);
    }

    public static void update(String key, Object value, int milliseconds) {
        client.replace(key, value, milliseconds);
    }

    public static void update(String key, Object value) {
        client.replace(key, value);
    }

    public static Object get(String key) {
        return client.get(key);
    }

    public static void main(String[] args) {
        //将对象加入到memcached缓存
        MemcacheByJavaClientUtil.client.add("keke", "This is a test String");
        //从memcached缓存中按key值取对象
        String result = (String) MemcacheByJavaClientUtil.client.get("keke");
        System.out.println(result);
    }
}
