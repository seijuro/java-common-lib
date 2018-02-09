package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class AutoReconnect extends MySQLJDBCConfigurationProperty {
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
    public static AutoReconnect create(Object flag) {
        if (flag instanceof Boolean) {
            return new AutoReconnect(PropertyName, Boolean.class.cast(flag));
        }

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected AutoReconnect(String $name, boolean $value) {
        super($name, Boolean.toString($value));
    }
}
