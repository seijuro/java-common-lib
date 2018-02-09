package com.github.seijuro.common.db.ctrl;

import com.github.seijuro.common.db.url.JDBCConnectionUrl;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public abstract class JDBCDatabaseController {
    /**
     * Class Properties
     */
    private static final String DriverClassName = "com.mysql.jdbc.Driver";

    public static boolean loadDriver() {
        try {
            Class.forName(DriverClassName);

            return true;
        }
        catch (ClassNotFoundException cnfexcp) {
            cnfexcp.printStackTrace();
        }

        return false;
    }

    static {
        loadDriver();
    }

    /**
     * Instance Properties
     */
    private final String connectionUrl;
    private final String user;
    private final String password;

    private Connection connection;

    /**
     * C'tor
     *
     * @param $url
     */
    protected JDBCDatabaseController(JDBCConnectionUrl $url, String $user, String $password) {
        this.connectionUrl = $url.toConnectionUrl();
        this.user = $user;
        this.password = $password;
    }

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(this.connectionUrl, this.user, this.password);
    }

    public void close() throws SQLException {
        if (Objects.nonNull(this.connection) &&
                this.connection.isClosed()) {
            this.connection.close();
        }

        this.connection = null;
    }
}
