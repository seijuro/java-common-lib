package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class DefaultFetchSize extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DefaultFetchSize.class);

    public static final String PropertyName = "prepStmtCacheSqlLimit";
    public static final int DefaultValue = 256;

    /**
     * create {@link DefaultFetchSize} instance.
     *
     * @param size
     * @return
     */
    public static DefaultFetchSize create(Object size) {
        if (size instanceof Integer) {
            Integer casted = Integer.class.cast(size);

            if (casted > 0) {
                return new DefaultFetchSize(PropertyName, casted);
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
    protected DefaultFetchSize(String $name, int size) {
        super($name, Integer.toString(size));
    }
}
