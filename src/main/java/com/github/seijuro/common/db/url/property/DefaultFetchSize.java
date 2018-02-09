package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class DefaultFetchSize implements JDBCConfigurationProperty {
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
    public static DefaultFetchSize create(int size) {
        if (size > 0) {
            return new DefaultFetchSize(size);
        }

        //  Log (WARN)
        LOG.warn("Param, size, must be greater than 0 (size : {}, default : {})", size, DefaultValue);

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
     * @param size
     */
    protected DefaultFetchSize(int size) {
        this.propertyValue = Integer.toString(size);
    }
}
