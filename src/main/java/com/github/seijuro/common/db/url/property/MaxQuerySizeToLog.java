package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class MaxQuerySizeToLog implements JDBCConfigurationProperty {
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
    public static MaxQuerySizeToLog create(int size) {
        if (size > 0) {
            return new MaxQuerySizeToLog(size);
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
    protected MaxQuerySizeToLog(int size) {
        this.propertyValue = Integer.toString(size);
    }
}
