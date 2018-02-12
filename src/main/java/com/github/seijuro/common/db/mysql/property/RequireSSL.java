package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class RequireSSL extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(RequireSSL.class);

    public static final String PropertyName = "requireSSL";
    public static final String DefaultValue = Boolean.toString(false);

    /**
     * create {@link RequireSSL} instance.
     *
     * @param flag
     * @return
     * @throws IllegalArgumentException
     */
    public static RequireSSL create(String flag) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(flag)) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(flag) ||
                    Boolean.FALSE.toString().equalsIgnoreCase(flag)) {
                return new RequireSSL(PropertyName, flag);
            }
        }

        String msg = String.format("Param, flag, is not valid (flag : %s, default : %s).", flag, DefaultValue);

        //  LOG
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link RequireSSL} instance.
     *
     * @param flag
     * @return
     */
    public static RequireSSL create(boolean flag) {
        return new RequireSSL(PropertyName, Boolean.toString(flag));
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected RequireSSL(String $name, String $value) {
        super($name, $value);
    }
}
