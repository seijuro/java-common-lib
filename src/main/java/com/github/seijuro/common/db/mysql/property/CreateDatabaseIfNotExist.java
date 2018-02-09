package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CreateDatabaseIfNotExist extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CreateDatabaseIfNotExist.class);

    public static final String PropertyName = "createDatabaseIfNotExist";
    public static final boolean DefaultValue = false;

    /**
     * create {@link CreateDatabaseIfNotExist} instance.
     *
     * @param flag
     * @return
     */
    public static CreateDatabaseIfNotExist create(Object flag) {
        if (flag instanceof Boolean) {
            return new CreateDatabaseIfNotExist(PropertyName, Boolean.class.cast(flag));
        }

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected CreateDatabaseIfNotExist(String $name, boolean $value) {
        super($name, Boolean.toString($value));
    }
}
