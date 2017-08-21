package com.github.seijuro.common.io;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class BufferedFileReader implements Cloneable, AutoCloseable {
    @Getter
    private final String filepath;
    @Getter
    private final String charsetName;
    private BufferedReader reader;

    /**
     * Construct
     *
     * @param path
     * @param chname
     * @throws IllegalArgumentException
     */
    public BufferedFileReader(String path, String chname) throws IllegalArgumentException {
        if (!Objects.nonNull(path)) {
            throw new IllegalArgumentException(String.format("Filepath(%s) is null", path));
        }

        if (!Files.exists(Paths.get(path))) {
            throw new IllegalArgumentException(String.format("File doesn't exists at path(%s)", path));
        }

        filepath = path;
        charsetName = chname;
    }

    public BufferedReader getReader() throws IOException {
        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), charsetName));
        }

        return reader;
    }

    public String readLine() throws IOException {
        BufferedReader br = getReader();

        return br.readLine();
    }

    @Override
    public void close() throws IOException {
        try {
            if (reader != null) {
                reader.close();
            }
        }
        catch (IOException excp) {

        }

        reader = null;
    }
}
