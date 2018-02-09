package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class AutoReconnect implements JDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(AutoReconnect.class);

    public static final String PropertyName = "autoReconnect";
    public static final boolean DefaultValue = false;

    /**
     * create {@link AutoReconnect} instance.
     *
     * @param flag
     * @return
     */
    public static AutoReconnect create(boolean flag) {
        return new AutoReconnect(flag);
    }

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
    protected AutoReconnect(boolean $value) {
        propertyValue = Boolean.toString($value);
    }
}
