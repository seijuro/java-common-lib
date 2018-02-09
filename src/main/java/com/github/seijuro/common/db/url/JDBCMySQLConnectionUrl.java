package com.github.seijuro.common.db.url;

import com.github.seijuro.common.db.url.property.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Properties;

@ToString
public class JDBCMySQLConnectionUrl implements JDBCConnectionUrl {
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
    public void setConfigurationProperty(JDBCConfigurationProperty option) {
        if (Objects.nonNull(option)) {
            this.configurationProperties.setProperty(option.getPropertyName(), option.getPropertyValue());
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
    public JDBCMySQLConnectionUrl(String host, String db, String user, String pass) {
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
                        String mapped = new StringBuffer()
                                .append(entry.getKey())
                                .append("=")
                                .append(entry.getValue())
                                .toString();

                        return mapped;
                    })
                    .reduce(StringUtils.EMPTY, (lhs, rhs) -> {
                        if (!StringUtils.isEmpty(lhs)) {
                            String reduced = new StringBuffer()
                                    .append(lhs)
                                    .append("&")
                                    .append(rhs)
                                    .toString();
                            return reduced;
                        }

                        return rhs;
                    });

            if (othersString.length() > 0) {    sb.append("?").append(othersString);    }
        }

        return sb.toString();
    }
}
