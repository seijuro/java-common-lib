package com.github.seijuro.common.db.ctrl;

import com.github.seijuro.common.db.url.JDBCMySQLConnectionUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class JDBCMySQLController extends JDBCDatabaseController {
    //  Logger
    private static final Logger LOG = LoggerFactory.getLogger(JDBCMySQLController.class);

    /**
     * create {@link JDBCMySQLController} instance.
     *
     * @param $url
     * @return
     * @throws IllegalArgumentException
     */
    public static JDBCMySQLController create(JDBCMySQLConnectionUrl $url) throws IllegalArgumentException {
        //  check param #1
        if (Objects.isNull($url)) {
            String msg = "1st param , $url, is null.";

            //  Log (WARN)
            LOG.warn(msg);

            throw new IllegalArgumentException(msg);
        }

        return new JDBCMySQLController($url);
    }


    /**
     * C'tor
     *
     * @param $url
     */
    protected JDBCMySQLController(JDBCMySQLConnectionUrl $url) {
        super($url, $url.getUser(), $url.getPassword());
    }


}
