package com.github.seijuro.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.Objects;
import java.util.zip.ZipEntry;
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


    public static void unzip(Path src, Path destDir) {
        unzip(src, destDir, null);
    }

    /**
     * unzip file at path, src into out directory, destDir.
     * Sometime, we need to retrieve ZipEntry with the specific <code>Charset</code>.
     * The 3rd param, charset, is designed for that purpose. You can easily solve that kinda problem by set the 3rd param, charset.
     *
     * @param src
     * @param destDir
     * @param charset
     */
    public static void unzip(Path src, Path destDir, Charset charset) {
        assert Objects.nonNull(src) && Objects.nonNull(destDir);

        boolean result;
        String dest = destDir.toFile().getAbsolutePath();

        if (!dest.endsWith(File.separator)) {   dest = dest + File.separator;   }

        if (!(result = Files.exists(destDir))) {
            LOG.debug("Creating directories ... dest : {}", destDir.toFile().getAbsolutePath());

            destDir.toFile().mkdirs();
        }

        LOG.debug("Creating directories is done ... result : {}", result);

        try {
            ZipFile zipFile = Objects.nonNull(charset) ? new ZipFile(src.toFile(), charset) : new ZipFile(src.toFile());
            Enumeration entries = zipFile.entries();
            int index = 0;

            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry)entries.nextElement();

                if (!zipEntry.isDirectory()) {
                    //  Log
                    LOG.debug("entry : {}", zipEntry);

                    String zipEntryName = zipEntry.getName();
                    int pos = zipEntryName.lastIndexOf(File.separator);

                    if (pos > 0) {
                        String parent = dest + zipEntryName.substring(0, pos);
                        Path parentPath = Paths.get(parent);

                        if (!Files.exists(parentPath)) {
                            parentPath.toFile().mkdirs();
                        }
                    }

                    final int BufferSize = 4096;
                    int readBytes;
                    byte[] buf = new byte[BufferSize];
                    InputStream is = zipFile.getInputStream(zipEntry);
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest + zipEntryName));

                    while ((readBytes = is.read(buf)) > 0) {
                        bos.write(buf, 0, readBytes);
                    }

                    bos.close();
                    is.close();
                }
            }

            zipFile.close();
        }
        catch (FileNotFoundException fnfexcp) {
            fnfexcp.printStackTrace();
        }
        catch (IOException ioexcp) {
            ioexcp.printStackTrace();
        }
    }
}
