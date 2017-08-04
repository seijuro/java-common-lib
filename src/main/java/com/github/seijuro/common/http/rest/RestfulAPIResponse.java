package com.github.seijuro.common.http.rest;

public class RestfulAPIResponse {
    protected final int httpResponseCode;
    protected final String responseText;

    public RestfulAPIResponse(int code, String response) {
        this.httpResponseCode = code;
        this.responseText = response;
    }

    public int getHttpResponseCode() {
        return this.httpResponseCode;
    }

    public String getResponse() {
        return this.responseText;
    }
}