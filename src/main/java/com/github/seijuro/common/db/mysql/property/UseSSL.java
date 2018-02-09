package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class UseSSL extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UseSSL.class);

    public static final String PropertyName = "useSSL";
    public static final boolean DefaultValue = false;

    /**
     * create {@link UseSSL} instance.
     *
     * @param flag
     * @return
     */
    public static UseSSL create(Object flag) {
        if (flag instanceof Boolean) {
            return new UseSSL(PropertyName, Boolean.class.cast(flag));
        }

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected UseSSL(String $name, boolean $value) {
        super($name, Boolean.toString($value));
    }
}
