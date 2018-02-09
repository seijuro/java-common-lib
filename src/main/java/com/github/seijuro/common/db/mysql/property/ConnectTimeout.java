package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class ConnectTimeout extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ConnectTimeout.class);

    public static final String PropertyName = "connectTimeout";
    public static final long DefaultValue = 0L;

    /**
     * create {@link ConnectTimeout} instance.
     *
     * @param millis
     * @return
     */
    public static ConnectTimeout create(Object millis) {
        if (millis instanceof Long) {
            Long value = Long.class.cast(millis);

            if (value >= 0L) {
                return new ConnectTimeout(PropertyName, value);
            }
        }

        //  Log (WARN)
        LOG.warn("Param, millis, must be greater than or equal to 0 (size : {}, default : {})", millis, DefaultValue);

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param millis
     */
    protected ConnectTimeout(String $name, long millis) {
        super($name, Long.toString(millis));
    }
}
