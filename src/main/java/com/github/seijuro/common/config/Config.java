package com.github.seijuro.common.config;

/**
 * Created by seijuro
 */
public class Config {
    private final String key;
    private final String value;

    public Config(String $key, String $value) {
        this.key = $key;
        this.value = $value;
    }

    public String key() {
        return this.key;
    }

    public String value() {
        return this.value;
    }

    @Override
    public int hashCode() {
        int code = 17 * this.key.hashCode();
        code = code << 31 * this.value.hashCode();

        return code;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Config) {
            return hashCode() == obj.hashCode();
        }

        return false;
    }
}
