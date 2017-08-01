package com.github.seijuro.common.webscrap.publicapi.stdinfo;

import com.github.seijuro.common.webscrap.publicapi.PublicDataAPI;

import java.util.Properties;

public class ProductStdInfoAPI extends PublicDataAPI {
    public static final String SERVICE_URL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoThng";

    public static String getServiceURL() {
        return SERVICE_URL;
    }

    /**
     * C'tor
     *
     * @param config
     * @param serviceKey
     */
    public ProductStdInfoAPI(Properties config, String serviceKey) {
        super(getServiceURL(), config, serviceKey);
    }
}
