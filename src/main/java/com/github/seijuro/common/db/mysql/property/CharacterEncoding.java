package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
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
    public static CharacterEncoding create(String encoding) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(encoding)) {
            return new CharacterEncoding(PropertyName, String.class.cast(encoding));
        }

        String msg = String.format("Param, encoding, is empty (default : {}).", DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
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
