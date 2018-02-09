package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CreateDatabaseIfNotExist implements JDBCConfigurationProperty {
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
    public static CreateDatabaseIfNotExist create(boolean flag) {
        return new CreateDatabaseIfNotExist(flag);
    }

    /**
     * Instance Properties
     */
    @Getter
    private final String propertyValue;

    public java.lang.String getPropertyName() {
        return PropertyName;
    }

    /**
     * C'tor
     *
     * @param $value
     */
    protected CreateDatabaseIfNotExist(boolean $value) {
        this.propertyValue = Boolean.toString($value);
    }
}
