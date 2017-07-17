package com.github.seijuro.common.sys;

import java.util.*;

/**
 * Created by seijuro
 */
public class SystemVariableHelper {
    static class Constants {
        static final String FILE_SEPERATOR = "file.separator";
        static final String JAVA_CLASS_PATH = "java.class.path";
        static final String JAVA_HOME = "java.home";
        static final String JAVA_VENDOR = "java.vendor";
        static final String JAVA_VENDOR_URL = "java.vendor.url";
        static final String JAVA_VERSION = "java.version";
        static final String OS_NAME = "os.name";
        static final String OS_ARCH = "os.arch";
        static final String OS_VERSION = "os.version";
        static final String PATH_SEPERATOR = "path.separator";
        static final String USER_DIR = "user.dir";
        static final String USER_HOME = "user.home";
        static final String USER_NAME = "user.name";
    }

    public static String getFileSeparator() {
        return System.getProperty(Constants.FILE_SEPERATOR);
    }

    public static String getJavaHome() {
        return System.getProperty(Constants.JAVA_HOME);
    }

    public static String getJavaVersion() {
        return System.getProperty(Constants.JAVA_VERSION);
    }

    public static String getOSName() {
        return System.getProperty(Constants.OS_NAME);
    }

    public static String getOSVersion() {
        return System.getProperty(Constants.OS_VERSION);
    }

    public static String getUserName() {
        return System.getProperty(Constants.USER_NAME);
    }

    public static String getUserHome() {
        return System.getProperty(Constants.USER_HOME);
    }

    public static List<String> getSystemVariableNames() {
        List<String> variables = new ArrayList<>();

        Properties props = System.getProperties();
        Enumeration enumeration = props.propertyNames();

        while (enumeration.hasMoreElements()) {
            variables.add((String)enumeration.nextElement());
        }

        return variables;
    }

    public static String getSystemVariables(String key) {
        String result = null;
        Properties props = System.getProperties();
        Enumeration enumeration = props.propertyNames();

        while (enumeration.hasMoreElements()) {
            String variable = (String)enumeration.nextElement();

            if (variable.equals(key)) {
                result = props.getProperty(variable);
                break;
            }
        }

        return result;
    }

    public static Map<String, String> getSystemVariables(List<String> keys) {
        Map<String, String> results = new HashMap<>();
        Properties props = System.getProperties();
        Enumeration enumeration = props.propertyNames();

        while (enumeration.hasMoreElements()) {
            String variable = (String)enumeration.nextElement();

            results.put(variable, props.getProperty(variable));
        }

        return results;
    }

    public static Map<String, String> getSystemVariablesLike(String $key) {
        Map<String, String> results = new HashMap<>();

        Properties props = System.getProperties();
        Enumeration enumeration = props.propertyNames();

        while (enumeration.hasMoreElements()) {
            String key = (String)enumeration.nextElement();

            if (key.indexOf($key) >= 0) {
                results.put(key, props.getProperty(key));
            }
        }

        return results;
    }
}
