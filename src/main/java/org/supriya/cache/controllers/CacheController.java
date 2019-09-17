package org.supriya.cache.controllers;

import fastcache.ReadResult;
import fastcache.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.supriya.cache.dto.CacheReadResponse;
import org.supriya.cache.dto.CacheStatsResponse;
import org.supriya.cache.dto.CacheWriteResponse;
import org.supriya.cache.service.CacheService;

@Controller
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    @Autowired
    public CacheController(final CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping
    @ResponseBody
    public CacheReadResponse read(@RequestParam(name = "key") final String key) {

        final ReadResult readResult = cacheService.read(key);
        return new CacheReadResponse(readResult.getReadTimeDelay(), readResult.getValue());
    }

    @PostMapping
    @ResponseBody
    public CacheWriteResponse write(@RequestParam(name = "key") final String key, @RequestParam(name = "value") final String value) {
        final int writeTime = cacheService.write(key, value);
        return new CacheWriteResponse(writeTime);
    }

    @GetMapping(path = "stats")
    @ResponseBody
    public CacheStatsResponse stats() {

        final Stats stats = cacheService.stats();
        return new CacheStatsResponse(stats.getAvgReadTime(), stats.getAvgWriteTime(),stats.getAvailableCapacity());
    }

}
