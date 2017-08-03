package com.github.seijuro.common.scrap.publicdata.nps;

import com.github.seijuro.common.scrap.publicdata.PublicData;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class NPSData extends PublicData {
    public NPSData(Builder builder) {
        super(builder);
    }
    public static abstract class Builder extends PublicData.Builder {
        public abstract NPSData build();
    }
}
