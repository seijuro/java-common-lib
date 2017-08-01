package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.http.RestfulAPI;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

public class PublicDataAPI extends RestfulAPI {
    static final RequestMethod APIRequestMethod = RequestMethod.GET;
    static final IParamEncoder ParameterEncoder = s -> URLEncoder.encode(s, PublicDataProperty.Encoding);
    static final String ServiceKey = "ServiceKey";

    private final String serviceKey;

    /**
     * C'tor
     *
     * @param url
     * @param props
     */
    public PublicDataAPI(String url, Properties props, String serviceKey) {
        super(APIRequestMethod, url, props, ParameterEncoder);

        this.serviceKey = serviceKey;
    }

    protected String getServiceKey() {
        return this.serviceKey;
    }

    @Override
    protected String createRequestGETURL() throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer(super.createRequestGETURL());

        if (this.properties.size() > 0) {
            sb.append("&").append(ParameterEncoder.encode(ServiceKey)).append("=").append(getServiceKey());
        }

        return sb.toString();
    }
}
