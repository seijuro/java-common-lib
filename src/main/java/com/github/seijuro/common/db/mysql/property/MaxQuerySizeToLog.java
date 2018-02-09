package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class MaxQuerySizeToLog extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MaxQuerySizeToLog.class);

    public static final String PropertyName = "maxQuerySizeToLog";
    public static final int DefaultValue = 2048;

    /**
     * create {@link MaxQuerySizeToLog} instance.
     *
     * @param size
     * @return
     */
    public static MaxQuerySizeToLog create(Object size) {
        if (size instanceof Integer) {
            Integer value = Integer.class.cast(size);

            if (value > 0) {
                return new MaxQuerySizeToLog(PropertyName, value);
            }
        }

        //  Log (WARN)
        LOG.warn("Param, size, must be greater than 0 (size : {}, default : {})", size, DefaultValue);

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param size
     */
    protected MaxQuerySizeToLog(String $name, int size) {
        super($name, Integer.toString(size));
    }
}
