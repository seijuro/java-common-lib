package com.github.seijuro.common.scrap.publicdata.nps.detail;

import com.github.seijuro.common.scrap.publicdata.PublicDataConfig;

public class BusinessPlaceDetailInfoAPIConfig extends PublicDataConfig {
    public static final String ID = "seq";

    /**
     * C'tor
     */
    public BusinessPlaceDetailInfoAPIConfig() {
        super();
    }

    public BusinessPlaceDetailInfoAPIConfig setID(String id) {
        this.setProperty(ID, id);
        return this;
    }
}
