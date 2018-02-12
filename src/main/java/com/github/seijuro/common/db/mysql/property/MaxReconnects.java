package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class MaxReconnects extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MaxReconnects.class);

    public static final String PropertyName = "maxReconnects";
    public static final String DefaultValue = Integer.toString(3);

    /**
     * create {@link MaxReconnects} instance.
     *
     * @param max
     * @return
     */
    public static MaxReconnects create(String max) throws IllegalArgumentException {
        try {
            if (StringUtils.isNotEmpty(max)) {
                int value = Integer.parseInt(max);

                if (value >= 0) {
                    return new MaxReconnects(PropertyName, max);
                }
            }
        }
        catch (NumberFormatException nfexcp) {
            nfexcp.printStackTrace();
        }

        String msg = String.format("Param, max, must be greater than or equal to 0 (max : %s, default : %s)", max, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link MaxReconnects} instance.
     *
     * @param max
     * @return
     */
    public static MaxReconnects create(int max) throws IllegalArgumentException {
        if (max >= 0) {
            return new MaxReconnects(PropertyName, Integer.toString(max));
        }

        String msg = String.format("Param, max, must be greater than or equal to 0 (max : %d, default : %s)", max, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }


    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected MaxReconnects(String $name, String $value) {
        super($name, $value);
    }
}