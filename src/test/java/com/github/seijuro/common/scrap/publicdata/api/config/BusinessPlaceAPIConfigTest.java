package com.github.seijuro.common.scrap.publicdata.api.config;

import com.github.seijuro.common.scrap.publicdata.api.BusinessPlaceInfoAPI;

import static org.junit.Assert.assertNotNull;

public class BusinessPlaceAPIConfigTest {
    public void testInstantiation() {
        BusinessPlaceAPIConfig config = new BusinessPlaceAPIConfig();
        assertNotNull(config);

        config.setProperty(BusinessPlaceAPIConfig.Property.ADDRESS_DG, "01");
        config.setProperty(BusinessPlaceAPIConfig.Property.ADDRESS_SGG, "101");
        config.setProperty(BusinessPlaceAPIConfig.Property.ADDRESS_EMD, "202");

    }
}
