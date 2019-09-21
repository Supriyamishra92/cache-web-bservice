package org.supriya.cache.service;

import fastcache.ReadResult;
import fastcache.RingBuffer;
import fastcache.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Qualifier("redis-cache")
public class RedisCacheService implements CacheService {

    private final RedisTemplate<String, String> redisTemplate;
    private final RingBuffer readTimes = new RingBuffer(10);
    private final RingBuffer writeTimes = new RingBuffer(10);

    @Autowired
    public RedisCacheService(final RedisTemplate<String, String> redisTemplate) {

        this.redisTemplate = redisTemplate;
    }

    @Override
    public ReadResult read(final String key) {

        final long startTime = System.currentTimeMillis();
        final String value = redisTemplate.boundValueOps(key).get();

        final int readTimeDelay = (int) (System.currentTimeMillis() - startTime);
        readTimes.add(readTimeDelay);

        return new ReadResult(value, readTimeDelay);
    }

    @Override
    public int write(final String key, final String value) {

        final long startTime = System.currentTimeMillis();
        redisTemplate.boundValueOps(key).set(value);

        final int writeTimeDelay = (int) (System.currentTimeMillis() - startTime);
        writeTimes.add(writeTimeDelay);
        return writeTimeDelay;
    }

    @Override
    public Stats stats() {

        return new Stats(readTimes.average(), writeTimes.average(), Integer.MAX_VALUE);
    }
}
