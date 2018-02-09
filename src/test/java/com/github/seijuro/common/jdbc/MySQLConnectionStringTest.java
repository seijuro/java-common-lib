package com.github.seijuro.common.jdbc;

import com.github.seijuro.common.db.url.JDBCMySQLConnectionUrl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MySQLConnectionStringTest {
    @Test
    public void test1() {
        final String expacted = "jdbc:mysql://127.0.0.1/MyDatabase";
        String result;
        JDBCMySQLConnectionUrl connString = new JDBCMySQLConnectionUrl("127.0.0.1", "MyDatabase", "user", "pwd");

        result = connString.toConnectionUrl();
        assertEquals(expacted, result);
        assertEquals("user", connString.getUser());
        assertEquals("pwd", connString.getPassword());

        result = connString.toConnectionUrl();
        assertTrue(expacted.length() < result.length());
        assertEquals(expacted, result.substring(0, expacted.length()));
        assertEquals('?', result.charAt(expacted.length()));
    }
}
