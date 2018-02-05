package com.github.seijuro.common.param;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class OptionalParametersParser {
    Logger logger = LoggerFactory.getLogger(OptionalParametersParser.class);

    /**
     *
     * @param args
     * @return
     */
    public static List<OptionalParameter> parseParameters(String[] args) {
        OptionalParametersParser optionalParameter = new OptionalParametersParser();
        optionalParameter.parse(args);

        return optionalParameter.getOptions();
    }


    public static final String OPTION_PREFIX1 = "-";
    public static final String OPTION_PREFIX2 = "--";
    public static final String ASSIGNMENT_OP = "=";

    /**
     * Instance Properties
     */
    List<OptionalParameter> options = new ArrayList<>();

    /**
     * Construct
     */
    protected OptionalParametersParser() {
    }

    public List<OptionalParameter> getOptions() {
        return options;
    }

    protected void parse(String[] args) {
        if (Objects.nonNull(args) && args.length > 0) {
            for (int index = 0; index < args.length; ++index) {
                String arg = args[index];

                if (isOptionalParameter(arg)) {
                    final String optKey = extractKey(arg);
                    String optValue = StringUtils.EMPTY;

                    if (containsAssignmentOp(arg)) {
                        optValue = extractValue(arg);
                    }
                    else {
                        if ((index + 1) < args.length &&
                                !isOptionalParameter(args[index + 1])) {
                            optValue = args[++index];
                        }
                    }

                    OptionalParameter optParam = new OptionalParameter(optKey, optValue);
                    if (Collections.binarySearch(options, optParam) >= 0) {
                        //  ignore & ignore
                        logger.warn("[PARAM/PARSE] Parameter, \"{}\", is ignored (reason : DUPLICATED, value : {}).", optKey, optValue);
                    }
                    else {
                        options.add(optParam);
                    }
                }
            }
        }
    }

    protected boolean isOptionalParameter(String arg) {
        return arg.startsWith(OPTION_PREFIX1) || arg.startsWith(OPTION_PREFIX2);
    }

    protected boolean containsAssignmentOp(String arg) {
        return arg.contains(ASSIGNMENT_OP);
    }

    protected String extractKey(String arg) {
        assert isOptionalParameter(arg);
        int startIndex = arg.startsWith(OPTION_PREFIX2) ? arg.indexOf(OPTION_PREFIX1) + 2 : arg.indexOf(OPTION_PREFIX2) + 1;
        String optKey;

        if (containsAssignmentOp(arg)) {
            optKey = arg.substring(startIndex, arg.indexOf(ASSIGNMENT_OP));
        }
        else {
            optKey = arg.substring(startIndex, arg.length());
        }

        return optKey;
    }

    protected String extractValue(String arg) {
        assert containsAssignmentOp(arg);

        return arg.substring(arg.indexOf(ASSIGNMENT_OP) + 1, arg.length());
    }
}
