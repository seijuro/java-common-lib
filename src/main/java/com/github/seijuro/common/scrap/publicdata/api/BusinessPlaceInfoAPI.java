package com.github.seijuro.common.scrap.publicdata.api;

import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;
import lombok.AccessLevel;
import lombok.Getter;

public class BusinessPlaceInfoAPI extends PublicDataAPI {
    @Getter(AccessLevel.PUBLIC)
    public static final String serviceURL = "http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch";

    /**
     * C'tor
     *
     * @param props
     * @param serviceKey
     */
    public BusinessPlaceInfoAPI(PublicDataAPIConfig props, String serviceKey) {
        super(getServiceURL(), props, serviceKey);
    }
}
