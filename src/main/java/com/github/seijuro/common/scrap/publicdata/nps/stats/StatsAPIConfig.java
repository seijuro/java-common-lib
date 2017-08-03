package com.github.seijuro.common.scrap.publicdata.nps.stats;

import com.github.seijuro.common.scrap.publicdata.PublicDataConfig;

public class StatsAPIConfig extends PublicDataConfig {
    public static final String ID = "seq";
    public static final String YEAR_MONTH = "data_crt_ym";

    public StatsAPIConfig() {
        super();
    }

    public StatsAPIConfig setId(String id) {
        this.setProperty(ID, id);
        return this;
    }

    public StatsAPIConfig setYearMonth(String yyyymm) {
        this.setProperty(YEAR_MONTH, yyyymm);
        return this;
    }
}
