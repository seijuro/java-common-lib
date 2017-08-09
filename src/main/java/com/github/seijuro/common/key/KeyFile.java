package com.github.seijuro.common.key;

import lombok.AccessLevel;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class KeyFile {
    static final String defaultSeperator = "=";

    boolean isChaned = false;
    @Setter(AccessLevel.PUBLIC)
    private String seperator = defaultSeperator;
    private String keypath = null;
    private Map<String, String> keyMap = new HashMap<>();

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
            String key = StringUtils.stripToNull(tokens[1]);

            if (name != null ||
                    key != null) {
                keyMap.put(name, key);
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

            return keyMap.get(name);
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        return null;
    }
}
