package com.github.seijuro.common.scrap.publicdata.runner;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIException;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIServices;
import com.github.seijuro.common.scrap.publicdata.api.*;
import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;

public class PublicDataAPIFactory {
    public static PublicDataAPI create(PublicDataAPIServices type, PublicDataAPIConfig config, String serviceKey) throws PublicDataAPIException {
        if (type == PublicDataAPIServices.NPS_BUSINESS_PLACE_NORMAL) {
            return new BusinessPlaceInfoAPI(config, serviceKey);
        }
        else if (type == PublicDataAPIServices.NPS_BUSINESS_PLACE_DETAUL) {
            return new BusinessPlaceDetailInfoAPI(config, serviceKey);
        }
        else if (type == PublicDataAPIServices.NPS_STATS) {
            return new StatsAPI(config, serviceKey);
        }
        else if (type == PublicDataAPIServices.SPEC_CONSTRUCT) {
            return new ConstructSpecificationInfoAPI(config, serviceKey);
        }
        else if (type == PublicDataAPIServices.SPEC_FOREIGNCAPITAL) {
            return new ForeignCapitalSpecificationInfoAPI(config, serviceKey);
        }
        else if (type == PublicDataAPIServices.SPEC_PRODUCT) {
            return new ProductSpecificationInfoAPI(config, serviceKey);
        }
        else if (type == PublicDataAPIServices.SPEC_SERVICE) {
            return new ServiceSpecificationInfoAPI(config, serviceKey);
        }
        else if (type == PublicDataAPIServices.RECALL
                || type == PublicDataAPIServices.RECALL_PAGEABLE) {
            return new RecallAPI(config, serviceKey);
        }

        throw new PublicDataAPIException("Unknown type or Not implemented yet.");
    }
}
