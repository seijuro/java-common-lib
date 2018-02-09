package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class PrepStmtCacheSqlLimit extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(PrepStmtCacheSqlLimit.class);

    public static final String PropertyName = "prepStmtCacheSqlLimit";
    public static final int DefaultValue = 256;

    /**
     * create {@link PrepStmtCacheSqlLimit} instance.
     *
     * @param limit
     * @return
     */
    public static PrepStmtCacheSqlLimit create(Object limit) {
        if (limit instanceof Integer) {
            Integer value = Integer.class.cast(limit);

            if (value > 0) {
                return new PrepStmtCacheSqlLimit(PropertyName, value);
            }
        }

        //  Log (WARN)
        LOG.warn("Param, limit, must be greater than 0 (limit : {}, default : {})", limit, DefaultValue);

        return null;
    }

    /**
     * C'tor
     *
     * @param limit
     */
    protected PrepStmtCacheSqlLimit(String $name, int limit) {
        super($name, Integer.toString(limit));
    }
}
