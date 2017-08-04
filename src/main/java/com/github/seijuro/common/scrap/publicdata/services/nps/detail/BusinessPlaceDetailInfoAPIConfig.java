package com.github.seijuro.common.scrap.publicdata.services.nps.detail;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIConfig;

public class BusinessPlaceDetailInfoAPIConfig extends PublicDataAPIConfig {
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
