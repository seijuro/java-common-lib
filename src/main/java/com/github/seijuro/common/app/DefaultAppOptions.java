package com.github.seijuro.common.app;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class DefaultAppOptions {
    /**
     * Class Instance(s)
     */
    private static final Logger LOG = LoggerFactory.getLogger(DefaultAppOptions.class);

    private static final String DefaultConfDirectoryName = "conf";
    private static final String DefaultTempDirectoryName = "tmp";
    private static final String DefaultLogDirectoryName = "log";
    
    private static final String AppConfigFilename = "app.conf";

    public enum Opt {
        HOME("h", "home", true, true, 1, "path to application home directory."),
        CONF("c", "config", false, true, 1, "path to direcotry which contains configuration files."),
        TMP("t", "tmp", false, true, 1, "path to temporary directory."),
        LOG("l", "log", false, true, 1, "path to directory which contain log files.");

        /**
         * Instance Properties
         */
        @NonNull
        @Getter
        private final String shortText;
        @NonNull
        @Getter
        private final String longText;
        @NonNull
        @Getter
        private final String description;
        private final boolean required;
        private final boolean hasArgs;
        private final int numberOfArgs;

        /**
         * return {@link Option} instance.
         *
         * @return
         */
        Option option() {
            Option.Builder builder = Option.builder(this.shortText)
                    .longOpt(this.longText)
                    .desc(this.description)
                    .required(this.required)
                    .hasArg(this.hasArgs);

            if (this.hasArgs)   {   builder.numberOfArgs(this.numberOfArgs);    }

            return builder.build();
        }

        /**
         * C'tor
         *
         * @param $stext
         */
        Opt(String $stext, String $ltext, boolean $required, boolean $hasArgs, int $cntArgs, String $desc) {
            this.shortText = $stext;
            this.longText = $ltext;
            this.required = $required;
            this.hasArgs = $hasArgs;
            this.numberOfArgs = $cntArgs;
            this.description = $desc;
        }
    }

    /**
     * parse application arguments, {@param args}, and return {@link DefaultAppOptions} instance.
     *
     * @param args
     * @return
     * @throws ParseException
     */
    public static DefaultAppOptions parse(String[] args) throws ParseException {
        DefaultAppOptions appOptions = new DefaultAppOptions();
        CommandLine commandLine;
        Options options = new Options();

        for (Opt op : Opt.values()) {
            options.addOption(op.option());
        }

        CommandLineParser parser = new DefaultParser();

        commandLine = parser.parse(options, args);

        for (Opt op : Opt.values()) {
            //  Log
            LOG.debug("Option '{} ({})' is present. The value is '{}'", op.getShortText(), op.getLongText(), commandLine.getOptionValue(op.getShortText(), null));
        }

        if (commandLine.hasOption(Opt.HOME.getShortText()))  {   appOptions.setHome(commandLine.getOptionValue(Opt.HOME.getShortText())); }
        if (commandLine.hasOption(Opt.CONF.getShortText()))  {   appOptions.setConf(commandLine.getOptionValue(Opt.CONF.getShortText())); }
        if (commandLine.hasOption(Opt.TMP.getShortText()))   {   appOptions.setTmp(commandLine.getOptionValue(Opt.TMP.getShortText()));   }
        if (commandLine.hasOption(Opt.LOG.getShortText()))   {   appOptions.setLog(commandLine.getOptionValue(Opt.LOG.getShortText()));   }

        {
            String[] remainder = commandLine.getArgs();

            System.out.print("Remaining args : ");
            for (String arg : remainder) {
                System.out.print(arg);
                System.out.print(" ");
            }

            System.out.println();
        }

        return appOptions;
    }

    /**
     * Instance Properties
     */
    @Setter(AccessLevel.PROTECTED)
    @Getter
    private String home = null;
    @Setter(AccessLevel.PROTECTED)
    private String conf = null;
    @Setter(AccessLevel.PROTECTED)
    private String log = null;
    @Setter(AccessLevel.PROTECTED)
    private String tmp = null;

    /**
     * returns the filepath to application config file whose name is 'app.conf'.
     * If not set 'config' option, it return 'default' filepath.
     * default filepath is '$HOME/conf/app.conf'.
     *
     * @return
     */
    public String getAppConfigFilepath() {
        String confDirPath = getConfigDirectory();

        return String.format("%s%s%s", confDirPath, confDirPath.endsWith(File.separator) ? "" : File.separator, AppConfigFilename);
    }

    /**
     * returns the path to directory contains config files.
     * If not set, it return 'default' path.
     * 'default' path is '$HOME/conf'
     *
     * @return
     */
    public String getConfigDirectory() {
        if (StringUtils.isNotEmpty(this.conf)) {
            return this.conf;
        }

        return String.format("%s%s%s", getHome(), getHome().endsWith(File.separator) ? "" : File.separator, DefaultConfDirectoryName);
    }

    /**
     * return the path to temporary directory.
     * If not set, it return 'default' path.
     * 'default path is '$HOME/tmp'.
     *
     * @return
     */
    public String getTempDirectory() {
        if (StringUtils.isNotEmpty(this.tmp)) {
            return this.tmp;
        }

        return String.format("%s%s%s", getHome(), getHome().endsWith(File.separator) ? "" : File.separator, DefaultTempDirectoryName);
    }

    /**
     * return the path to log directory.
     * If not set, it return 'default' path.
     * 'default path is '$HOME/log'.
     *
     * @return
     */
    public String getLogDirectory() {
        if (StringUtils.isNotEmpty(this.log)) {
            return this.log;
        }

        return String.format("%s%s%s", getHome(), getHome().endsWith(File.separator) ? "" : File.separator, DefaultLogDirectoryName);
    }
}
