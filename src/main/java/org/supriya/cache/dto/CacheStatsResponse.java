package org.supriya.cache.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CacheStatsResponse {

    private final float avgReadTime;
    private final float avgWriteTime;
    private final float availableCapacity;


    public CacheStatsResponse(float avgReadTime, float avgWriteTime, float availableCapacity) {
        this.avgReadTime = avgReadTime;
        this.avgWriteTime = avgWriteTime;
        this.availableCapacity = availableCapacity;
    }

    public float getAvgReadTime() {
        return avgReadTime;
    }

    public float getAvgWriteTime() {
        return avgWriteTime;
    }

    public float getAvailableCapacity() {
        return availableCapacity;
    }


}
