package com.github.seijuro.common.config;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class ConfigReaderTest {
    enum TestConfig1 {
        db_config1,
        db_config2,
        db_config3,
        db_config4,
        db_config5;
    }

    enum AppConfig1 {
        app_config1,
        app_config2,
        app_config3,
        app_config4,
        app_config5;
    }

    public class TestDBConfigReader extends ConfigReader<TestConfig1> {
        /**
         * C'tor
         *
         * @param $clazz
         */
        protected TestDBConfigReader(Class<TestConfig1> $clazz) {
            super($clazz);
        }
    }

    public class TestAppConfigReader extends ConfigReader<AppConfig1> {
        /**
         * C'tor
         *
         * @param $clazz
         */
        protected TestAppConfigReader(Class<AppConfig1> $clazz) {
            super($clazz);
        }
    }


    @Test
    public void testConfigReader1() {
         TestDBConfigReader dbConfigReader = new TestDBConfigReader(TestConfig1.class);

         try {
             URL url = getClass().getResource("src/test/resources/test-db.conf");

             if (Objects.nonNull(url)) {
                 Map<TestConfig1, String> configs = dbConfigReader.read(Paths.get(url.toURI()));

                 for (Map.Entry<TestConfig1, String> config : configs.entrySet()) {
                     config.getKey();
                     config.getValue();
                 }
             }
         }
         catch (URISyntaxException sexcp) {
             sexcp.printStackTrace();
         }
         catch (IOException ioexcp) {
             ioexcp.printStackTrace();
         }
    }

    @Test
    public void testConfigReader2() {
        TestAppConfigReader appConfigReader = new TestAppConfigReader(AppConfig1.class);

        try {
            URL url = getClass().getResource("src/test/resources/test-app.conf");

            if (Objects.nonNull(url)) {
                Map<AppConfig1, String> configs = appConfigReader.read(Paths.get(url.toURI()));

                for (Map.Entry<AppConfig1, String> config : configs.entrySet()) {
                    config.getKey();
                    config.getValue();
                }
            }
        }
        catch (URISyntaxException sexcp) {
            sexcp.printStackTrace();
        }
        catch (IOException ioexcp) {
            ioexcp.printStackTrace();
        }
    }
}
