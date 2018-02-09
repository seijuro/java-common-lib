package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CharacterEncoding implements JDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CharacterEncoding.class);

    public static final String PropertyName = "characterEncoding";
    public static final String DefaultValue = "autodetect";

    /**
     * create {@link CharacterEncoding} instance.
     *
     * @param encoding
     * @return
     */
    public static CharacterEncoding create(Object encoding) {
        if (encoding instanceof String) {
            return new CharacterEncoding(String.class.cast(encoding));
        }

        //  Log (WARN)
        LOG.warn("Param, encoding, is empty (default : {}).", DefaultValue);

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
    protected CharacterEncoding(String encoding) {
        this.propertyValue = encoding;
    }
}
