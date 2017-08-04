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
    public void testFormat() {
        StatusCode statusCode = StatusCodeUtils.get(200);
        StringBuffer sb = new StringBuffer();

        String expected = String.format("HTTP StatusCode {name : [%s], code : [%d], ref. : [%s]}",
                StatusCode.StatusCode200.OK.getName(),
                StatusCode.StatusCode200.OK.getCode(),
                StatusCode.StatusCode200.OK.getRef());
        StatusCodeUtils.format(statusCode, sb::append);
        assertEquals("", expected, sb.toString());
    }
}
