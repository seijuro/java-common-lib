package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class MaxReconnects implements JDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MaxReconnects.class);

    public static final String PropertyName = "maxReconnects";
    public static final int DefaultValue = 3;

    /**
     * create {@link MaxReconnects} instance.
     *
     * @param max
     * @return
     */
    public static MaxReconnects create(int max) {
        if (max >= 0) {
            return new MaxReconnects(max);
        }

        //  Log (WARN)
        LOG.warn("Param, max, must be greater than or equal to 0 (max : {}, default : {})", max, DefaultValue);

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
     * @param $value
     */
    protected MaxReconnects(int $value) {
        this.propertyValue = Integer.toString($value);
    }
}