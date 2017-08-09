package com.github.seijuro.common.config;

import com.github.seijuro.common.sys.SystemVariableHelper;

import java.io.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by seijuro
 *
 * AppConfigReader have $key-$value entry container.
 * $key : filename, not filepath. so it doesn't allow duplicated filename.
 * $value : configuration written in configuration file.
 *
 * the configuration file contains a number of configurations.
 * At First, AppConfigReader separate each configuration using line separator.
 * That is, One configuration must be written in one line in the configuration file.
 * The configuration consists of key , key-value sepeartor, value.
 * At this point, the equal makr,'=', is used for key-value separarater.
 *
 */
public class AppConfigReader {
    public static final String SYS_VARIRABLE = "app.conf";

    static final String CONF_KV_SEPARATOR = "\\s*=\\s*";
    static final String CONF_COMMNET_INDICATOR = "#";

    /**
     * Singleton instance
     */
    static AppConfigReader instance;

    /**
     * Singleton pattern method
     *
     * @return singleton instance if exists. Otherwise, this methods instantiate the singleton instance & return it.
     */
    synchronized public static AppConfigReader getInstance() {
        if (instance == null) {
            instance = new AppConfigReader();
            instance.init();
        }

        return instance;
    }

    /**
     * Instance Propeties
     */
    private String appConfDirath = null;
    private Map<String, ConfigFile> appConfFiles;

    /**
     * C'tor
     */
    AppConfigReader() {
    }

    /**
     * 1. traverse the director you passed as parameter.
     * 2. find & parse all 'regular' config files.
     *
     * [parsing rule]
     * $config := $key '=' $value
     *
     *
     * @param dir
     */
    protected void traverseDirectory(final File dir) {
        for (final File fileEntry : dir.listFiles()) {
            if (fileEntry.isDirectory()) {
                traverseDirectory(fileEntry);
            }
            else {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fileEntry.getAbsoluteFile()));
                    ConfigFile.Builder cb = new ConfigFile.Builder();
                    String line;

                    cb.setFilepath(fileEntry.getAbsolutePath());

                    while ((line = br.readLine()) != null) {
                        String trimmed = line.trim();

                        //  check if this line is comment.
                        if (trimmed.startsWith(CONF_COMMNET_INDICATOR)) continue;

                        String[] tokens = trimmed.split(CONF_KV_SEPARATOR,2);

                        //  check if this line is valid.
                        if (tokens.length < 2) continue;

                        String key = tokens[0];
                        String value = tokens[1];

                        cb.addConfig(tokens[0].trim(), tokens[1].trim());
                    }

                    String filepath = fileEntry.getAbsolutePath();
                    int index = filepath.lastIndexOf(SystemVariableHelper.getFileSeparator());
                    String filename = filepath.substring(index >= 0 ? index + 1 : 0, filepath.length());

                    appConfFiles.put(filename, cb.build());
                }
                catch (FileNotFoundException excp) {
                    excp.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Inistialize AppConfigReader instance.
     * this method would be called only once after instantiating singleton instance.
     */
    protected void init() {
        this.appConfDirath = SystemVariableHelper.getSystemVariables(SYS_VARIRABLE);
        this.appConfFiles = new HashMap<>();

        traverseDirectory(new File(this.appConfDirath));
    }

    public String getAppConfPath() {
        return this.appConfDirath;
    }

    public ConfigFile getConfigFile(String filename) {
        return this.appConfFiles.get(filename);
    }

    public boolean containsFile(String filename) {
        return this.appConfFiles.containsKey(filename);
    }

    public void clear() {
        this.appConfFiles.clear();
    }
}
