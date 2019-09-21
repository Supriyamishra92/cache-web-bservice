package org.supriya.cache.service;

import fastcache.Cache;
import fastcache.MultiLevelCache;
import fastcache.ReadResult;
import fastcache.Stats;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("fast-cache")
public class FastCacheService implements CacheService {

    private final Cache cache;

    public FastCacheService() {
        cache = new MultiLevelCache(new int[]{10, 15, 20}, new int[]{2, 4, 6}, new int[]{1, 2, 3});
        cache.set("k", "v");
    }

    @Override
    public ReadResult read(final String key) {

        return cache.get(key);
    }

    @Override
    public int write(String key, String value) {
        return cache.set(key, value);
    }

    @Override
    public Stats stats() {
        return cache.stats();
    }
}
