package com.github.seijuro.common.http.file;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloader {
    private static final int ByteBufferSize = 2048;

    protected final String dest;

    public FileDownloader(String dest) {
        this.dest = dest;
    }

    public String getAbsoluteFilepath(String filename) throws IllegalArgumentException {
        if (StringUtils.isEmpty(filename)) {
            throw new IllegalArgumentException("Parameter, filename, is empty.");
        }

        StringBuffer sb = new StringBuffer(this.dest);
        if (!this.dest.endsWith(File.separator)) {
            sb.append(File.separator);
        }

        sb.append(filename);

        return sb.toString();
    }

    public boolean download(String url, String filename) throws IOException {
        if (StringUtils.isEmpty(url)) {
            throw new IllegalArgumentException("Input URL is empty.");
        }

        if (StringUtils.isEmpty(filename)) {
            throw new IllegalArgumentException("Input 'filename' is empty.");
        }

        try {
            int lastIndex = url.lastIndexOf("/");
            String requestURL = url;
            String checkingSubstring = url.substring(url.lastIndexOf("/")).toLowerCase();

            if (checkingSubstring.endsWith(".pdf") || checkingSubstring.endsWith(".hwp") || checkingSubstring.endsWith(".doc") || checkingSubstring.endsWith(".docx") || checkingSubstring.endsWith(".ppt")) {
                requestURL = String.format("%s/%s", url.substring(0, lastIndex), URLEncoder.encode(url.substring(lastIndex + 1, url.length()), "UTF-8"));
            }

            System.out.println("requestURL : " + requestURL);

            URL fileURL = new URL(requestURL);

            HttpURLConnection httpConn = (HttpURLConnection)fileURL.openConnection();
            int responseCode = httpConn.getResponseCode();


            if (responseCode == HttpURLConnection.HTTP_OK) {
                String disposition = httpConn.getHeaderField("Content_disposition");
                String contentType = httpConn.getContentType();
                int contentLength = httpConn.getContentLength();

                System.out.println("Content-Type = " + contentType);
                System.out.println("Content-Disposition = " + disposition);
                System.out.println("Content-Length = " + contentLength);
                System.out.println("fileName = " + filename);
            }

            String destPath = getAbsoluteFilepath(filename);
            Path path = Paths.get(destPath.substring(0, destPath.lastIndexOf(File.separator)));

            Files.createDirectories(path);

            try {
                InputStream is = httpConn.getInputStream();
                FileOutputStream fos = new FileOutputStream(destPath);

                int bytesRead = -1;
                byte[] buffer = new byte[ByteBufferSize];

                while ((bytesRead = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

                fos.close();
                is.close();
            }
            catch (IOException excp) {
                excp.printStackTrace();

                Files.deleteIfExists(path);

                throw excp;
            }

            System.out.println(String.format("Downloading file is done (path : [%s]).", destPath));

            return true;
        }
        catch (MalformedURLException excp) {
            excp.printStackTrace();
        }

        return false;
    }
}
