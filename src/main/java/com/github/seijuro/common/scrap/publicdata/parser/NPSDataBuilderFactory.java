package com.github.seijuro.common.scrap.publicdata.parser;

import com.github.seijuro.common.scrap.publicdata.result.item.NPSData;
import com.github.seijuro.common.scrap.publicdata.result.item.BusinessPlaceDetailData;
import com.github.seijuro.common.scrap.publicdata.result.item.BusinessPlaceData;
import com.github.seijuro.common.scrap.publicdata.result.item.StatsData;

class NPSDataBuilderFactory {
    public static <T extends NPSData.Builder> NPSData.Builder create(Class<T> Clazz) {
        if (Clazz == BusinessPlaceData.Builder.class) {
            return new BusinessPlaceData.Builder();
        }
        else if (Clazz == BusinessPlaceDetailData.Builder.class) {
            return new BusinessPlaceDetailData.Builder();
        }
        else if (Clazz == StatsData.Builder.class) {
            return new StatsData.Builder();
        }

        assert (0 == 1);

        return null;
    }
}
