package com.github.seijuro.common.scrap.publicdata.result;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecallAPIResultTest {
    @Test
    public void testRecallAPIResult() {
        final String resultCode = "result code";
        final String resultMessage = "result message";
        final int pageNo = 10;
        final int numberOfRows = 100;
        final int totalCount = 2000;

        RecallAPIResult result = new RecallAPIResult(resultCode, resultMessage, pageNo, numberOfRows, totalCount);

        assertNotNull(result);

        assertEquals(resultCode, result.getResultCode());
        assertEquals(resultMessage, result.getResultMessage());
        assertEquals(pageNo, result.getPageNo());
        assertEquals(numberOfRows, result.getNumberOfRows());
        assertEquals(totalCount, result.getTotalCount());
    }
}
