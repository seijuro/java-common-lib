package com.github.seijuro.common.http;

public class RestfulAPIResponse {
    protected final int responseCode;
    protected final String responseText;

    public RestfulAPIResponse(int code, String response) {
        this.responseCode = code;
        this.responseText = response;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponse() {
        return this.responseText;
    }
}
