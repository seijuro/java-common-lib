package com.github.seijuro.common.db.mysql.property;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CachePrepStmts extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CachePrepStmts.class);

    public static final String PropertyName = "cachePrepStmts";
    public static final boolean DefaultValue = false;

    /**
     * create {@link CachePrepStmts} instance.
     *
     * @param flag
     * @return
     */
    public static CachePrepStmts create(Object flag) {
        if (flag instanceof Boolean) {
            return new CachePrepStmts(PropertyName, Boolean.class.cast(flag));
        }

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $value
     */
    protected CachePrepStmts(String $name, boolean $value) {
        super($name, Boolean.toString($value));
    }
}
