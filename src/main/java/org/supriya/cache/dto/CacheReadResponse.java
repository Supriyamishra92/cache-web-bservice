package org.supriya.cache.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CacheReadResponse {

    private final int timeTaken;

    private final String value;

    public CacheReadResponse(int timeTaken, String value) {
        this.timeTaken = timeTaken;
        this.value = value;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public String getValue() {
        return value;
    }
}
