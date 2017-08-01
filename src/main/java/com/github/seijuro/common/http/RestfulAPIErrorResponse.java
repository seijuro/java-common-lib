package com.github.seijuro.common.http;

public class RestfulAPIErrorResponse extends RestfulAPIResponse {
    public static boolean isError(RestfulAPIResponse response) {
        if (response instanceof RestfulAPIErrorResponse) {
            return true;
        }

        return false;
    }

    /**
     * Instance Properties
     */
    private final String message;

    /**
     * C'tor
     *
     * @param code
     * @param response
     * @param message
     */
    public RestfulAPIErrorResponse(int code, String response, String message) {
        super(code, response);

        this.message = message;
    }

    /**
     * C'tor
     *
     * @param message
     */
    public RestfulAPIErrorResponse(String message) {
        this(-1, null, message);
    }

    public String getMessage() {
        return this.message;
    }
}
