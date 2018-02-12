package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class MaxRows extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MaxRows.class);

    public static final String PropertyName = "maxRows";
    public static final String DefaultValue = Integer.toString(-1);

    /**
     * create {@link MaxRows} instance.
     *
     * @param max
     * @return
     */
    public static MaxRows create(String max) throws IllegalArgumentException {
        try {
            if (StringUtils.isNotEmpty(max)) {
                int value = Integer.parseInt(max);

                if (value > 0 || value == Integer.valueOf(DefaultValue)) {
                    return new MaxRows(PropertyName, max);
                }
            }
        }
        catch (NumberFormatException nfexcp) {
            nfexcp.printStackTrace();
        }

        String msg = String.format("Param, max, must be greater than 0 (max : %s, default : %s)", max, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link MaxRows} instance.
     *
     * @param max
     * @return
     */
    public static MaxRows create(int max) throws IllegalArgumentException {
        if (max > 0 || max == Integer.valueOf(DefaultValue)) {
            return new MaxRows(PropertyName, Integer.toString(max));
        }

        String msg = String.format("Param, max, must be greater than 0 (max : %d, default : %s)", max, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * C'tor
     *
     * @para $name
     * @param $value
     */
    protected MaxRows(String $name, String $value) {
        super($name, $value);
    }
}