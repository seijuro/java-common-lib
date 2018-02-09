package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CharacterSetResults implements JDBCConfigurationProperty {
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
            return new CharacterSetResults(String.class.cast(encoding));
        }

        //  Log (WARN)
        LOG.warn("Param, encoding, is empty");

        return null;
    }

    /**
     * Instance Properties
     */
    @Getter
    private final String propertyValue;

    public java.lang.String getPropertyName() {
        return PropertyName;
    }

    /**
     * C'tor
     *
     * @param encoding
     */
    protected CharacterSetResults(String encoding) {
        this.propertyValue = encoding;
    }
}
