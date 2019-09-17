package org.supriya.cache.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CacheWriteResponse {

    private final int timeTaken;

    public CacheWriteResponse(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public int getTimeTaken() {
        return timeTaken;
    }
}
