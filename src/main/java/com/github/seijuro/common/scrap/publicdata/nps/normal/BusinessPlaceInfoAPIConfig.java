package com.github.seijuro.common.scrap.publicdata.nps.normal;

import com.github.seijuro.common.scrap.publicdata.PublicDataConfig;
import com.github.seijuro.common.scrap.publicdata.PublicDataProperty;

public class BusinessPlaceInfoAPIConfig extends PublicDataConfig {
    //  general
    public static final String NUM_OF_ROWS = PublicDataProperty.Request.NUM_OF_ROWS;
    public static final String PAGE_NO = PublicDataProperty.Request.PAGE_NO;

    //  specific
    public static final String ADDRESS_DG = "ldong_addr_mgpl_dg_cd";
    public static final String ADDRESS_SGG = "ldong_addr_mgpl_sggu_cd";
    public static final String ADDRESS_EMD = "ldong_addr_mgpl_sggu_emd_cd";
    public static final String NAME = "wkpl_nm";
    public static final String DIVISION_CODE = "wkpl_styl_dvcd";
    public static final String REGISTRATION_NUMBER = "bzowr_rgst_no";

    public enum DivisionCode {
        COPORATION("1"),
        INDIVISUAL("2");

        private final String code;

        DivisionCode(String $code) {
            this.code = $code;
        }

        public String toCodeString() {
            return this.code;
        }
    }

    //  constant(s)
    static final int DEFAULT_NUM_OF_ROWS = 100;
    static final int UPPERBOUND_NUM_OF_ROWS = 10000;
    static final int LOWERBOUND_NUM_OF_ROWS = 0;
    static final int DEFAULT_PAGE_NO = 1;
    static final int LOWERBOUND_PAGE_NO = 0;

    public BusinessPlaceInfoAPIConfig() {
        super();
    }

    public BusinessPlaceInfoAPIConfig setPageSize(int size) {
        this.setProperty(NUM_OF_ROWS, Integer.toString((size > LOWERBOUND_NUM_OF_ROWS && size < UPPERBOUND_NUM_OF_ROWS) ? size : DEFAULT_NUM_OF_ROWS));

        return this;
    }

    public BusinessPlaceInfoAPIConfig setPageNo(int no) {
        this.setProperty(PAGE_NO, Integer.toString(no > LOWERBOUND_PAGE_NO ? no : DEFAULT_PAGE_NO));

        return this;
    }

    public BusinessPlaceInfoAPIConfig setRegistrationNumber(String number) {
        this.setProperty(REGISTRATION_NUMBER, number);

        return this;
    }

    public BusinessPlaceInfoAPIConfig setDivisionCode(DivisionCode code) {
        this.setProperty(DIVISION_CODE, code.toCodeString());

        return this;
    }

    public BusinessPlaceInfoAPIConfig setName(String name) {
        this.setProperty(NAME, name);

        return this;
    }

    public BusinessPlaceInfoAPIConfig setAddressDG(String addr) {
        this.setProperty(ADDRESS_DG, addr);
        return this;
    }

    public BusinessPlaceInfoAPIConfig setAddressSGG(String addr) {
        this.setProperty(ADDRESS_SGG, addr);
        return this;
    }

    public BusinessPlaceInfoAPIConfig setAddressEMD(String addr) {
        this.setProperty(ADDRESS_EMD, addr);
        return this;
    }
}
