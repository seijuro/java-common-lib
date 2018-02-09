package com.github.seijuro.common.db.mysql.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
public class ZeroDateTimeBehavior extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ZeroDateTimeBehavior.class);

    public static final String PropertyName = "zeroDateTimeBehavior";
    public static final String DefaultValue = "exception";

    public enum Value {
        EXCEPTION("exception"),
        ROUND("round"),
        CONVERT_TO_NULL("convertToNull");

        /**
         * Instance Properties
         */
        @Getter
        private final String behavior;

        /**
         * C'tor
         *
         * @param $behavior
         */
        Value(String $behavior) {
            this.behavior = $behavior;
        }
    }

    /**
     * create {@link CharacterEncoding} instance.
     *
     * @param behavior
     * @return
     */
    public static ZeroDateTimeBehavior create(Object behavior) {
        if (behavior instanceof ZeroDateTimeBehavior.Value) {
            ZeroDateTimeBehavior.Value value = ZeroDateTimeBehavior.Value.class.cast(behavior);

            return new ZeroDateTimeBehavior(PropertyName, value);
        }

        //  Log (WARN)
        LOG.warn("Param, behavior, is null.");

        return null;
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $behavior
     */
    protected ZeroDateTimeBehavior(String $name, Value $behavior) {
        super($name, $behavior.behavior);
    }
}
