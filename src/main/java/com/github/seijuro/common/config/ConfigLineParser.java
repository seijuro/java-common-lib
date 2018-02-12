package com.github.seijuro.common.config;

import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ConfigLineParser {
    /**
     * Class Properties
     */
    private static final Logger LOG = LoggerFactory.getLogger(ConfigLineParser.class);

    private static final String AssignmentOp = "=";
    private static final String CommentOp = "#";
    private static final int MaxTokenSize = 2;

    /**
     * parse {@param line} and return {@link Pair} instance.
     * If the {@param line} is comment or not valid, it will return null.
     *
     * @param clazz
     * @param line
     * @return
     */
    public static <T extends Enum<T>> Pair<T, String> parse(Class<T> clazz, String line) {
        String trimmed = StringUtils.stripToEmpty(line);

        if (StringUtils.isNotEmpty(trimmed)) {
            if (!trimmed.startsWith(CommentOp)) {
                String[] tokens = trimmed.split(AssignmentOp, MaxTokenSize);

                if (tokens.length == MaxTokenSize) {
                    String key = tokens[0];
                    String value = tokens[1];

                    //  throw IllegalArgumentException, if there aren't elements whose key is equals to the parameter, key.
                    T config = T.valueOf(clazz, key);

                    if (Objects.nonNull(config)) {
                        return new Pair<>(config, value);
                    }

                    //  Log
                    LOG.warn("Can't retrieve constant ({}) from class, {}", key, clazz.getTypeName());
                }
            }
        }


        return null;
    }
}
