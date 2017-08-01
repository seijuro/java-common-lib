package com.github.seijuro.common.webscrap.publicapi;

import com.github.seijuro.common.http.RestfulAPI;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.net.URLEncoder;
import java.util.Properties;

public class StandardInfoAPI extends RestfulAPI {
    public static final String SERVICE_URL = "http://apis.data.go.kr/1230000/HrcspSsstndrdInfoService/getPublicPrcureThngInfoThng";
    public static final String Encoding = "UTF-8";

    public static class Config extends Properties {
        public static final String SERVICE_KEY = "ServiceKey";

        public static final String NUM_OF_ROWS = "numOfRows";
        public static final String PAGE_NO = "pageNo";
        public static final String INQUERY_DIV = "inqryDiv";
        public static final String INQUERY_BEGIN_DATE = "inqryBgnDt";
        public static final String INQUERY_END_DATE = "inqryEndDt";
        public static final String REGISTER_NO = "bfSpecRgstNo";

        static final int INQUERY_DIV_REGISTER_DATE = 1;
        static final int INQUERY_DIV_REGISTER_NO = 2;

        static final int DEFAULT_NUM_OF_ROWS = 10;
        static final int DEFAULT_PAGE_NO = 1;

        public Config(String serviceKey) {
            this.setProperty(SERVICE_KEY, serviceKey);
        }

        public Config setPageSize(int size) {
            this.setProperty(NUM_OF_ROWS, Integer.toString(size > 0 ? size : DEFAULT_NUM_OF_ROWS));

            return this;
        }

        public Config setPageNo(int no) {
            this.setProperty(PAGE_NO, Integer.toString(no > 0 ? no : DEFAULT_PAGE_NO));

            return this;
        }

        public Config byDate(String beginDatetime, String endDatetime) {
            this.setProperty(INQUERY_DIV, Integer.toString(INQUERY_DIV_REGISTER_DATE));
            this.setProperty(INQUERY_BEGIN_DATE, beginDatetime);
            this.setProperty(INQUERY_END_DATE, endDatetime);

            return this;
        }

        public Config byDate(DateTime beginDatetime, DateTime endDatetime) {
            DateTimeFormatter dtFormatter = DateTimeFormat.forPattern("yyyyMMddHHmm");

            return byDate(dtFormatter.print(beginDatetime), dtFormatter.print(endDatetime));
        }

        public Config byRegisterNo(String no) {
            this.setProperty(INQUERY_DIV, Integer.toString(INQUERY_DIV_REGISTER_NO));
            this.setProperty(REGISTER_NO, no);

            return this;
        }
    }

    /**
     * C'tor
     *
     * @param method
     * @param props
     */
    public StandardInfoAPI(RequestMethod method, Properties props) {
        super(method, SERVICE_URL, props, s -> URLEncoder.encode(s, Encoding));
    }
}
