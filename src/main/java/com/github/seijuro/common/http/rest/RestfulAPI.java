package com.github.seijuro.common.http.rest;

import com.github.seijuro.common.IURLEncoder;
import com.github.seijuro.common.http.StatusCode;
import com.github.seijuro.common.http.StatusCodeUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public abstract class RestfulAPI {
    /**
     * RequestMethod
     */
    public enum RequestMethod {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE");

        private final String method;

        RequestMethod(String method) {
            this.method = method;
        }

        @Override
        public String toString() {
            return this.method;
        }
    }

    /**
     * Instance Properties
     */
    @Getter(AccessLevel.PROTECTED)
    private final RequestMethod requestMethod;
    @Getter(AccessLevel.PROTECTED)
    private final String requestURL;

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PUBLIC)
    private Properties properties;
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private IURLEncoder encodeFunc;

    /**
     * C'tor
     *
     * @param method
     * @param url
     */
    public RestfulAPI(RequestMethod method, String url) {
        this.requestMethod = method;
        this.requestURL = url;
    }

    public RestfulAPIResponse request() throws Exception {
        if (this.requestMethod == RequestMethod.GET) {
            return requestGET();
        }

        return new RestfulAPIErrorResponse("Not implemented yet.");
    }

    /**
     * request using 'GET' method
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    protected RestfulAPIResponse requestGET() throws UnsupportedEncodingException {
        StringBuffer response = new StringBuffer();
        int responseCode = -1;

        try {
            String urlText = createRequestGETURL();

            System.out.println("urlText : " + urlText);

            URL url = new URL(urlText);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            assert (this.requestMethod != null);

            conn.setRequestMethod(this.requestMethod.toString());
            conn.setRequestProperty(RequestProperty.UserAgent.getPropertyName(), RequestProperty.UserAgent.MOZILA_5_0);

            String line;
            responseCode = conn.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();
            conn.disconnect();
        }
        catch (Exception excp) {
            return new RestfulAPIErrorResponse(responseCode, response.toString(), excp.getMessage());
        }

        return createResponse(responseCode, response.toString());
    }

    protected String createRequestGETURL() throws UnsupportedEncodingException {
        Enumeration e = this.properties.keys();
        StringBuffer sb = new StringBuffer(this.requestURL);
        boolean isFirst = true;

        while (e.hasMoreElements()) {
            String key = (String)(e.nextElement());
            String value = this.properties.getProperty(key);

            if (isFirst) {
                isFirst = false;
                sb.append("?");
            }
            else {
                sb.append("&");
            }

            sb.append(this.encodeFunc.encode(key)).append("=").append(this.encodeFunc.encode(value));
        }

        return sb.toString();
    }


    protected RestfulAPIResponse createResponse(int code, String reponse) {
        StatusCode statusCode = StatusCodeUtils.get(code);
        if (StatusCodeUtils.isOK(statusCode)) {
            return new RestfulAPIResponse(code, reponse);
        }

        StringBuffer sb = new StringBuffer();
        StatusCodeUtils.format(statusCode, sb::append);
        String message = sb.toString();

        return new RestfulAPIErrorResponse(statusCode.getCode(), reponse, message);
    }
}
