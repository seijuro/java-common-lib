package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class PrepStmtCacheSqlLimit extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(PrepStmtCacheSqlLimit.class);

    public static final String PropertyName = "prepStmtCacheSqlLimit";
    public static final String DefaultValue = Integer.toString(256);

    /**
     * create {@link PrepStmtCacheSqlLimit} instance.
     *
     * @param limit
     * @return
     */
    public static PrepStmtCacheSqlLimit create(String limit) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(limit)) {
            int value = Integer.parseInt(limit);

            if (value > 0) {
                return new PrepStmtCacheSqlLimit(PropertyName, value);
            }
        }

        String msg = String.format("Param, limit, must be greater than 0 (limit : %s, default : %s)", limit, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link PrepStmtCacheSqlLimit} instance.
     *
     * @param limit
     * @return
     */
    public static PrepStmtCacheSqlLimit create(int limit) throws IllegalArgumentException {
        if (limit > 0) {
            return new PrepStmtCacheSqlLimit(PropertyName, limit);
        }

        String msg = String.format("Param, limit, must be greater than 0 (limit : %d, default : %s)", limit, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
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
