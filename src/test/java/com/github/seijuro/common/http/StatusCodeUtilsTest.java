package com.github.seijuro.common.http;

import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class StatusCodeUtilsTest {
    @Test
    public void testGet() {
        StatusCode statusCode = StatusCodeUtils.get(200);
        assertNotNull(statusCode);
        assertEquals(StatusCode.StatusCode200.OK, statusCode);
    }

    @Test
    public void testContains() {
        assertTrue(StatusCodeUtils.contains(100));
        assertTrue(StatusCodeUtils.contains(200));
        assertTrue(StatusCodeUtils.contains(300));
        assertTrue(StatusCodeUtils.contains(400));
        assertTrue(StatusCodeUtils.contains(500));

        assertFalse(StatusCodeUtils.contains(103));
        assertFalse(StatusCodeUtils.contains(209));
        assertFalse(StatusCodeUtils.contains(306));
        assertFalse(StatusCodeUtils.contains(309));

        assertFalse(StatusCodeUtils.contains(418));
        assertFalse(StatusCodeUtils.contains(420));
        assertFalse(StatusCodeUtils.contains(512));
    }

    @Test
    public void testIsOK() {
        assertFalse(StatusCodeUtils.isOK(100));
        assertFalse(StatusCodeUtils.isOK(StatusCodeUtils.get(100)));
        assertFalse(StatusCodeUtils.isOK(105));
        assertFalse(StatusCodeUtils.isOK(StatusCodeUtils.get(105)));

        assertTrue(StatusCodeUtils.isOK(200));
        assertTrue(StatusCodeUtils.isOK(StatusCodeUtils.get(200)));
        assertTrue(StatusCodeUtils.isOK(205));
        assertTrue(StatusCodeUtils.isOK(StatusCodeUtils.get(205)));
        assertFalse(StatusCodeUtils.isOK(220));
        assertFalse(StatusCodeUtils.isOK(StatusCodeUtils.get(220)));
        assertTrue(StatusCodeUtils.isOK(226));
        assertTrue(StatusCodeUtils.isOK(StatusCodeUtils.get(206)));

        assertFalse(StatusCodeUtils.isOK(301));
        assertFalse(StatusCodeUtils.isOK(StatusCodeUtils.get(301)));
        assertFalse(StatusCodeUtils.isOK(401));
        assertFalse(StatusCodeUtils.isOK(StatusCodeUtils.get(401)));
        assertFalse(StatusCodeUtils.isOK(500));
        assertFalse(StatusCodeUtils.isOK(StatusCodeUtils.get(500)));
    }

    @Test
    public void testFormat() {
        StatusCode statusCode = StatusCodeUtils.get(200);
        StringBuffer sb = new StringBuffer();

        String expected = String.format("HTTP StatusCode {name(or reason) : [%s], code : [%d], ref. : [%s]}",
                StatusCode.StatusCode200.OK.getName(),
                StatusCode.StatusCode200.OK.getCode(),
                StatusCode.StatusCode200.OK.getRef());
        StatusCodeUtils.format(statusCode, sb::append);
        assertEquals("", expected, sb.toString());
    }
}
