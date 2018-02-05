package com.github.seijuro.common.http;

import org.junit.Test;

import java.io.IOException;

public class HttpDownloadUtilsTest {
    @Test
    public void testDownloadFile() throws IOException {
        try {
            HttpDownloadUtils.downloadFile("http://cfile2.uf.tistory.com/image/242B704E52B2E0791E58B3", "/Users/myungjoonlee/Downloads");
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }
    }
}
