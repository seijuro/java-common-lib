package com.github.seijuro.common.webscrap.publicapi.stdinfo;

import com.github.seijuro.common.webscrap.publicapi.CommonProperty;
import com.github.seijuro.common.webscrap.publicapi.PublicDataAPIResponse;
import com.github.seijuro.common.webscrap.publicapi.PublicDataAPIResponseParser;

public class ProductStdInfoAPIResponseParser extends PublicDataAPIResponseParser {
    static class ReservedProperty {
        //  result
        public static final String RESULT_CODE = CommonProperty.Result.RESULT_CODE;
        public static final String RESULT_MESSAGE = CommonProperty.Result.RESULT_MESSAGE;

        //  page
        public static final String NUM_OF_ROWS = CommonProperty.Result.NUM_OF_ROWS;
        public static final String PAGE_NO = CommonProperty.Result.PAGE_NO;
        public static final String TOTAL_COUNT = CommonProperty.Result.TOTAL_COUNT;

        //  product
        public static final String BSNS_DIV_NAME = "bsnsDivNm";
        public static final String REF_NO = "refNo";
        public static final String PRODUCT_NAME = "prdctClsfcNoNm";

        public static final String ORDER_INSTR_NAME = "orderInsttNm";
        public static final String DEMAND_INST_NAME = "rlDminsttNm";
        public static final String ASIGN_BUDGET_AMOUNT = "asignBdgtAmt";

        public static final String RECEIPT_DATE = "rcptDt";
        public static final String OPITION_REG_CLOSE_DATE = "opninRgstClseDt";
        public static final String OFFICIAL_TELNO = "ofclTelNo";
        public static final String OFFICIAL_NAME = "ofclNm";
        public static final String SW_BIZOBJ_YN = "swBizObjYn";
        public static final String DELIVERY_TIMELIMIT_DATE = "dlvrTmlmtDt";
        public static final String DELIVERY_DAY_NUM = "dlvrDaynum";
        public static final String BEFORRE_SPEC_REG_NO = "bfSpecRgstNo";
        public static final String SPEC_DOCFILE_URL_1 = "specDocFileUrl1";
        public static final String SPEC_DOCFILE_URL_2 = "specDocFileUrl2";
        public static final String SPEC_DOCFILE_URL_3 = "specDocFileUrl3";
        public static final String SPEC_DOCFILE_URL_4 = "specDocFileUrl4";
        public static final String SPEC_DOCFILE_URL_5 = "specDocFileUrl5";
        public static final String PRODUCT_DETAIL_LIST = "prdctDtlList";
        public static final String REG_DATE = "rgstDt";
        public static final String CHANGE_DATE = "chgDt";
        public static final String BID_NOTICE_NO_LIST = "bidNtceNoList";
    }

    /**
     * C'tor
     *
     * @param type
     * @param input
     */
    public ProductStdInfoAPIResponseParser(InputType type, String input) {
        super(type, input);
    }

    @Override
    protected void handleTagBegin(String tag) {
        //  TODO remove ...
        System.out.println("begin : [" + tag + "]");
    }

    @Override
    protected void handleTagEnd(String tag, String value) {
        //  TODO remove ...
        System.out.println("end : [" + tag + "], value : ["  + value + "]");
    }


}
