package com.github.seijuro.common.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileUtils {
    public static int getLineNumber(File file) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(file));
        lnr.skip(Long.MAX_VALUE);
        int lines = lnr.getLineNumber() + 1;
        lnr.close();

        return lines;
    }
}
