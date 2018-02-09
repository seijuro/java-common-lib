package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class MaxRows implements JDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MaxRows.class);

    public static final String PropertyName = "maxRows";
    public static final int DefaultValue = -1;

    /**
     * create {@link MaxRows} instance.
     *
     * @param max
     * @return
     */
    public static MaxRows create(int max) {
        if (max > 0 ||
                max == DefaultValue) {
            return new MaxRows(max);
        }

        //  Log (WARN)
        LOG.warn("Param, max, must be greater than 0 (max : {}, default : {})", max, DefaultValue);

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
    protected MaxRows(int $value) {
        this.propertyValue = Integer.toString($value);
    }
}