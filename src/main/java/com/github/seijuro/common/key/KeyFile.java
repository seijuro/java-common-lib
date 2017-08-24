package com.github.seijuro.common.key;

import lombok.AccessLevel;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class KeyFile {
    static final String defaultSeperator = "=";
    static final String valueSperator = ",";

    boolean isChaned = false;
    @Setter(AccessLevel.PUBLIC)
    private String seperator = defaultSeperator;
    private String keypath = null;
    private Map<String, List<String>> keyMap = new HashMap<>();

    /**
     * C'tor
     *
     * @param path
     */
    public KeyFile(String path) {
        keypath = path;
        isChaned = true;
    }

    private void load() throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get(keypath));
        String line;

        keyMap.clear();

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(seperator, 2);

            assert (tokens.length == 2);
            String name = StringUtils.stripToNull(tokens[0]);
            String key = StringUtils.stripToEmpty(tokens[1]);
            List<String> keys = Arrays.asList(tokens[1].split(valueSperator));

            if (name != null ||
                    keys.size() > 0) {
                keyMap.put(name, keys);
            }
        }
    }

    synchronized public void setKeypath(String path) {
        if (!keypath.equals(path)) {
            this.isChaned = true;
        }
    }

    synchronized public String getKey(String name) {
        try {
            if (isChaned) {
                load();
                isChaned = false;
            }

            return keyMap.get(name).get(0);
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        return null;
    }

    synchronized public List<String> getKeys(String name) {
        try {
            if (isChaned) {
                load();
                isChaned = false;
            }

            return keyMap.get(name);
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        return null;
    }
}
