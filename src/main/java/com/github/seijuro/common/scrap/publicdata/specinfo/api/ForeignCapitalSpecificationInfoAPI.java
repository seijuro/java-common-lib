package com.github.seijuro.common.scrap.publicdata.specinfo.api;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPI;
import com.github.seijuro.common.scrap.publicdata.PublicDataConfig;

public class ForeignCapitalSpecificationInfoAPI extends PublicDataAPI {
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
    public ForeignCapitalSpecificationInfoAPI(PublicDataConfig props, String serviceKey) {
        super(SERVICE_URL, props, serviceKey);
    }
}
