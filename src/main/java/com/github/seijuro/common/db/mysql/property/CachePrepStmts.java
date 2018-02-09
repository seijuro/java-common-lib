package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class CachePrepStmts implements JDBCConfigurationProperty {
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
            return new CachePrepStmts(Boolean.class.cast(flag));
        }

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
     * @param $value
     */
    protected CachePrepStmts(boolean $value) {
        this.propertyValue = Boolean.toString($value);
    }
}
