package org.supriya.cache.service;

import fastcache.Cache;
import fastcache.MultiLevelCache;
import fastcache.ReadResult;
import fastcache.Stats;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private final Cache cache;

    public CacheService() {
        cache = new MultiLevelCache(new int[]{10, 15, 20}, new int[]{2, 4, 6}, new int[]{1, 2, 3});
        cache.set("k", "v");
    }

    public ReadResult read(final String key) {

        return cache.get(key);
    }

    public int write(String key, String value) {
        return cache.set(key, value);
    }

    public Stats stats() {
        return cache.stats();
    }
}
