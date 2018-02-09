package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class UseCompression extends MySQLJDBCConfigurationProperty {
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
    public static UseCompression create(Object flag) {
        if (flag instanceof Boolean) {
            Boolean value = Boolean.class.cast(flag);

            return new UseCompression(PropertyName, value);
        }

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected UseCompression(String $name, boolean $value) {
        super($name, Boolean.toString($value));
    }
}
