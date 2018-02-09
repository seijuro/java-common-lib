package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import com.github.seijuro.common.db.JDBCConnectionUrl;
import lombok.Getter;

public abstract class MySQLJDBCConfigurationProperty implements JDBCConfigurationProperty, JDBCConnectionUrl {
    /**
     * Class Properties
     */
    private static final String AssignmentOpr = "=";

    /**
     * Instance Properties
     */
    @Getter
    private final String propertyName;
    @Getter
    private final String propertyValue;

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected MySQLJDBCConfigurationProperty(String $name, String $value) {
        this.propertyName = $name;
        this.propertyValue = $value;
    }

    @Override
    public String toConnectionUrl() {
        return String.format("%s%s%s", this.propertyName, AssignmentOpr, this.propertyValue);
    }
}
