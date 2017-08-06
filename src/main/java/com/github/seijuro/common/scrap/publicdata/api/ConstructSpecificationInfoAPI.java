package com.github.seijuro.common.scrap.publicdata.api;

import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;
import lombok.AccessLevel;
import lombok.Getter;

public class ConstructSpecificationInfoAPI extends PublicDataAPI {
    @Getter(AccessLevel.PUBLIC)
    static final String serviceURL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoFrgcpt";

    /**
     * C'tor
     *
     * @param config
     * @param serviceKey
     */
    public ConstructSpecificationInfoAPI(PublicDataAPIConfig config, String serviceKey) {
        super(getServiceURL(), config, serviceKey);
    }
}
