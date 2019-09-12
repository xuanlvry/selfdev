package com.sun.dev.springcache;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/**
 * Created by Chengfei.Sun on 17/05/12.
 */
public class MemcachedCache implements Cache {
    private MemcachedClient client; //对应xml中property配置p:client-ref
    private String name;            //对应xml中property配置p:name
    private int exp = 3600;         //对应xml中property配置p:exp

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return client;
    }

    @Override
    public ValueWrapper get(Object o) {
        Object object = null;
        try {
            object = client.get((String) o);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return (object != null ? new SimpleValueWrapper(object) : null);
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        Object object = null;
        try {
            object = client.get((String) o);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return (T) object;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
    public void put(Object o, Object o1) {
        try {
            client.set((String) o, exp, o1);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        put(o, o1);
        return get(o1);
    }

    @Override
    public void evict(Object o) {
        try {
            client.delete((String) o);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            client.flushAll();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }

    public MemcachedClient getClient() {
        return client;
    }

    public void setClient(MemcachedClient client) {
        this.client = client;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
