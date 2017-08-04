package com.github.seijuro.common.scrap.publicdata.api;

import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;

public class BusinessPlaceDetailInfoAPI extends PublicDataAPI {
    public static final String SERVICE_URL = "http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getDetailInfoSearch";

    public static String getServiceURL() {
        return SERVICE_URL;
    }

    /**
     * C'tor
     *
     * @param props
     * @param serviceKey
     */
    public BusinessPlaceDetailInfoAPI(PublicDataAPIConfig props, String serviceKey) {
        super(getServiceURL(), props, serviceKey);
    }
}
