package com.github.seijuro.common.config;


import com.github.seijuro.common.sys.SystemVariableHelper;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by seijuro
 */
public class ConfigFile {
    private final String filepath;
    private final Map<String, Config> configs;

    /**
     * C'tor
     *
     * @param builder
     */
    ConfigFile(Builder builder) {
        this.filepath = builder.filepath;
        this.configs = builder.configs;
    }

    public String filepath() {
        return this.filepath;
    }

    public String filename() {
        String separator = SystemVariableHelper.getFileSeparator();
        int index = this.filepath.indexOf(separator);

        if (index >= 0 && index < this.filepath.length()) {
            return this.filepath.substring(index + 1, this.filepath.length());
        }

        return this.filepath;
    }

    public String configValue(String key) {
        if (this.configs.containsKey(key)) { return this.configs.get(key).value(); }

        return null;
    }

    public Config config(String key) {
        if (this.configs.containsKey(key)) { return this.configs.get(key); }

        return null;
    }

    public Set<String> keySet() {
        return this.configs.keySet();
    }

    public void prettyPrint(Consumer<String> conumser) {
        StringBuilder sb = new StringBuilder(getClass().getCanonicalName());

        sb.append(" := {");
        boolean isFirst = true;
        for (Map.Entry<String, Config> entry : this.configs.entrySet()) {
            if (isFirst) {
                isFirst = false;
            }
            else {
                sb.append(", ");
            }

            sb.append("(key : ").append(entry.getKey());
            sb.append(", value : ").append(entry.getValue().value()).append(")");
        }
        sb.append("}");

        conumser.accept(sb.toString());
    }

    /**
     * Builder pattern class
     */
    public static class Builder {
        private String filepath = null;
        private Map<String, Config> configs = new HashMap<>();

        public Builder() {
        }

        public Builder setFilepath(String name) {
            this.filepath = name;
            return this;
        }

        public Builder addConfig(String key, String value) {
            this.configs.put(key, new Config(key, value));
            return this;
        }

        public Builder addConfig(Config config) {
            this.configs.put(config.key(), config);
            return this;
        }

        public Builder addConfigs(Properties $configs) {
            Enumeration e = $configs.propertyNames();

            while (e.hasMoreElements()) {
                String key = (String)e.nextElement();

                this.configs.put(key, new Config(key, $configs.getProperty(key)));
            }

            return this;
        }

        /**
         * Builer pattern method.
         *
         * @return
         */
        public ConfigFile build() {
            return new ConfigFile(this);
        }
    }
}
