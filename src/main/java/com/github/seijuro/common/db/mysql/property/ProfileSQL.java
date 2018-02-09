package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class ProfileSQL extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ProfileSQL.class);

    public static final String PropertyName = "profileSQL";
    public static final boolean DefaultValue = false;

    /**
     * create {@link ProfileSQL} instance.
     *
     * @param flag
     * @return
     */
    public static ProfileSQL create(Object flag) {
        if (flag instanceof Boolean) {
            return new ProfileSQL(PropertyName, Boolean.class.cast(flag));
        }

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected ProfileSQL(String $name, boolean $value) {
        super($name, Boolean.toString($value));
    }
}
