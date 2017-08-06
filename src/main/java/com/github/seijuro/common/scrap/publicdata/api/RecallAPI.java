package com.github.seijuro.common.scrap.publicdata.api;

import com.github.seijuro.common.IURLEncoder;
import com.github.seijuro.common.scrap.publicdata.api.config.PublicDataAPIConfig;
import lombok.AccessLevel;
import lombok.Getter;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;

public class RecallAPI extends PublicDataAPI {
    @Getter(AccessLevel.PUBLIC)
    public static final String serviceURL = "http://www.ibtk.kr/recall_api/";

    /**
     * C'tor
     *
     * @param config
     * @param serviceKey
     */
    public RecallAPI(PublicDataAPIConfig config, String serviceKey) {
        super(getServiceURL(), config, serviceKey);
    }

    @Override
    protected String createRequestGETURL() throws UnsupportedEncodingException {
        //  don't call <code>super.createRequestGETURL</code> method.
        //  super.createRequestGETURL();

        StringBuffer sb = new StringBuffer(getRequestURL());
        sb.append(getServiceKey());

        boolean isFirst = true;
        Properties pros = getProperties();
        IURLEncoder encodeFunc = getEncodeFunc();
        Enumeration e = pros.keys();

        while (e.hasMoreElements()) {
            String param = (String)e.nextElement();
            Object value = pros.get(param);

            if (value != null) {
                if (isFirst) {
                    isFirst = false;
                    sb.append("?");
                }
                else {
                    sb.append("&");
                }

                sb.append(encodeFunc.encode(param)).append("=").append(value.toString());
            }
        }

        String url = sb.toString();

        //  TODO remove ...
        System.out.println("api url : " + url);

        return url;
    }
}
