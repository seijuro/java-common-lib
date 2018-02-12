package com.github.seijuro.common.db.mysql.property;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class UseSSL extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UseSSL.class);

    public static final String PropertyName = "useSSL";
    public static final String DefaultValue = Boolean.toString(false);

    /**
     * create {@link UseSSL} instance.
     *
     * @param flag
     * @return
     * @throws IllegalArgumentException
     */
    public static UseSSL create(String flag) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(flag)) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(flag) ||
                    Boolean.FALSE.toString().equalsIgnoreCase(flag)) {
                return new UseSSL(PropertyName, flag);
            }
        }

        String msg = String.format("Param, flag, is not valid (flag : %s, default : %s).", flag, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link UseSSL} instance.
     *
     * @param flag
     * @return
     */
    public static UseSSL create(boolean flag) {
        return new UseSSL(PropertyName, Boolean.toString(flag));
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected UseSSL(String $name, String $value) {
        super($name, $value);
    }
}
