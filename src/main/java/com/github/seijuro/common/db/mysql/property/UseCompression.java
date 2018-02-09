package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class UseCompression implements JDBCConfigurationProperty {
    /**
     * Class Properties
     */
    private static final Logger LOG = LoggerFactory.getLogger(UseCompression.class);

    public static final String PropertyName = "useCompression";
    public static final boolean DefaultValue = false;

    /**
     * create {@link UseCompression} instance.
     *
     * @param flag
     * @return
     */
    public static UseCompression create(boolean flag) {
        return new UseCompression(flag);
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
    protected UseCompression(boolean $value) {
        this.propertyValue = Boolean.toString($value);
    }
}
