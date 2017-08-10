package com.github.seijuro.common.jdbc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MySQLConnectionStringTest {
    @Test
    public void test1() {
        final String expacted = "jdbc:mysql://127.0.0.1/MyDatabase";
        String result;
        MySQLConnectionString connString = new MySQLConnectionString();

        connString.setHost("127.0.0.1");
        connString.setDatabase("MyDatabase");
        connString.setUser("user");
        connString.setPassword("pwd");

        result = connString.toConnectionString();
        assertEquals(expacted, result);
        assertEquals("user", connString.getUser());
        assertEquals("pwd", connString.getPassword());

        connString.setOther("useUnicode", "true");
        connString.setOther("characterEncoding", "utf8");

        result = connString.toConnectionString();
        assertTrue(expacted.length() < result.length());
        assertEquals(expacted, result.substring(0, expacted.length()));
        assertEquals('?', result.charAt(expacted.length()));
    }
}
