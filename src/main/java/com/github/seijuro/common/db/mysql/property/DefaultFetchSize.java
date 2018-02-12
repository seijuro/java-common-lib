package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class DefaultFetchSize extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DefaultFetchSize.class);

    public static final String PropertyName = "prepStmtCacheSqlLimit";
    public static final String DefaultValue = Integer.toString(256);

    /**
     * create {@link DefaultFetchSize} instance.
     *
     * @param size
     * @return
     */
    public static DefaultFetchSize create(String size) throws IllegalArgumentException {
        try {
            if (StringUtils.isNotEmpty(size)) {
                int value = Integer.parseInt(size);

                if (value > 0) {
                    return new DefaultFetchSize(PropertyName, size);
                }
            }
        }
        catch (NumberFormatException nfexcp) {
            nfexcp.printStackTrace();
        }

        String msg = String.format("Param, size, must be greater than 0 (size : %s, default : %s)", size, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link DefaultFetchSize} instance.
     *
     * @param size
     * @return
     */
    public static DefaultFetchSize create(int size) throws IllegalArgumentException {
        if (size > 0) {
            return new DefaultFetchSize(PropertyName, Integer.toString(size));
        }

        String msg = String.format("Param, size, must be greater than 0 (size : %d, default : %s)", size, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * C'tor
     *
     * @param $name
     * @param size
     */
    protected DefaultFetchSize(String $name, String size) {
        super($name, size);
    }
}
