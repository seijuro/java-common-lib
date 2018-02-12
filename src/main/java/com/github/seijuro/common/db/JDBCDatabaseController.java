package com.github.seijuro.common.db;

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

    protected Connection connection;

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

    /**
     * connect to database
     *
     * @throws SQLException
     */
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(this.connectionUrl, this.user, this.password);
    }

    /**
     * close connection.
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        if (Objects.nonNull(this.connection) &&
                this.connection.isClosed()) {
            this.connection.close();
        }

        this.connection = null;
    }

    /**
     * set auto-commit enabled.
     *
     * @param flag
     * @throws SQLException
     */
    public void setAutoCommit(boolean flag) throws SQLException {
        if (Objects.nonNull(this.connection) &&
                !this.connection.isClosed()) {
            this.connection.setAutoCommit(flag);
        }
    }

    /**
     * commit
     *
     * @throws SQLException
     */
    public void commit() throws SQLException {
        if (Objects.nonNull(this.connection) &&
                !this.connection.isClosed() &&
                !this.connection.getAutoCommit()) {
            this.connection.commit();
        }
    }

    /**
     * roll-back
     *
     * @throws SQLException
     */
    public void rollback() throws SQLException {
        if (Objects.nonNull(this.connection) &&
                !this.connection.isClosed() &&
                !this.connection.getAutoCommit()) {
            this.connection.rollback();
        }
    }
}
