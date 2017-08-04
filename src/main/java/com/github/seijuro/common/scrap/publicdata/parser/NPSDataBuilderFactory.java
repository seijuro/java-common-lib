package com.github.seijuro.common.scrap.publicdata.parser;

import com.github.seijuro.common.scrap.publicdata.result.item.NPSData;
import com.github.seijuro.common.scrap.publicdata.result.item.BusinessPlaceDetailInfo;
import com.github.seijuro.common.scrap.publicdata.result.item.BusinessPlaceInfo;
import com.github.seijuro.common.scrap.publicdata.result.item.Stats;

class NPSDataBuilderFactory {
    public static <T extends NPSData.Builder> NPSData.Builder create(Class<T> Clazz) {
        if (Clazz == BusinessPlaceInfo.Builder.class) {
            return new BusinessPlaceInfo.Builder();
        }
        else if (Clazz == BusinessPlaceDetailInfo.Builder.class) {
            return new BusinessPlaceDetailInfo.Builder();
        }
        else if (Clazz == Stats.Builder.class) {
            return new Stats.Builder();
        }

        assert (0 == 1);

        return null;
    }
}
