package com.github.seijuro.common.scrap.publicdata.api;

import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;
import lombok.AccessLevel;
import lombok.Getter;

public class ProductSpecificationInfoAPI extends PublicDataAPI {
    @Getter(AccessLevel.PUBLIC)
    public static final String serviceURL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoThng";

    /**
     * C'tor
     *
     * @param config
     * @param serviceKey
     */
    public ProductSpecificationInfoAPI(PublicDataAPIConfig config, String serviceKey) {
        super(getServiceURL(), config, serviceKey);
    }
}
