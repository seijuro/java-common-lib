package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CreateDatabaseIfNotExist extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CreateDatabaseIfNotExist.class);

    public static final String PropertyName = "createDatabaseIfNotExist";
    public static final String DefaultValue = Boolean.toString(false);

    /**
     * create {@link CreateDatabaseIfNotExist} instance.
     *
     * @param flag
     * @return
     */
    public static CreateDatabaseIfNotExist create(String flag) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(flag)) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(flag) ||
                    Boolean.FALSE.toString().equalsIgnoreCase(flag)) {
                return new CreateDatabaseIfNotExist(PropertyName, flag);
            }
        }

        String msg = String.format("Param, flag, is not valid (flag : %s, default : %s).", flag, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link CreateDatabaseIfNotExist} instance.
     *
     * @param flag
     * @return
     */
    public static CreateDatabaseIfNotExist create(boolean flag) {
        return new CreateDatabaseIfNotExist(PropertyName, Boolean.toString(flag));
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected CreateDatabaseIfNotExist(String $name, String $value) {
        super($name, $value);
    }
}
