package com.github.seijuro.common.scrap.publicdata.recall;

import com.github.seijuro.common.scrap.publicdata.PublicDataAPI;
import com.github.seijuro.common.scrap.publicdata.PublicDataConfig;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

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
    public RecallAPI(PublicDataConfig config, String serviceKey) {
        super(getServiceURL(), config, serviceKey);
    }

    @Override
    protected String createRequestGETURL() throws UnsupportedEncodingException {
        //  don't call <code>super.createRequestGETURL</code> method.
        //  super.createRequestGETURL();

        StringBuffer sb = new StringBuffer(this.requestURL);
        sb.append(getServiceKey());

        boolean isFirst = true;
        Enumeration e = this.properties.keys();

        while (e.hasMoreElements()) {
            String param = (String)e.nextElement();
            Object value = this.properties.get(param);

            if (value != null) {
                if (isFirst) {
                    isFirst = false;
                    sb.append("?");
                }
                else {
                    sb.append("&");
                }

                sb.append(this.encodeFunc.encode(param)).append("=").append(value.toString());
            }
        }

        String url = sb.toString();

        //  TODO remove ...
        System.out.println("api url : " + url);

        return url;
    }
}
