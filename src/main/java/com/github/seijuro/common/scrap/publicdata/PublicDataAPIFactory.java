package com.github.seijuro.common.scrap.publicdata;

import com.github.seijuro.common.scrap.publicdata.nps.detail.BusinessPlaceDetailInfoAPI;
import com.github.seijuro.common.scrap.publicdata.nps.normal.BusinessPlaceInfoAPI;
import com.github.seijuro.common.scrap.publicdata.nps.stats.StatsAPI;
import com.github.seijuro.common.scrap.publicdata.spec.api.ConstructSpecificationInfoAPI;
import com.github.seijuro.common.scrap.publicdata.spec.api.ForeignCapitalSpecificationInfoAPI;
import com.github.seijuro.common.scrap.publicdata.spec.api.ProductSpecificationInfoAPI;
import com.github.seijuro.common.scrap.publicdata.spec.api.ServiceSpecificationInfoAPI;

public class PublicDataAPIFactory {
    enum Type {
        NPS_BUSINESS_PLACE_NORMAL,
        NPS_BUSINESS_PLACE_DETAUL,
        NPS_STATS,

        CONSTRUCT_SPEC,
        FOREIGNCAPITAL_SPEC,
        PRODUCT_SPEC,
        SERVICE_SPEC;
    }

    public static PublicDataAPI create(Type type, PublicDataConfig config, String serviceKey) throws PublicDataException {
        if (type == Type.NPS_BUSINESS_PLACE_NORMAL) {
            return new BusinessPlaceInfoAPI(config, serviceKey);
        }
        else if (type == Type.NPS_BUSINESS_PLACE_DETAUL) {
            return new BusinessPlaceDetailInfoAPI(config, serviceKey);
        }
        else if (type == Type.NPS_STATS) {
            return new StatsAPI(config, serviceKey);
        }
        else if (type == Type.CONSTRUCT_SPEC) {
            return new ConstructSpecificationInfoAPI(config, serviceKey);
        }
        else if (type == Type.FOREIGNCAPITAL_SPEC) {
            return new ForeignCapitalSpecificationInfoAPI(config, serviceKey);
        }
        else if (type == Type.PRODUCT_SPEC) {
            return new ProductSpecificationInfoAPI(config, serviceKey);
        }
        else if (type == Type.SERVICE_SPEC) {
            return new ServiceSpecificationInfoAPI(config, serviceKey);
        }

        throw new PublicDataException("Unknown type or Not implemented yet.");
    }
}
