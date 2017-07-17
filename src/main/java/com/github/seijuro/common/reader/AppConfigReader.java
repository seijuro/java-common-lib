package com.github.seijuro.common.reader;

import com.github.seijuro.common.SystemVariableHelper;
import com.github.seijuro.common.config.ConfigFile;

import java.io.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by myungjoonlee on 2017. 7. 17..
 */
public class AppConfigReader {
    public static final String SYS_VARIRABLE = "app.conf";
    public static final String CONF_KV_SEPARATOR = "\\s*=\\s*";

    /**
     * Singleton instance
     */
    static AppConfigReader instance;

    synchronized public static AppConfigReader getInstance() {
        if (instance == null) {
            instance = new AppConfigReader();
            instance.init();
        }

        return instance;
    }

    private String appConfDirath = null;
    private Map<String, ConfigFile> appConfFiles;

    /**
     * C'tor
     */
    AppConfigReader() {
    }

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
                        String[] tokens = line.split(CONF_KV_SEPARATOR,2);

                        String key = tokens[0].trim();
                        String value = tokens[1].trim();

                        System.out.println("key : " + key + ", value : " + value);

                        cb.addConfig(tokens[0].trim(), tokens[1].trim());
                    }

                    String filepath = fileEntry.getAbsolutePath();
                    int index = filepath.lastIndexOf(SystemVariableHelper.getFileSeparator());
                    String filename = filepath.substring(index >= 0 ? index + 1 : 0, filepath.length());

                    System.out.println("filename : " + filename);

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
