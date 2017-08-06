package com.github.seijuro.common.scrap.publicdata.api;

import com.github.seijuro.common.IURLEncoder;
import com.github.seijuro.common.http.rest.RestfulAPI;
import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;
import com.github.seijuro.common.scrap.publicdata.property.PublicDataProperty;
import lombok.AccessLevel;
import lombok.Getter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PublicDataAPI extends RestfulAPI {
    static final RequestMethod APIRequestMethod = RequestMethod.GET;
    static final IURLEncoder ParameterEncoder = s -> URLEncoder.encode(s, PublicDataProperty.Encoding);
    static final String ServiceKey = "ServiceKey";

    @Getter(AccessLevel.PROTECTED)
    private final String serviceKey;

    /**
     * C'tor
     *
     * @param url
     * @param config
     */
    public PublicDataAPI(String url, PublicDataAPIConfig config, String serviceKey) {
        super(APIRequestMethod, url, config.getProperties(), ParameterEncoder);

        this.serviceKey = serviceKey;
    }

    @Override
    protected String createRequestGETURL() throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer(super.createRequestGETURL());

        sb.append((getProperties().size() > 0) ? "&" : "?");
        sb.append(ParameterEncoder.encode(ServiceKey)).append("=").append(getServiceKey());

        String url = sb.toString();

        return url;
    }
}
