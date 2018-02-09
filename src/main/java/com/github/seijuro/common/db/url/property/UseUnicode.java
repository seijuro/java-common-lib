package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class UseUnicode implements JDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UseUnicode.class);

    public static final String PropertyName = "useUnicode";
    public static final boolean DefaultValue = true;

    /**
     * create {@link UseUnicode} instance.
     *
     * @param flag
     * @return
     */
    public static UseUnicode create(boolean flag) {
        return new UseUnicode(flag);
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
    protected UseUnicode(boolean $value) {
        this.propertyValue = Boolean.toString($value);
    }
}
