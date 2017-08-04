package com.github.seijuro.common.scrap.publicdata.api;

import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;

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
    public ServiceSpecificationInfoAPI(PublicDataAPIConfig config, String serviceKey) {
        super(SERVICE_URL, config, serviceKey);
    }
}
