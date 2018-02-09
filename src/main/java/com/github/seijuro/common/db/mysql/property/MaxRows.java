package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class MaxRows extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MaxRows.class);

    public static final String PropertyName = "maxRows";
    public static final int DefaultValue = -1;

    /**
     * create {@link MaxRows} instance.
     *
     * @param max
     * @return
     */
    public static MaxRows create(Object max) {
        if (max instanceof Integer) {
            Integer value = Integer.class.cast(max);

            if (value > 0 ||
                    value == DefaultValue) {
                return new MaxRows(PropertyName, value);
            }
        }

        //  Log (WARN)
        LOG.warn("Param, max, must be greater than 0 (max : {}, default : {})", max, DefaultValue);

        return null;
    }

    /**
     * C'tor
     *
     * @para $name
     * @param $value
     */
    protected MaxRows(String $name, int $value) {
        super($name, Integer.toString($value));
    }
}