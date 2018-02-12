package com.github.seijuro.common.db.mysql;

import com.github.seijuro.common.db.JDBCDatabaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class MySQLJDBCController extends JDBCDatabaseController {
    //  Logger
    private static final Logger LOG = LoggerFactory.getLogger(MySQLJDBCController.class);

    /**
     * create {@link MySQLJDBCController} instance.
     *
     * @param $url
     * @return
     * @throws IllegalArgumentException
     */
    public static MySQLJDBCController create(MySQLJDBCConnectionUrl $url) throws IllegalArgumentException {
        //  check param #1
        if (Objects.isNull($url)) {
            String msg = "1st param , $url, is null.";

            //  Log (WARN)
            LOG.warn(msg);

            throw new IllegalArgumentException(msg);
        }

        return new MySQLJDBCController($url);
    }


    /**
     * C'tor
     *
     * @param $url
     */
    protected MySQLJDBCController(MySQLJDBCConnectionUrl $url) {
        super($url, $url.getUser(), $url.getPassword());
    }
}
