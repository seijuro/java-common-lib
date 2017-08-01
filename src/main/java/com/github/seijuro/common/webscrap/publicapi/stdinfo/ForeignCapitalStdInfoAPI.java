package com.github.seijuro.common.webscrap.publicapi.stdinfo;

import com.github.seijuro.common.http.RestfulAPI;
import com.github.seijuro.common.webscrap.publicapi.CommonProperty;

import java.net.URLEncoder;
import java.util.Properties;

public class ForeignCapitalStdInfoAPI extends RestfulAPI {
    public static final String SERVICE_URL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoFrgcpt";

    /**
     * C'tor
     *
     * @param method
     * @param props
     */
    public ForeignCapitalStdInfoAPI(RequestMethod method, Properties props) {
        super(method, SERVICE_URL, props, s -> URLEncoder.encode(s, CommonProperty.Encoding));
    }
}
