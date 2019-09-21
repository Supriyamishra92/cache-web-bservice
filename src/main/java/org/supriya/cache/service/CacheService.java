package org.supriya.cache.service;

import fastcache.ReadResult;
import fastcache.Stats;

public interface CacheService {

    ReadResult read(String key);

    int write(String key, String value);

    Stats stats();
}
