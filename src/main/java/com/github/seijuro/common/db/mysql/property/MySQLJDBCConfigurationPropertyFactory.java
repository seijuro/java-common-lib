package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import com.github.seijuro.common.util.UnaryCreatable;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.util.function.Function;

/**
 * (Factory Method Pattern) {@link JDBCConfigurationProperty} Factory Method class.
 */
public class MySQLJDBCConfigurationPropertyFactory {
    public enum Property implements UnaryCreatable<Object, JDBCConfigurationProperty> {
        //  boolean
        AUTO_RECONNECT(AutoReconnect::create),
        CACHE_PREPRARED_STATEMENTS(CachePrepStmts::create),
        CREATE_DATABASE_IF_NOT_EXIST(CreateDatabaseIfNotExist::create),
        PROFILE_SQL(ProfileSQL::create),
        REQUIRE_SSL(RequireSSL::create),
        USE_SSL(UseSSL::create),
        USE_UNICODE(UseUnicode::create),
        //  String
        CHARACTER_ENCODING(CharacterEncoding::create),
        CHARACTERSET_RESULTS(CharacterSetResults::create),
        //  int
        DEFAULT_FETCH_SIZE(DefaultFetchSize::create),
        MAX_QUERYSIZE_TO_LOG(MaxQuerySizeToLog::create),
        MAX_RECONNECTS(MaxReconnects::create),
        MAX_ROWS(MaxRows::create),
        PREPARED_STATMENT_CACHE_SQL_LIMIT(PrepStmtCacheSqlLimit::create),
        //  long
        CONNECT_TIMEOUT(ConnectTimeout::create),
        SOCKET_TIMEOUT(SocketTimeout::create),
        //  others
        ZERO_DATETIME_BEHAVIOR(ZeroDateTimeBehavior::create);

        /**
         * Instance Properties
         */
        @Getter
        private final Function<Object, JDBCConfigurationProperty> func;

        @Override
        public JDBCConfigurationProperty apply(Object obj) throws IllegalArgumentException {
            return func.apply(obj);
        }

        /**
         * C'tor
         *
         * @param $func
         */
        Property(Function<Object, JDBCConfigurationProperty> $func) {
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
    public static JDBCConfigurationProperty create(Property creator, Object value) throws Exception {
        return creator.apply(value);
    }
}
