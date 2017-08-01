package com.github.seijuro.common.webscrap.publicapi.stdinfo;

import com.github.seijuro.common.http.RestfulAPI;
import com.github.seijuro.common.webscrap.publicapi.CommonProperty;

import java.net.URLEncoder;
import java.util.Properties;

public class ServiceStdInfoAPI extends RestfulAPI {
    public static final String SERVICE_URL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoCnstwk";

    /**
     * C'tor
     *
     * @param method
     * @param config
     */
    public ServiceStdInfoAPI(RestfulAPI.RequestMethod method, Properties config) {
        super(method, SERVICE_URL, config, s -> URLEncoder.encode(s, CommonProperty.Encoding));
    }
}
