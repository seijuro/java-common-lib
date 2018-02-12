package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CachePrepStmts extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CachePrepStmts.class);

    public static final String PropertyName = "cachePrepStmts";
    public static final String DefaultValue = Boolean.toString(false);

    /**
     * create {@link CachePrepStmts} instance.
     *
     * @param flag
     * @return
     */
    public static CachePrepStmts create(String flag) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(flag)) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(flag) ||
                    Boolean.FALSE.toString().equalsIgnoreCase(flag)) {
                return new CachePrepStmts(PropertyName, flag);
            }
        }

        String msg = String.format("Param, flag, is not valid (flag : %s, default : %s).", flag, DefaultValue);

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link CachePrepStmts} instance.
     *
     * @param flag
     * @return
     */
    public static CachePrepStmts create(boolean flag) {
        return new CachePrepStmts(PropertyName, Boolean.toString(flag));
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected CachePrepStmts(String $name, String $value) {
        super($name, $value);
    }
}
