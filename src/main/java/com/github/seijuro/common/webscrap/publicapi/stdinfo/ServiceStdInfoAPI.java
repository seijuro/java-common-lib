package com.github.seijuro.common.webscrap.publicapi.stdinfo;

import com.github.seijuro.common.webscrap.publicapi.PublicDataAPI;

import java.util.Properties;

public class ServiceStdInfoAPI extends PublicDataAPI {
    static final String SERVICE_URL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoCnstwk";

    public static String getServiceURL() {
        return SERVICE_URL;
    }

    /**
     * C'tor
     *
     * @param config
     * @param serviceKey
     */
    public ServiceStdInfoAPI(Properties config, String serviceKey) {
        super(SERVICE_URL, config, serviceKey);
    }
}
