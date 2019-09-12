package com.sun.dev.springcache;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * Created by Chengfei.Sun on 17/05/12.
 */
public class MemcacheCacheManager extends AbstractCacheManager {
    private Collection<MemcachedCache> caches;

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return caches;
    }

    public Collection<MemcachedCache> getCaches() {
        return caches;
    }

    public void setCaches(Collection<MemcachedCache> caches) {
        this.caches = caches;
    }
}
