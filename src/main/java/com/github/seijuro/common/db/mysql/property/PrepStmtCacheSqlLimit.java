package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Int;

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
    public static PrepStmtCacheSqlLimit create(Object limit) {
        if (limit instanceof Integer) {
            Integer value = Integer.class.cast(limit);

            if (value > 0) {
                return new PrepStmtCacheSqlLimit(value);
            }
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
