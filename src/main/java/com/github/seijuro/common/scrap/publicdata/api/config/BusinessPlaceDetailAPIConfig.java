package com.github.seijuro.common.scrap.publicdata.api.config;

public class BusinessPlaceDetailAPIConfig extends PublicDataAPIConfig {
    public static final String ID = "seq";

    /**
     * C'tor
     */
    public BusinessPlaceDetailAPIConfig() {
        super();
    }

    public BusinessPlaceDetailAPIConfig setID(String id) {
        this.setProperty(ID, id);
        return this;
    }
}
