package com.github.seijuro.common.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by seijuro
 */
public class DBConnectionPool {
    /**
     * Singleton Instance
     */
    static DBConnectionPool instance;

    synchronized public static DBConnectionPool getInstance() {
        if (instance == null) {
            instance = new DBConnectionPool();
        }

        return instance;
    }

    public static class Constants {
        public static final int DEFAULT_MIN_IDLE = 5;
        public static final int DEFAULT_MAX_IDLE = 10;
        public static final int DEFAULT_MAX_PREPARED_STMT = 20;
    }

    /**
     * key class for HashMap
     */
    private static class HashKey {
        private final String url;
        private final String user;

        public HashKey(String url, String user, String pass) {
            this.url = url;
            this.user = user;
        }

        @Override
        public int hashCode() {
            return ((url.hashCode() * 17) * 31 + user.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof HashKey) {
                return this.hashCode() == obj.hashCode();
            }

            return false;
        }
    }

    /**
     * Instance Property
     */
    private final Map<HashKey, BasicDataSource> dataSourceMap;

    /**
     * C"tor
     */
    protected DBConnectionPool() {
        this.dataSourceMap = new HashMap<>();;
    }

    synchronized public BasicDataSource getBasicDataSource(String url, String user, String pass) {
        HashKey hkey = new HashKey(url, user, pass);

        if (dataSourceMap.containsKey(hkey)) {
            return dataSourceMap.get(hkey);
        }

        BasicDataSource bds = createDataSource(url, user, pass);
        dataSourceMap.put(hkey, bds);

        return bds;
    }

    /**
     * create connection
     *
     * @param url
     * @param user
     * @param pass
     * @return
     * @throws SQLException
     */
    public Connection createConnection(String url, String user, String pass) throws SQLException {
        BasicDataSource bds = getBasicDataSource(url, user, pass);

        return bds.getConnection();
    }

    protected BasicDataSource createDataSource(String url, String user, String pass) {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl(url);
        bds.setUsername(user);
        bds.setPassword(pass);

        bds.setMinIdle(Constants.DEFAULT_MIN_IDLE);
        bds.setMaxIdle(Constants.DEFAULT_MAX_IDLE);
        bds.setMaxOpenPreparedStatements(Constants.DEFAULT_MAX_PREPARED_STMT);

        return bds;
    }

    synchronized public void close() {
        for (BasicDataSource bds : dataSourceMap.values()) {
            try {
                bds.close();
            }
            catch (SQLException excp) {
                excp.printStackTrace();
            }
        }

        dataSourceMap.clear();
    }
}
