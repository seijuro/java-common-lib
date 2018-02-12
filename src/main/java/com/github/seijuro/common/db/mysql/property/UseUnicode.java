package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class UseUnicode extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UseUnicode.class);

    public static final String PropertyName = "useUnicode";
    public static final String DefaultValue = Boolean.toString(true);

    /**
     * create {@link UseUnicode} instance.
     *
     * @param flag
     * @return
     */
    public static UseUnicode create(String flag) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(flag)) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(flag) ||
                    Boolean.FALSE.toString().equalsIgnoreCase(flag)) {
                return new UseUnicode(PropertyName, flag);
            }
        }

        String msg = String.format("Param, flag, is not valid (flag : %s, default : %s).", flag, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link UseUnicode} instance.
     *
     * @param flag
     * @return
     */
    public static UseUnicode create(boolean flag) {
        return new UseUnicode(PropertyName, Boolean.toString(flag));
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected UseUnicode(String $name, String $value) {
        super($name, $value);
    }
}
