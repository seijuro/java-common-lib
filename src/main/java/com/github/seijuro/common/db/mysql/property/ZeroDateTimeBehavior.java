package com.github.seijuro.common.db.mysql.property;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@ToString
public class ZeroDateTimeBehavior extends MySQLJDBCConfigurationProperty {
    /**
     * Class Instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ZeroDateTimeBehavior.class);

    public static final String PropertyName = "zeroDateTimeBehavior";
    public static final String DefaultValue = "exception";

    public enum Behaviors {
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
        Behaviors(String $behavior) {
            this.behavior = $behavior;
        }
    }

    /**
     * create {@link CharacterEncoding} instance.
     *
     * @param $behavior
     * @return
     * @throws IllegalArgumentException
     */
    public static ZeroDateTimeBehavior create(String $behavior) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty($behavior)) {
            for (Behaviors behavior : Behaviors.values()) {
                behavior.getBehavior().equalsIgnoreCase($behavior);

                return new ZeroDateTimeBehavior(PropertyName, behavior.behavior);
            }
        }

        String msg = String.format("Param, behavior, must be one of {%s, %s, %s}.", Behaviors.EXCEPTION.getBehavior(), Behaviors.ROUND.getBehavior(), Behaviors.CONVERT_TO_NULL.getBehavior());

        //  Log (WARN)
        LOG.warn(msg);

        throw new IllegalArgumentException(msg);
    }

    /**
     * create {@link CharacterEncoding} instance.
     *
     * @param behavior
     * @return
     * @throws IllegalArgumentException
     */
    public static ZeroDateTimeBehavior create(Behaviors behavior) throws IllegalArgumentException {
        if (Objects.nonNull(behavior)) {
            return new ZeroDateTimeBehavior(PropertyName, behavior.behavior);
        }

        throw new IllegalArgumentException("Param, behavior, must not be null.");
    }

    /**
     * C'tor
     *
     * @param $name
     * @param $behavior
     */
    protected ZeroDateTimeBehavior(String $name, String $behavior) {
        super($name, $behavior);
    }
}
