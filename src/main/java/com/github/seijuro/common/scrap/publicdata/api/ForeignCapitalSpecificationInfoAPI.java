package com.github.seijuro.common.scrap.publicdata.api;

import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;
import lombok.AccessLevel;
import lombok.Getter;

public class ForeignCapitalSpecificationInfoAPI extends PublicDataAPI {
    @Getter(AccessLevel.PUBLIC)
    public static final String serviceURL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoFrgcpt";

    /**
     * C'tor
     *
     * @param config
     * @param serviceKey
     */
    public ForeignCapitalSpecificationInfoAPI(PublicDataAPIConfig config, String serviceKey) {
        super(getServiceURL(), config, serviceKey);
    }
}
