package com.github.seijuro.common.webscrap.publicapi.stdinfo;

import com.github.seijuro.common.webscrap.publicapi.PublicDataAPI;

import java.util.Properties;

public class ConstructStdInfoAPI extends PublicDataAPI {
    public static final String SERVICE_URL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoFrgcpt";

    public static String getServiceURL() {
        return SERVICE_URL;
    }

    /**
     * C'tor
     *
     * @param props
     * @param serviceKey
     */
    public ConstructStdInfoAPI(Properties props, String serviceKey) {
        super(SERVICE_URL, props, serviceKey);
    }
}
