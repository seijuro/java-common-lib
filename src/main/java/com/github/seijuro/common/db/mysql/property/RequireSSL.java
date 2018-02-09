package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class RequireSSL extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(RequireSSL.class);

    public static final String PropertyName = "requireSSL";
    public static final boolean DefaultValue = false;

    /**
     * create {@link RequireSSL} instance.
     *
     * @param flag
     * @return
     */
    public static RequireSSL create(Object flag) {
        if (flag instanceof Boolean) {
            return new RequireSSL(PropertyName, Boolean.class.cast(flag));
        }

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected RequireSSL(String $name, boolean $value) {
        super($name, Boolean.toString($value));
    }
}
