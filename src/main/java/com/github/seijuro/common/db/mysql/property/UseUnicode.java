package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class UseUnicode extends MySQLJDBCConfigurationProperty {
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
    public static UseUnicode create(Object flag) {
        if (flag instanceof Boolean) {
            return new UseUnicode(PropertyName, Boolean.class.cast(flag));
        }

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected UseUnicode(String $name, boolean $value) {
        super($name, Boolean.toString($value));
    }
}
