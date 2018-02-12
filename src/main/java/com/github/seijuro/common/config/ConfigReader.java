package com.github.seijuro.common.config;

import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class ConfigReader<T extends Enum<T>> {
    /**
     * Class Properties
     */
    private static final Logger LOG = LoggerFactory.getLogger(ConfigReader.class);

    /**
     * Instance Properties
     */
    private final Class<T> clazz;

    /**
     * C'tor
     *
     * @param $clazz
     */
    protected ConfigReader(Class<T> $clazz) {
        this.clazz = $clazz;
    }

    /**
     * read and parse config file located at {@param filepath}.
     * 1st param, {@param clazz}, must be {@link Enum<T>} class and this will retrieve config within constants defined in enum.
     *
     * @param filepath
     * @return
     * @throws IllegalArgumentException
     * @throws IOException
     */
    public Map<T, String> read(String filepath) throws IOException {
        if (StringUtils.isEmpty(filepath)) {
            String msg = "Param, filepath, is empty.";

            //  Log (WARN)
            LOG.warn(msg);

            throw new IllegalArgumentException(msg);
        }

        return read(Paths.get(filepath));
    }

    /**
     * read and parse config file located at {@param filepath}.
     * 1st param, {@param clazz}, must be {@link Enum<T>} class and this will retrieve config within constants defined in enum.
     *
     * @param filepath
     * @return
     * @throws IllegalArgumentException
     * @throws IOException
     */
    public Map<T, String> read(Path filepath) throws IOException {
        if (Objects.isNull(filepath)) {
            String msg = "Param, filepath, is null.";

            //  LOG (WARN)
            LOG.warn(msg);

            throw new IllegalArgumentException(msg);
        }

        if (Files.exists(filepath)) {
            if (Files.isReadable(filepath)) {
                Map<T, String> configs = new HashMap<>();

                BufferedReader br = new BufferedReader(new FileReader(filepath.toFile()));
                String line;

                while (Objects.nonNull(line = br.readLine())) {
                    try {
                        Pair<T, String> parsed = ConfigLineParser.parse(clazz, line);

                        if (Objects.nonNull(parsed)) {
                            T config = parsed.getKey();

                            if (Objects.nonNull(config)) {
                                //  Log (DEBUG)
                                LOG.debug("(PARSED) config := {config : {}, value : {}}", parsed.getKey(), parsed.getValue());

                                configs.put(config, parsed.getValue());
                            } else {
                                //  Log (WARN)
                                LOG.warn("(IGNORED) config ({}) is not valid.", config);
                            }
                        } else {
                            //  Log (DEBUG)
                            LOG.debug("(SKIP) line : {}", line);
                        }
                    }
                    catch (IllegalArgumentException excp) {
                        //  Log (WARN)
                        LOG.warn("(IGNORE) line : {}", line);
                    }
                }

                br.close();

                return configs;
            }
            else {
                String msg = String.format("File (path : %s) is not readable.", filepath.toString());

                //  Log
                LOG.warn(msg);

                throw new IOException(msg);
            }
        }

        String msg = String.format("There are not file at path(%s)", filepath.toString());

        //  Log
        LOG.warn(msg);

        throw new FileNotFoundException(msg);
    }
}
