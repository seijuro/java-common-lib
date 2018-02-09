package com.github.seijuro.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

public class ZipUtilsTest {
    public static String TestZipFile1 = "/Users/myungjoonlee/Desktop/TEST/download/지번별에너지사용량_전기_201706.zip";
    public static String TestNonzipFile2 = "/Users/myungjoonlee/Desktop/TEST/unzip/201706/지번별에너지사용량_전기_201706.TXT";

    @Test
    public void testCheckingZipFile() {
        Assert.assertTrue(ZipUtils.isZipFile(Paths.get(TestZipFile1)));
        Assert.assertFalse(ZipUtils.isZipFile(Paths.get(TestNonzipFile2)));
    }
}
