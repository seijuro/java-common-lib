package com.github.seijuro.common.db.mysql.property;

import com.github.seijuro.common.db.JDBCConfigurationProperty;
import com.github.seijuro.common.db.mysql.property.*;
import org.junit.Assert;
import org.junit.Test;

public class MySQLJDBCConfigurationPropertyFactoryTest {
    @Test
    public void testFactoryCreateBooleanTypeProperty() {
        try {
            JDBCConfigurationProperty property;

            //  AutoReconnect
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.AUTO_RECONNECT, true);

                Assert.assertTrue(property instanceof AutoReconnect);
                Assert.assertEquals(Boolean.toString(true), property.getPropertyValue());
                Assert.assertEquals("autoReconnect", property.getPropertyName());

                System.out.println("Testing a configuration property 'auto reconnect' ... [OK]");
                System.out.println("property : " + property);
            }

            //  CachePrepStmts
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.CACHE_PREPRARED_STATEMENTS, false);

                Assert.assertTrue(property instanceof CachePrepStmts);
                Assert.assertEquals(Boolean.toString(false), property.getPropertyValue());
                Assert.assertEquals("cachePrepStmts", property.getPropertyName());

                System.out.println("Testing a configuration property 'cache prepared statements' ... [OK]");
                System.out.println("property : " + property);
            }

            //  CreateDatabaseIfNotExist
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.CREATE_DATABASE_IF_NOT_EXIST, true);

                Assert.assertTrue(property instanceof CreateDatabaseIfNotExist);
                Assert.assertEquals(Boolean.toString(true), property.getPropertyValue());
                Assert.assertEquals("createDatabaseIfNotExist", property.getPropertyName());

                System.out.println("Testing a configuration property 'create database if not exists' ...  [OK]");
                System.out.println("property : " + property);
            }

            //  ProfileSQL
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.PROFILE_SQL, false);

                Assert.assertTrue(property instanceof ProfileSQL);
                Assert.assertEquals(Boolean.toString(false), property.getPropertyValue());
                Assert.assertEquals("profileSQL", property.getPropertyName());

                System.out.println("Testing a configuration property 'profile sql' ... [OK]");
                System.out.println("property : " + property);
            }

            //  RequireSSL
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.REQUIRE_SSL, true);

                Assert.assertTrue(property instanceof RequireSSL);
                Assert.assertEquals(Boolean.toString(true), property.getPropertyValue());
                Assert.assertEquals("requireSSL", property.getPropertyName());

                System.out.println("Testing a configuration property 'require SSL' ... [OK]");
                System.out.println("property : " + property);
            }

            //  UseSSL
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.USE_SSL, false);

                Assert.assertTrue(property instanceof UseSSL);
                Assert.assertEquals(Boolean.toString(false), property.getPropertyValue());
                Assert.assertEquals("useSSL", property.getPropertyName());

                System.out.println("Testing a configuration property 'use SSL' ... [OK]");
                System.out.println("property : " + property);
            }


            //  Use Unicode
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.USE_UNICODE, true);

                Assert.assertTrue(property instanceof UseUnicode);
                Assert.assertEquals(Boolean.toString(true), property.getPropertyValue());
                Assert.assertEquals("useUnicode", property.getPropertyName());

                System.out.println("Testing a configuration property 'use unicode' ... [OK]");
                System.out.println("property : " + property);
            }

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        Assert.fail();
    }

    @Test
    public void testFactoryCreateStringTypeProperty() {
        try {
            JDBCConfigurationProperty property;

            //  charset encoding
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.CHARACTER_ENCODING, "cp949");

                Assert.assertTrue(property instanceof CharacterEncoding);
                Assert.assertEquals("cp949", property.getPropertyValue());
                Assert.assertEquals("characterEncoding", property.getPropertyName());

                System.out.println("Testing a configuration property 'character encoding' ... [OK]");
            }

            //  charset results
            {
                property = MySQLJDBCConfigurationPropertyFactory.create(MySQLJDBCConfigurationPropertyFactory.Property.CHARACTERSET_RESULTS, "utf8");

                Assert.assertTrue(property instanceof CharacterSetResults);
                Assert.assertEquals("utf8", property.getPropertyValue());
                Assert.assertEquals("characterSetResults", property.getPropertyName());

                System.out.println("Testing a configuration property 'character results' ... [OK]");
            }

            return;
        }
        catch (Exception excp) {
            excp.printStackTrace();
        }

        Assert.fail();
    }
}
