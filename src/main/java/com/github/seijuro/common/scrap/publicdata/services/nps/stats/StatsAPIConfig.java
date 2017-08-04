package com.github.seijuro.common.scrap.publicdata.services.nps.stats;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPIConfig;

public class StatsAPIConfig extends PublicDataAPIConfig {
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
