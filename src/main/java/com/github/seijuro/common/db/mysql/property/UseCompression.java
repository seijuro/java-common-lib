package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class UseCompression extends MySQLJDBCConfigurationProperty {
    /**
     * Class Properties
     */
    private static final Logger LOG = LoggerFactory.getLogger(UseCompression.class);

    public static final String PropertyName = "useCompression";
    public static final String DefaultValue = Boolean.toString(false);

    /**
     * create {@link UseCompression} instance.
     *
     * @param flag
     * @return
     * @throws IllegalArgumentException
     */
    public static UseCompression create(String flag) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(flag)) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(flag) ||
                    Boolean.FALSE.toString().equalsIgnoreCase(flag)) {
                return new UseCompression(PropertyName, flag);
            }
        }

        String msg = String.format("Param, flag, is not valid (flag : %s, default : %s).", flag, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link UseCompression} instance.
     *
     * @param flag
     * @return
     */
    public static UseCompression create(boolean flag) {
        return new UseCompression(PropertyName, Boolean.toString(flag));
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected UseCompression(String $name, String $value) {
        super($name, $value);
    }
}
