package com.github.seijuro.common.scrap.publicdata.specinfo.api;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPI;

import java.util.Properties;

public class ServiceSpecificationInfoAPI extends PublicDataAPI {
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
    public ServiceSpecificationInfoAPI(Properties config, String serviceKey) {
        super(SERVICE_URL, config, serviceKey);
    }
}
