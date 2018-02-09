package com.github.seijuro.common.db.url.property;

/**
 * @see <a href="http://dev.mysql.com/doc/connector-j/5.1/en/connector-j-reference-configuration-properties.html/>
 */
public interface JDBCConfigurationProperty {
    public abstract String getPropertyName();
    public abstract String getPropertyValue();
}
