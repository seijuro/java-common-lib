package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class PrepStmtCacheSqlLimit implements JDBCConfigurationProperty {
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
    public static PrepStmtCacheSqlLimit create(int limit) {
        if (limit > 0) {
            return new PrepStmtCacheSqlLimit(limit);
        }

        //  Log (WARN)
        LOG.warn("Param, limit, must be greater than 0 (limit : {}, default : {})", limit, DefaultValue);

        return null;
    }

    /**
     * Instance Properties
     */
    @Getter
    private final String propertyValue;

    public java.lang.String getPropertyName() {
        return PropertyName;
    }

    /**
     * C'tor
     *
     * @param limit
     */
    protected PrepStmtCacheSqlLimit(int limit) {
        this.propertyValue = Integer.toString(limit);
    }
}
