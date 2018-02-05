package com.github.seijuro.common.http;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.http.HTTPException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;

public class HttpDownloadUtils {
    //  logger
    private static final Logger logger = LoggerFactory.getLogger(HttpDownloadUtils.class);

    static final int ByteBufferSize = 2048;
    static final String RequestPropertyAcceptEncoding = "Accept-Encoding";

    private static class Temporary {
        static final String FilePrefix = "com.github.seijuro.commlib.";
        static final String FileSuffix = ".tmp";
        static final String Direcotry = "/tmp";
    }

    private enum AcceptEncoding {
        GZIP("gzip"),
        DEFLATE("deflate");

        @Getter
        private final String text;

        AcceptEncoding(String text) {
            this.text = text;
        }
    }

    public static void createDiectoryIfNotExists(String path) throws IOException {
        Path directoryPath = Paths.get(path);

        if (Files.notExists(directoryPath)) {
            Files.createDirectory(directoryPath);
        }
    }

    public static File createTempFile() throws IOException {
        File tempFile = File.createTempFile(Temporary.FilePrefix, Temporary.FileSuffix, new File(Temporary.Direcotry));
        return tempFile;
    }

    public static void downloadFile(String url, String directory) throws IOException, IllegalArgumentException {
        if (StringUtils.isEmpty(url) ||
                StringUtils.isEmpty(directory)) {
            String msg = String.format("The params is illegal (url : [%s], directory : [%s]).", url, directory);
            throw new IllegalArgumentException(msg);
        }

        //  Log
        logger.debug("Downloading file is done (url : {}, directory : {}).", url, directory);

        try {
            //  create direcotry if not exists.
            createDiectoryIfNotExists(directory);

            String targetPath = String.format("%s%s%s", directory, directory.endsWith(File.separator) ? "" : File.separator, url.contains("/") ? url.substring(url.lastIndexOf("/") + 1, url.length()) : url);

            //  download file
            int responseCode = downloadBinary(url, targetPath);


            //  Log
            logger.debug("Downloading file is done (url : {}, path : {}).", url, targetPath);
        }
        catch (IOException ioexcp) {
            ioexcp.printStackTrace();

            throw ioexcp;
        }
    }

    private static int downloadBinary(String url, String dest) throws IOException, HTTPException {
        final int EOF = -1;

        URL requestURL = new URL(url);
        HttpURLConnection conn = HttpURLConnection.class.cast(requestURL.openConnection());
        int resposeCode = conn.getResponseCode();

        if (resposeCode == HttpURLConnection.HTTP_OK) {
            String disposition = conn.getHeaderField("Content_disposition");
            String contentType = conn.getContentType();
            int contentLength = conn.getContentLength();

            //  Log
            logger.debug("Content := { Type : {}, Disposition : {}, Length : {} }", contentType, disposition, contentLength);

            InputStream is = conn.getInputStream();
            byte[] buff = new byte[ByteBufferSize];
            int readBytes = 0;
            long totalBytes = 0L;

            File tmpFile = createTempFile();

            try {
                FileOutputStream fos = new FileOutputStream(tmpFile);

                while ((readBytes = is.read(buff)) != EOF) {
                    fos.write(buff, 0, readBytes);
                    totalBytes += readBytes;
                }

                fos.close();
                is.close();
                conn.disconnect();

                if (Files.exists(Paths.get(dest))) {
                    throw new IOException(String.format("File already exists (path : %s).", dest));
                }

                Files.move(tmpFile.toPath(), Paths.get(dest));
            }
            finally {
                if (tmpFile.exists()) { tmpFile.delete();   }
            }
        }

        return resposeCode;
    }

    public static String downloadText(String url) throws IOException {
        URL requestURL = new URL(url);
        HttpURLConnection conn = HttpURLConnection.class.cast(requestURL.openConnection());
        StringBuffer content = new StringBuffer();
        InputStream is = null;

        conn.setRequestProperty(RequestPropertyAcceptEncoding, String.format("%s, %s", AcceptEncoding.DEFLATE.getText(), AcceptEncoding.GZIP.getText()));
        String encoding = conn.getContentEncoding();

        if (Objects.nonNull(encoding) && encoding.equalsIgnoreCase(AcceptEncoding.GZIP.getText())) {
            is = new GZIPInputStream(conn.getInputStream());
        }
        else if (Objects.nonNull(encoding) && encoding.equalsIgnoreCase(AcceptEncoding.DEFLATE.getText())) {
            is = new DeflaterInputStream(conn.getInputStream());
        }
        else {
            is = conn.getInputStream();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;

        while ((line = br.readLine()) != null) {
            content.append(line);
        }

        br.close();
        is.close();

        conn.disconnect();

        return content.toString();
    }
}
