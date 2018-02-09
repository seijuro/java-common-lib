package com.github.seijuro.common.db.url.property;

import lombok.AccessLevel;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * (Factory Pattern) {@link JDBCConfigurationProperty} Factory class.
 */
public class JDBCConfigurationPropertyFactory {
    /**
     * Class Properties
     */
    private static final Logger LOG = LoggerFactory.getLogger(JDBCConfigurationPropertyFactory.class);
    private static final String CreateConfigurationPropertyMethodName = "create";

    public enum Property {
        //  boolean
        AUTO_RECONNECT(AutoReconnect.class, boolean.class),
        CACHE_PREPRARED_STATEMENTS(CachePrepStmts.class, boolean.class),
        CREATE_DATABASE_IF_NOT_EXIST(CreateDatabaseIfNotExist.class, boolean.class),
        PROFILE_SQL(ProfileSQL.class, boolean.class),
        REQUIRE_SSL(RequireSSL.class, boolean.class),
        USE_SSL(UseSSL.class, boolean.class),
        USE_UNICODE(UseUnicode.class, boolean.class),
        //  String
        CHARACTER_ENCODING(CharacterEncoding.class, String.class),
        CHARACTERSET_RESULTS(CharacterSetResults.class, String.class),
        //  int
        DEFAULT_FETCH_SIZE(DefaultFetchSize.class, int.class),
        MAX_QUERYSIZE_TO_LOG(MaxQuerySizeToLog.class, int.class),
        MAX_RECONNECTS(MaxReconnects.class, int.class),
        MAX_ROWS(MaxRows.class, int.class),
        PREPARED_STATMENT_CACHE_SQL_LIMIT(PrepStmtCacheSqlLimit.class, int.class),
        //  long
        CONNECT_TIMEOUT(ConnectTimeout.class, long.class),
        SOCKET_TIMEOUT(SocketTimeout.class, long.class),
        //  others
        ZERO_DATETIME_BEHAVIOR(ZeroDateTimeBehavior.class, ZeroDateTimeBehavior.Value.class);


        @Getter(AccessLevel.PACKAGE)
        private final Class<? extends JDBCConfigurationProperty> propertyType;
        @Getter(AccessLevel.PACKAGE)
        private final Class<?> valueType;

        /**
         * C'tor
         *
         * @param $propertyType
         * @param $valueType
         */
        Property(Class<? extends JDBCConfigurationProperty> $propertyType, Class<?> $valueType) {
            this.propertyType = $propertyType;
            this.valueType = $valueType;
        }
    }

    /**
     * (Factory Pattern) method, create.
     *
     * create {@link JDBCConfigurationProperty} instance.
     * Instead of using {@link Constructor}, this will call the reserved method defined at {@param property}
     *
     * @param property
     * @param value
     * @return
     */
    public static JDBCConfigurationProperty create(Property property, Object value) throws Exception {
        Class<? extends JDBCConfigurationProperty> clazz = property.getPropertyType();

        try {
            Method mothod = clazz.getMethod(CreateConfigurationPropertyMethodName, property.getValueType());
            JDBCConfigurationProperty instance = (JDBCConfigurationProperty) mothod.invoke(null, value);

            return instance;
        }
        catch (NoSuchMethodException nsmexcp) {
            nsmexcp.printStackTrace();
        }

        return null;
    }
}
