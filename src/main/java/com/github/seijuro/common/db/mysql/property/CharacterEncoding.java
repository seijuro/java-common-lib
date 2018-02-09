package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CharacterEncoding extends MySQLJDBCConfigurationProperty {
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
            return new CharacterEncoding(PropertyName, String.class.cast(encoding));
        }

        //  Log (WARN)
        LOG.warn("Param, encoding, is empty (default : {}).", DefaultValue);

        return null;
    }

    /**
     * C'tor
     *
     * @param encoding
     */
    protected CharacterEncoding(String $name, String encoding) {
        super($name, encoding);
    }
}
