package com.github.seijuro.common.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public abstract class RestfulAPI {
    public interface IParamEncoder {
        String encode(String url) throws UnsupportedEncodingException;
    }

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
    protected final RequestMethod requestMethod;
    protected final String requestURL;
    protected final Properties properties;
    protected final IParamEncoder encodeFunc;

    /**
     * C'tor
     *
     * @param method
     * @param url
     * @param props
     */
    public RestfulAPI(RequestMethod method, String url, Properties props, IParamEncoder func) {
        this.requestMethod = method;
        this.requestURL = url;
        this.properties = props;
        this.encodeFunc = func;
    }

    public RestfulAPIResponse request() throws Exception {
        if (this.requestMethod == RequestMethod.GET) {
            return requestGET();
        }

        return new RestfulAPIErrorResponse("Not implemented yet.");
    }

    public RestfulAPIResponse requestGET() throws UnsupportedEncodingException {
        StringBuffer response = new StringBuffer();
        int responseCode = -1;

        try {
            URL url = new URL(createRequestGETURL());
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
        catch (MalformedURLException excp) {
            return new RestfulAPIErrorResponse(responseCode, response.toString(), excp.getMessage());
        }
        catch (ProtocolException excp) {
            return new RestfulAPIErrorResponse(responseCode, response.toString(), excp.getMessage());
        }
        catch (IOException excp) {
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

        // TODO remove ...
        System.out.println("request URL : " + sb.toString());

        return sb.toString();
    }


    protected RestfulAPIResponse createResponse(int code, String reponse) {
        return new RestfulAPIResponse(code, reponse);
    }
}
