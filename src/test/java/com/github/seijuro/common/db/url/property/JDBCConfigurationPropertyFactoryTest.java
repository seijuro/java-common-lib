package com.github.seijuro.common.db.url.property;

import org.junit.Assert;
import org.junit.Test;

public class JDBCConfigurationPropertyFactoryTest {
    @Test
    public void testFactoryCreateBooleanTypeProperty() {
        try {
            JDBCConfigurationProperty property;

            //  AutoReconnect
            {
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.AUTO_RECONNECT, true);

                Assert.assertTrue(property instanceof AutoReconnect);
                Assert.assertEquals(Boolean.toString(true), property.getPropertyValue());
                Assert.assertEquals("autoReconnect", property.getPropertyName());

                System.out.println("Testing a configuration property 'auto reconnect' ... [OK]");
            }

            //  CachePrepStmts
            {
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.CACHE_PREPRARED_STATEMENTS, false);

                Assert.assertTrue(property instanceof CachePrepStmts);
                Assert.assertEquals(Boolean.toString(false), property.getPropertyValue());
                Assert.assertEquals("cachePrepStmts", property.getPropertyName());

                System.out.println("Testing a configuration property 'cache prepared statements' ... [OK]");
            }

            //  CreateDatabaseIfNotExist
            {
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.CREATE_DATABASE_IF_NOT_EXIST, true);

                Assert.assertTrue(property instanceof CreateDatabaseIfNotExist);
                Assert.assertEquals(Boolean.toString(true), property.getPropertyValue());
                Assert.assertEquals("createDatabaseIfNotExist", property.getPropertyName());

                System.out.println("Testing a configuration property 'create database if not exists' ...  [OK]");
            }

            //  ProfileSQL
            {
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.PROFILE_SQL, false);

                Assert.assertTrue(property instanceof ProfileSQL);
                Assert.assertEquals(Boolean.toString(false), property.getPropertyValue());
                Assert.assertEquals("profileSQL", property.getPropertyName());

                System.out.println("Testing a configuration property 'profile sql' ... [OK]");
            }

            //  RequireSSL
            {
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.REQUIRE_SSL, true);

                Assert.assertTrue(property instanceof RequireSSL);
                Assert.assertEquals(Boolean.toString(true), property.getPropertyValue());
                Assert.assertEquals("requireSSL", property.getPropertyName());

                System.out.println("Testing a configuration property 'require SSL' ... [OK]");
            }

            //  UseSSL
            {
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.USE_SSL, false);

                Assert.assertTrue(property instanceof UseSSL);
                Assert.assertEquals(Boolean.toString(false), property.getPropertyValue());
                Assert.assertEquals("useSSL", property.getPropertyName());

                System.out.println("Testing a configuration property 'use SSL' ... [OK]");
            }


            //  Use Unicode
            {
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.USE_UNICODE, true);

                Assert.assertTrue(property instanceof UseUnicode);
                Assert.assertEquals(Boolean.toString(true), property.getPropertyValue());
                Assert.assertEquals("useUnicode", property.getPropertyName());

                System.out.println("Testing a configuration property 'use unicode' ... [OK]");
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
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.CHARACTER_ENCODING, "cp949");

                Assert.assertTrue(property instanceof CharacterEncoding);
                Assert.assertEquals("cp949", property.getPropertyValue());
                Assert.assertEquals("characterEncoding", property.getPropertyName());

                System.out.println("Testing a configuration property 'character encoding' ... [OK]");
            }

            //  charset results
            {
                property = JDBCConfigurationPropertyFactory.create(JDBCConfigurationPropertyFactory.Property.CHARACTERSET_RESULTS, "utf8");

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
