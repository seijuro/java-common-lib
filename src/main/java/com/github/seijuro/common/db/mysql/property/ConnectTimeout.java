package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class ConnectTimeout extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ConnectTimeout.class);

    public static final String PropertyName = "connectTimeout";
    public static final String DefaultValue = Long.toString(0L);

    /**
     * create {@link ConnectTimeout} instance.
     *
     * @param millis
     * @return
     */
    public static ConnectTimeout create(String millis) {
        try {
            if (StringUtils.isNotEmpty(millis)) {
                long value = Long.valueOf(millis);

                if (value >= 0L) {
                    return new ConnectTimeout(PropertyName, millis);
                }
            }
        }
        catch (NumberFormatException nfexcp) {
            nfexcp.printStackTrace();
        }

        String msg = String.format("Param, millis, must be greater than or equal to 0 (millis : %s, default : %s)", millis, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link ConnectTimeout} instance.
     *
     * @param millis
     * @return
     */
    public static ConnectTimeout create(long millis) throws IllegalArgumentException {
        if (millis >= 0L) {
            return new ConnectTimeout(PropertyName, Long.toString(millis));
        }

        String msg = String.format("Param, millis, must be greater than or equal to 0 (millis : %d, default : %s)", millis, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * C'tor
     *
     * @param $name
     * @param millis
     */
    protected ConnectTimeout(String $name, String millis) {
        super($name, millis);
    }
}
