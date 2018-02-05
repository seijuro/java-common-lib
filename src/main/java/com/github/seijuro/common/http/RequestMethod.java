package com.github.seijuro.common.http;

import lombok.Getter;

public enum RequestMethod {
    POST("POST"),
    GET("GET"),
    PUT("PUT"),
    DELETE("DELETE");

    @Getter
    private final String method;

    RequestMethod(String $method) {
        this.method = $method;
    }
}
