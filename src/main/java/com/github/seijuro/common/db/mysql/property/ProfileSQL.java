package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class ProfileSQL implements JDBCConfigurationProperty {
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
            return new ProfileSQL(Boolean.class.cast(flag));
        }

        return null;
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
    protected ProfileSQL(boolean $value) {
        this.propertyValue = Boolean.toString($value);
    }
}
