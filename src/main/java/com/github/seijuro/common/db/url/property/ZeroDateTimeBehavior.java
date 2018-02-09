package com.github.seijuro.common.db.url.property;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@ToString
public class ZeroDateTimeBehavior implements JDBCConfigurationProperty {
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
    public static ZeroDateTimeBehavior create(ZeroDateTimeBehavior.Value behavior) {
        if (Objects.nonNull(behavior)) {
            return new ZeroDateTimeBehavior(behavior);
        }

        //  Log (WARN)
        LOG.warn("Param, behavior, is null.");

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
     * @param $behavior
     */
    protected ZeroDateTimeBehavior(Value $behavior) {
        this.propertyValue = $behavior.behavior;
    }
}
