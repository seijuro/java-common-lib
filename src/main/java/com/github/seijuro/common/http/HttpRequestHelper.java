package com.github.seijuro.common.http;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.*;

public class HttpRequestHelper {
    //  Logger
    static Logger LOG = LoggerFactory.getLogger(HttpRequestHelper.class);

    public static List<String> UserAgentPool = new ArrayList<>();
    public static int UserAgentIdx = 0;

    static {
        UserAgentPool.add("Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko");
        UserAgentPool.add("Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko");
    }

    synchronized static String nextUserAgent() {
        int currentIdx = UserAgentIdx;
        UserAgentIdx = (UserAgentIdx + 1) % UserAgentPool.size();

        return UserAgentPool.get(currentIdx);
    }

    /**
     * set request method
     *
     * @param conn
     * @param method
     * @throws ProtocolException
     */
    public static void setRequestMethod(HttpURLConnection conn, RequestMethod method) throws ProtocolException {
        //  check parameters
        assert Objects.nonNull(conn) && Objects.nonNull(method);

        conn.setRequestMethod(method.getMethod());
    }

    /**
     * set 'UserAgent' with one of user-agents already defined.
     *
     * @param conn
     */
    public static void setUserAgent(HttpURLConnection conn) {
        //  check parameters
        assert Objects.nonNull(conn);

        conn.setRequestProperty(RequestProperty.UserAgent.getPropertyName(), nextUserAgent());
    }

    public static void setReferer(HttpURLConnection conn, String refer) {
        //  check parameters
        assert Objects.nonNull(conn);

        conn.setRequestProperty(RequestProperty.Referer.getPropertyName(), refer);
    }

    /**
     * set POST parameter with the given key & value arrays.
     *
     * @param conn
     * @param keys
     * @param values
     * @throws IOException
     * @throws NullPointerException
     */
    public static void setPOSTParam(HttpURLConnection conn, String[] keys, String[] values) throws IOException, NullPointerException {
        assert Objects.nonNull(conn) && Objects.nonNull(keys) && Objects.nonNull(values);
        assert keys.length == values.length;

        boolean isFirst = true;
        StringBuffer sb = new StringBuffer();

        for (int index = 0; index != keys.length; ++index) {
            if (isFirst) {
                isFirst = false;
            }
            else {
                sb.append("&");
            }

            sb.append(keys[index]).append("=").append(values[index]);
        }

        setPOSTParam(conn, sb.toString());
    }

    /**
     * set POST parameter with the given map.
     *
     * @param conn
     * @param params
     * @throws IOException
     * @throws NullPointerException
     */
    public static void setPOSTParam(HttpURLConnection conn, Map<String, String> params) throws IOException, NullPointerException {
        assert Objects.nonNull(conn);

        if (Objects.isNull(params) || params.size() == 0) {
            return;
        }

        boolean isFirst = true;
        StringBuffer sb = new StringBuffer();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (isFirst) {
                isFirst = false;
            }
            else {
                sb.append("&");
            }

            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }

        setPOSTParam(conn, sb.toString());
    }


    /**
     * set POST parameter with the given parameter string.
     *
     * @param conn
     * @param param
     * @throws IOException
     * @throws NullPointerException
     */
    public static void setPOSTParam(HttpURLConnection conn, String param) throws IOException, NullPointerException {
        //  check method parameters #1
        assert Objects.nonNull(conn);
        //  check method parameters #2
        if (StringUtils.isEmpty(param)) {
            return;
        }

        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        dos.writeBytes(param);
        dos.close();
    }
}
