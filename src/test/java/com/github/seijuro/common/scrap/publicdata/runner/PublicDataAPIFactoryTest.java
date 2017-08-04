package com.github.seijuro.common.scrap.publicdata.runner;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIServices;
import com.github.seijuro.common.scrap.publicdata.api.*;
import com.github.seijuro.common.scrap.publicdata.api.config.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PublicDataAPIFactoryTest {
    final String sampleServiceKey = "test service-key";

    @Test
    public void testExceptionalAPIUsage() {
        try {
            BusinessPlaceInfoAPIConfig config = new BusinessPlaceInfoAPIConfig();
            PublicDataAPI api = PublicDataAPIFactory.create(null, config, sampleServiceKey);
        }
        catch (Exception excp) {
            return;
        }

        assertTrue(false);
    }

    @Test
    public void testCreateBusinessPlaceInfoAPI() {
        try {
            BusinessPlaceInfoAPIConfig config = new BusinessPlaceInfoAPIConfig();
            PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.NPS_BUSINESS_PLACE_NORMAL, config, sampleServiceKey);

            assertNotNull(api);
            assertEquals(BusinessPlaceInfoAPI.class, api.getClass());

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        assertTrue(false);
    }

    @Test
    public void testCreateBusinessPlaceDetailInfoAPI() {
        try {
            BusinessPlaceDetailInfoAPIConfig config = new BusinessPlaceDetailInfoAPIConfig();
            PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.NPS_BUSINESS_PLACE_DETAIL, config, sampleServiceKey);

            assertNotNull(api);
            assertEquals(BusinessPlaceDetailInfoAPI.class, api.getClass());

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        assertTrue(false);
    }

    @Test
    public void testCreateStatsAPI() {
        try {
            StatsAPIConfig config = new StatsAPIConfig();
            PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.NPS_STATS, config, sampleServiceKey);

            assertNotNull(api);
            assertEquals(StatsAPI.class, api.getClass());

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        assertTrue(false);
    }

    @Test
    public void testCreateConstructSpecificationInfoAPI() {
        try {
            SpecificationInfoAPIConfig config = new SpecificationInfoAPIConfig();
            PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.SPEC_CONSTRUCT, config, sampleServiceKey);

            assertNotNull(api);
            assertEquals(ConstructSpecificationInfoAPI.class, api.getClass());

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        assertTrue(false);
    }

    @Test
    public void testCreateForeignCapitalSpecificationInfoAPI() {
        try {
            SpecificationInfoAPIConfig config = new SpecificationInfoAPIConfig();
            PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.SPEC_FOREIGNCAPITAL, config, sampleServiceKey);

            assertNotNull(api);
            assertEquals(ForeignCapitalSpecificationInfoAPI.class, api.getClass());

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        assertTrue(false);
    }

    @Test
    public void testCreateServiceSpecificationInfoAPI() {
        try {
            SpecificationInfoAPIConfig config = new SpecificationInfoAPIConfig();
            PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.SPEC_SERVICE, config, sampleServiceKey);

            assertNotNull(api);
            assertEquals(ServiceSpecificationInfoAPI.class, api.getClass());

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        assertTrue(false);
    }

    @Test
    public void testProductServiceSpecificationInfoAPI() {
        try {
            SpecificationInfoAPIConfig config = new SpecificationInfoAPIConfig();
            PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.SPEC_PRODUCT, config, sampleServiceKey);

            assertNotNull(api);
            assertEquals(ProductSpecificationInfoAPI.class, api.getClass());

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        assertTrue(false);
    }

    @Test
    public void testRecallServiceSpecificationInfoAPI() {
        try {
            RecallAPIConfig config = new RecallAPIConfig();

            {
                PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.RECALL, config, sampleServiceKey);

                assertNotNull(api);
                assertEquals(RecallAPI.class, api.getClass());
            }

            {
                PublicDataAPI api = PublicDataAPIFactory.create(PublicDataAPIServices.RECALL_PAGEABLE, config, sampleServiceKey);

                assertNotNull(api);
                assertEquals(RecallAPI.class, api.getClass());
            }

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        assertTrue(false);
    }
}
