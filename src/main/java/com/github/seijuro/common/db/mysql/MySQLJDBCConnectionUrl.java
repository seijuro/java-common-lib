package com.github.seijuro.common.db.mysql;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import com.github.seijuro.common.db.JDBCConnectionUrl;
import com.github.seijuro.common.db.mysql.property.MySQLJDBCConfigurationProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Properties;

@ToString
public class MySQLJDBCConnectionUrl implements JDBCConnectionUrl {
    public static final String PREFIX = "jdbc:mysql://";

    /**
     * Instance Properties
     */
    @Setter
    private String host;
    @Setter
    private String database;
    @Getter @Setter
    private String user;
    @Getter @Setter
    private String password;
    private Properties configurationProperties = new Properties();

    /**
     *
     * @param option
     */
    @SuppressWarnings("unused")
    public void setConfigurationProperty(MySQLJDBCConfigurationProperty option) {
        if (Objects.nonNull(option)) {
            this.configurationProperties.put(option.getPropertyName(), option);
        }
    }

    /**
     * Construct
     *
     * @param host
     * @param db
     * @param user
     * @param pass
     */
    public MySQLJDBCConnectionUrl(String host, String db, String user, String pass) {
        this.host = host;
        this.database = db;
        this.user = user;
        this.password = pass;
    }

    @Override
    public String toConnectionUrl() {
        StringBuffer sb = new StringBuffer(PREFIX);
        sb.append(host).append("/").append(database);

        if (configurationProperties.size() > 0) {
            String othersString = configurationProperties.entrySet()
                    .stream()
                    .map(entry -> {
                        if (entry.getValue() instanceof MySQLJDBCConfigurationProperty) {
                            MySQLJDBCConfigurationProperty property = MySQLJDBCConfigurationProperty.class.cast(entry.getValue());
                            return property.toConnectionUrl();
                        }

                        return StringUtils.EMPTY;
                    })
                    .reduce(StringUtils.EMPTY, (lhs, rhs) -> {
                        if (StringUtils.isNotEmpty(lhs) &&
                                StringUtils.isNotEmpty(rhs)) {
                            String reduced = new StringBuffer()
                                    .append(lhs)
                                    .append("&")
                                    .append(rhs)
                                    .toString();
                            return reduced;
                        }

                        return StringUtils.isNotEmpty(rhs) ? rhs : lhs;
                    });

            if (othersString.length() > 0) {    sb.append("?").append(othersString);    }
        }

        return sb.toString();
    }
}
