package com.github.seijuro.common.scrap.publicdata.nps.api;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPI;

import java.util.Properties;

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
    public BusinessPlaceDetailInfoAPI(Properties props, String serviceKey) {
        super(getServiceURL(), props, serviceKey);
    }
}
