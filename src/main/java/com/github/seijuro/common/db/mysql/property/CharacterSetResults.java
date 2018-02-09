package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
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
    public static CharacterSetResults create(Object encoding) {
        if (encoding instanceof String) {
            return new CharacterSetResults(PropertyName, String.class.cast(encoding));
        }

        //  Log (WARN)
        LOG.warn("Param, encoding, is empty");

        return null;
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
