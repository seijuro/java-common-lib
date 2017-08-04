package com.github.seijuro.common.scrap.publicdata.services.recall;

import com.github.seijuro.common.IURLEncoder;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPI;
import com.github.seijuro.common.scrap.publicdata.PublicDataAPIConfig;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;

public class RecallAPI extends PublicDataAPI {
    public static final String SERVICE_URL = "http://www.ibtk.kr/recall_api/";

    public static String getServiceURL() {
        return SERVICE_URL;
    }

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
