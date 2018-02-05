package com.github.seijuro.common.jdbc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@ToString
public class MySQLConnectionString implements JDBCConnectionString {
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
    private Map<String, String> others = new HashMap<>();

    public String setOther(String key, String value) {
        return others.put(key, value);
    }

    /**
     * Construct
     *
     * @param host
     * @param db
     * @param user
     * @param pass
     */
    public MySQLConnectionString(String host, String db, String user, String pass) {
        this.host = host;
        this.database = db;
        this.user = user;
        this.password = pass;
    }

    @Override
    public String toConnectionString() {
        StringBuffer sb = new StringBuffer(PREFIX);
        sb.append(host).append("/").append(database);

        if (others.size() > 0) {
            String othersString = others.entrySet()
                    .stream()
                    .map(entry -> {
                        StringBuffer tmp = new StringBuffer(entry.getKey());
                        tmp.append("=").append(entry.getValue());
                        return tmp.toString();
                    })
                    .reduce(StringUtils.EMPTY, (a, b) -> {
                        if (!StringUtils.isEmpty(a)) {
                            StringBuffer tmp = new StringBuffer(a);
                            tmp.append("&").append(b);
                            return tmp.toString();
                        }
                        return b;
                    });

            sb.append("?").append(othersString);
        }

        return sb.toString();
    }
}
