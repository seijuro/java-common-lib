package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class ConnectTimeout implements JDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ConnectTimeout.class);

    public static final String PropertyName = "connectTimeout";
    public static final long DefaultValue = 0L;

    /**
     * create {@link ConnectTimeout} instance.
     *
     * @param millis
     * @return
     */
    public static ConnectTimeout create(long millis) {
        if (millis >= 0L) {
            return new ConnectTimeout(millis);
        }

        //  Log (WARN)
        LOG.warn("Param, millis, must be greater than or equal to 0 (size : {}, default : {})", millis, DefaultValue);

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
     * @param millis
     */
    protected ConnectTimeout(long millis) {
        this.propertyValue = Long.toString(millis);
    }
}
