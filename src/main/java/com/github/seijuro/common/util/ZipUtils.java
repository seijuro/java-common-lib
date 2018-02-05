package com.github.seijuro.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.zip.ZipFile;

public class ZipUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ZipUtils.class);
    private static final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.zip");

    /**
     * check if the file at path is a zip file or not.
     *
     * @param path
     * @return
     */
    public static boolean isZipFile(Path path) {
        assert path instanceof Path;

        try {
            ZipFile zipFile = new ZipFile(path.toFile());

            return true;
        }
        catch (IOException ioexcp) {
            ioexcp.printStackTrace();
        }

        return false;
    }

    /**
     * check if the filename contains 'zip' extension.
     *
     * @param path
     * @return
     */
    public static boolean containsZipExtension(Path path) {
        return matcher.matches(path);
    }
}
