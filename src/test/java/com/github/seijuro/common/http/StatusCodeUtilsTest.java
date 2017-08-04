package com.github.seijuro.common.http;

import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class StatusCodeUtilsTest {
    /*
        public static StatusCode get(int code);
        public static boolean contains(int code);
        public static String getRFC(int code);
        public static boolean isOK(int code);
        public static boolean isOK(StatusCode code);
        public static void format(StatusCode code, Consumer<String> consumer);

     */

    /*
        OK(200, "RFC7231, Section 6.3.1"),
        CREATED(201, "RFC7231, Section 6.3.2"),
        ACCEPTED(202, "RFC7231, Section 6.3.3"),
        NON_AUTHORITATIVE_INFORMATION(203, "RFC7231, Section 6.3.4"),
        NO_CONTENT(204, "RFC7231, Section 6.3.5"),
        RESET_CONTENT(205, "RFC7231, Section 6.3.6"),
        PARTIAL_CONTENT(206, "RFC7233, Section 4.1"),
        MULTI_STATUS(207, "RFC4918"),
        ALREADY_REPORTED(208, "RFC5842"),
        IM_USED(226, "RFC3229");
     */
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
