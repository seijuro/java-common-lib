package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class MaxReconnects extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MaxReconnects.class);

    public static final String PropertyName = "maxReconnects";
    public static final int DefaultValue = 3;

    /**
     * create {@link MaxReconnects} instance.
     *
     * @param max
     * @return
     */
    public static MaxReconnects create(Object max) {
        if (max instanceof Integer) {
            Integer value = Integer.class.cast(max);

            if (value >= 0) {
                return new MaxReconnects(PropertyName, value);
            }
        }

        //  Log (WARN)
        LOG.warn("Param, max, must be greater than or equal to 0 (max : {}, default : {})", max, DefaultValue);

        return null;
    }


    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected MaxReconnects(String $name, int $value) {
        super($name, Integer.toString($value));
    }
}