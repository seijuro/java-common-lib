package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.scrap.publicdata.services.nps.detail.BusinessPlaceDetailInfoAPIResponseParser;
import com.github.seijuro.common.scrap.publicdata.services.nps.normal.BusinessPlaceInfoAPIResponseParser;
import com.github.seijuro.common.scrap.publicdata.services.nps.stats.StatsAPIResponseParser;
import com.github.seijuro.common.scrap.publicdata.services.recall.RecallAPIPageableResponseParser;
import com.github.seijuro.common.scrap.publicdata.services.recall.RecallAPIResponseParser;
import com.github.seijuro.common.scrap.publicdata.services.spec.SpecificationInfoAPIResponseParser;

public class PublicDataAPIResponseParserFactory {
    /**
     * Factory method
     *
     * @param type
     * @return
     */
    public static PublicDataAPIResponseParser create(PublicDataAPIServices type) {
        if (type == PublicDataAPIServices.NPS_BUSINESS_PLACE_NORMAL) {
            return new BusinessPlaceInfoAPIResponseParser();
        }
        else if (type == PublicDataAPIServices.NPS_BUSINESS_PLACE_DETAUL) {
            return new BusinessPlaceDetailInfoAPIResponseParser();
        }
        else if (type == PublicDataAPIServices.NPS_STATS) {
            return new StatsAPIResponseParser();
        }
        else if (type == PublicDataAPIServices.SPEC_CONSTRUCT ||
                type == PublicDataAPIServices.SPEC_FOREIGNCAPITAL ||
                type == PublicDataAPIServices.SPEC_PRODUCT ||
                type == PublicDataAPIServices.SPEC_SERVICE) {
            return new SpecificationInfoAPIResponseParser();
        }
        else if (type == PublicDataAPIServices.RECALL) {
            return new RecallAPIResponseParser();
        }
        else if (type == PublicDataAPIServices.RECALL_PAGEABLE) {
            return new RecallAPIPageableResponseParser();
        }

        assert (0 == 1);

        return null;
    }
}
