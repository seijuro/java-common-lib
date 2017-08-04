package com.github.seijuro.common.scrap.publicdata.services.spec.api;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPI;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIConfig;

public class ConstructSpecificationInfoAPI extends PublicDataAPI {
    public static final String SERVICE_URL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoFrgcpt";

    public static String getServiceURL() {
        return SERVICE_URL;
    }

    /**
     * C'tor
     *
     * @param config
     * @param serviceKey
     */
    public ConstructSpecificationInfoAPI(PublicDataAPIConfig config, String serviceKey) {
        super(SERVICE_URL, config, serviceKey);
    }
}
