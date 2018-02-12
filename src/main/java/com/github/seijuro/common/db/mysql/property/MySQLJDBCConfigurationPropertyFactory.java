package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import com.github.seijuro.common.util.UnaryCreatable;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.util.function.Function;

/**
 * (Factory Method Pattern) {@link JDBCConfigurationProperty} Factory Method class.
 */
public class MySQLJDBCConfigurationPropertyFactory {
    public enum Property {
        //  boolean
        AUTO_RECONNECT(AutoReconnect.PropertyName, AutoReconnect::create),
        CACHE_PREPRARED_STATEMENTS(CachePrepStmts.PropertyName, CachePrepStmts::create),
        CREATE_DATABASE_IF_NOT_EXIST(CreateDatabaseIfNotExist.PropertyName, CreateDatabaseIfNotExist::create),
        PROFILE_SQL(ProfileSQL.PropertyName, ProfileSQL::create),
        REQUIRE_SSL(RequireSSL.PropertyName, RequireSSL::create),
        USE_SSL(UseSSL.PropertyName, UseSSL::create),
        USE_UNICODE(UseUnicode.PropertyName, UseUnicode::create),
        USE_COMPRESSION(UseCompression.PropertyName, UseCompression::create),
        //  String
        CHARACTER_ENCODING(CharacterEncoding.PropertyName, CharacterEncoding::create),
        CHARACTERSET_RESULTS(CharacterSetResults.PropertyName, CharacterSetResults::create),
        //  int
        DEFAULT_FETCH_SIZE(DefaultFetchSize.PropertyName, DefaultFetchSize::create),
        MAX_QUERYSIZE_TO_LOG(MaxQuerySizeToLog.PropertyName, MaxQuerySizeToLog::create),
        MAX_RECONNECTS(MaxReconnects.PropertyName, MaxReconnects::create),
        MAX_ROWS(MaxRows.PropertyName, MaxRows::create),
        PREPARED_STATMENT_CACHE_SQL_LIMIT(PrepStmtCacheSqlLimit.PropertyName, PrepStmtCacheSqlLimit::create),
        //  long
        CONNECT_TIMEOUT(ConnectTimeout.PropertyName, ConnectTimeout::create),
        SOCKET_TIMEOUT(SocketTimeout.PropertyName, SocketTimeout::create),
        //  others
        ZERO_DATETIME_BEHAVIOR(ZeroDateTimeBehavior.PropertyName, ZeroDateTimeBehavior::create);

        /**
         * Instance Properties
         */
        @Getter
        private final String propertyName;
        @Getter
        private final UnaryCreatable<String, MySQLJDBCConfigurationProperty> func;

        /**
         * C'tor
         *
         * @param $propertyName
         * @param $func
         */
        Property(String $propertyName, UnaryCreatable<String, MySQLJDBCConfigurationProperty> $func) {
            this.propertyName = $propertyName;
            this.func = $func;
        }
    }

    /**
     * Class Properties
     */
    private static final Logger LOG = LoggerFactory.getLogger(MySQLJDBCConfigurationPropertyFactory.class);

    /**
     * (Factory Pattern) method, create.
     *
     * create {@link JDBCConfigurationProperty} instance.
     * Instead of using {@link Constructor}, this will call the reserved method defined at {@param property}
     *
     * @param creator
     * @param value
     * @return
     */
    public static MySQLJDBCConfigurationProperty create(Property creator, String value) throws IllegalArgumentException {
        return creator.func.apply(value);
    }

    /**
     * (Factory Pattern) method, create.
     *
     * create {@link JDBCConfigurationProperty} instance.
     * Instead of using {@link Constructor}, this will call the reserved method defined at {@param property}
     *
     * @param propertyName
     * @param value
     * @return
     */
    public static MySQLJDBCConfigurationProperty create(String propertyName, String value) throws IllegalArgumentException {
        String trimmed = StringUtils.stripToEmpty(propertyName);

        for (Property property : Property.values()) {
            if (property.getPropertyName().equalsIgnoreCase(trimmed)) {
                return create(property, value);
            }
        }

        return null;
    }
}
