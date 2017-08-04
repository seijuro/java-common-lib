package com.github.seijuro.common.scrap.publicdata.api.config;

import com.github.seijuro.common.scrap.publicdata.property.PublicDataProperty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class SpecificationAPIConfig extends PublicDataAPIConfig {
    //  general
    public static final String NUM_OF_ROWS = PublicDataProperty.Request.NUM_OF_ROWS;
    public static final String PAGE_NO = PublicDataProperty.Request.PAGE_NO;
    //  specific
    public static final String INQUERY_DIV = "inqryDiv";
    public static final String INQUERY_BEGIN_DATE = "inqryBgnDt";
    public static final String INQUERY_END_DATE = "inqryEndDt";
    public static final String REGISTER_NO = "bfSpecRgstNo";

    //  reserved
    static final int INQUERY_DIV_DATE = 1;
    static final int INQUERY_DIV_REG_NO = 2;

    //  default(s)
    static final int DEFAULT_NUM_OF_ROWS = 10;
    static final int DEFAULT_PAGE_NO = 1;

    public SpecificationAPIConfig() {
        super();
    }

    public SpecificationAPIConfig setPageSize(int size) {
        this.setProperty(NUM_OF_ROWS, Integer.toString(size > 0 ? size : DEFAULT_NUM_OF_ROWS));

        return this;
    }

    public SpecificationAPIConfig setPageNo(int no) {
        this.setProperty(PAGE_NO, Integer.toString(no > 0 ? no : DEFAULT_PAGE_NO));

        return this;
    }

    public SpecificationAPIConfig byDate(String beginDatetime, String endDatetime) {
        this.setProperty(INQUERY_DIV, Integer.toString(INQUERY_DIV_DATE));
        this.setProperty(INQUERY_BEGIN_DATE, beginDatetime);
        this.setProperty(INQUERY_END_DATE, endDatetime);

        return this;
    }

    public SpecificationAPIConfig byDate(DateTime beginDatetime, DateTime endDatetime) {
        DateTimeFormatter dtFormatter = DateTimeFormat.forPattern("yyyyMMddHHmm");

        return byDate(dtFormatter.print(beginDatetime), dtFormatter.print(endDatetime));
    }

    public SpecificationAPIConfig byRegisterNo(String no) {
        this.setProperty(INQUERY_DIV, Integer.toString(INQUERY_DIV_REG_NO));
        this.setProperty(REGISTER_NO, no);

        return this;
    }
}
