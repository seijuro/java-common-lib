package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class SocketTimeout implements JDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SocketTimeout.class);

    public static final String PropertyName = "socketTimeout";
    public static final long DefaultValue = 0L;

    /**
     * create {@link SocketTimeout} instance.
     *
     * @param millis
     * @return
     */
    public static SocketTimeout create(long millis) {
        if (millis >= 0L) {
            return new SocketTimeout(millis);
        }

        //  Log (WARN)
        LOG.warn("Param, millis, must be greater than or equal to 0 (millis : {}, default : {})", millis, DefaultValue);

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
    protected SocketTimeout(long millis) {
        this.propertyValue = Long.toString(millis);
    }
}
