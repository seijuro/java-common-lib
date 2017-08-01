package com.github.seijuro.common.webscrap.publicapi;

public class CommonProperty {
    public static final String Encoding = "UTF-8";

    public static class Request {
        public static final String SERVICE_KEY = "ServiceKey";

        public static final String NUM_OF_ROWS = "numOfRows";
        public static final String PAGE_NO = "pageNo";
    }

    public static class Result {
        public static final String RESULT_CODE = "resultCode";
        public static final String RESULT_MESSAGE = "resultMsg";

        public static final String NUM_OF_ROWS = Request.NUM_OF_ROWS;
        public static final String PAGE_NO = Request.PAGE_NO;
        public static final String TOTAL_COUNT = "totalCount";
    }

    public static class Error {
        public static final String ERROR_MESSAGE = "errMsg";
        public static final String REASON_CODE = "returnReasonCode";
        public static final String AUTHENTICATION_MESSAGE = "returnAuthMsg";
    }
}
