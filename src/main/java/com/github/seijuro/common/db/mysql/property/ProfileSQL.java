package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class ProfileSQL extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ProfileSQL.class);

    public static final String PropertyName = "profileSQL";
    public static final String DefaultValue = Boolean.toString(false);

    /**
     * create {@link ProfileSQL} instance.
     *
     * @param flag
     * @return
     * @throws IllegalArgumentException
     */
    public static ProfileSQL create(String flag) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(flag)) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(flag) ||
                    Boolean.FALSE.toString().equalsIgnoreCase(flag)) {
                return new ProfileSQL(PropertyName, flag);
            }
        }

        String msg = String.format("Param, flag, is not valid (flag : %s, default : %s).", flag, DefaultValue);

        //  LOG
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link ProfileSQL} instance.
     *
     * @param flag
     * @return
     * @throws IllegalArgumentException
     */
    public static ProfileSQL create(boolean flag) {
        return new ProfileSQL(PropertyName, Boolean.toString(flag));
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected ProfileSQL(String $name, String $value) {
        super($name, $value);
    }
}
