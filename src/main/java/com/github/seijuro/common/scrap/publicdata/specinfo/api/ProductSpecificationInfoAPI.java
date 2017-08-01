package com.github.seijuro.common.scrap.publicdata.specinfo.api;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPI;

import java.util.Properties;

public class ProductSpecificationInfoAPI extends PublicDataAPI {
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
    public ProductSpecificationInfoAPI(Properties config, String serviceKey) {
        super(getServiceURL(), config, serviceKey);
    }
}
