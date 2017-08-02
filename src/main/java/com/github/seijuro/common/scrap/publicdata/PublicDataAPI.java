package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.IURLEncoder;
import com.github.seijuro.common.http.RestfulAPI;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PublicDataAPI extends RestfulAPI {
    static final RequestMethod APIRequestMethod = RequestMethod.GET;
    static final IURLEncoder ParameterEncoder = s -> URLEncoder.encode(s, PublicDataProperty.Encoding);
    static final String ServiceKey = "ServiceKey";

    private final String serviceKey;

    /**
     * C'tor
     *
     * @param url
     * @param config
     */
    public PublicDataAPI(String url, PublicDataConfig config, String serviceKey) {
        super(APIRequestMethod, url, config, ParameterEncoder);

        this.serviceKey = serviceKey;
    }

    protected String getServiceKey() {
        return this.serviceKey;
    }

    @Override
    protected String createRequestGETURL() throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer(super.createRequestGETURL());

        sb.append((this.properties.size() > 0) ? "&" : "?");
        sb.append(ParameterEncoder.encode(ServiceKey)).append("=").append(getServiceKey());

        String url = sb.toString();

        //  TODO remove ...
        System.out.println("request URL : " + url);

        return url;
    }
}
