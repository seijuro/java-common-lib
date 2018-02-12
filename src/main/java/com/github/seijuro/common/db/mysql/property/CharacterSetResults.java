package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CharacterSetResults extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CharacterSetResults.class);

    public static final String PropertyName = "characterSetResults";

    /**
     * create {@link CharacterSetResults} instance.
     *
     * @param encoding
     * @return
     */
    public static CharacterSetResults create(String encoding) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(encoding)) {
            return new CharacterSetResults(PropertyName, String.class.cast(encoding));
        }

        String msg = String.format("Param, encoding, is empty.");

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * C'tor
     *
     * @param $name
     * @param encoding
     */
    protected CharacterSetResults(String $name, String encoding) {
        super($name, encoding);
    }
}
