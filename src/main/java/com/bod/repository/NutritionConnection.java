package com.bod.repository;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class NutritionConnection {
    private static BasicDataSource ds = new BasicDataSource();

    private static final Logger LOG = Logger.getLogger(NutritionConnection.class);

    private static Connection conn = null;

    static {
        try (InputStream input = NutritionConnection.class.getResourceAsStream("db_connection.properties")) {
            Properties jdbcProps = new Properties();


            jdbcProps.load(input);
            LOG.info("Read JDBC properties successfully");

            ds.setDriverClassName(jdbcProps.getProperty("JDBC_DRIVER"));
            ds.setUrl(jdbcProps.getProperty("DATABASE_URL"));
            ds.setUsername(jdbcProps.getProperty("USER"));
            ds.setPassword(jdbcProps.getProperty("PASSWORD"));
            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);
            ds.setDefaultTransactionIsolation(1);
        } catch (IOException e) {
            LOG.fatal("Could not read JDBC properties from file:", e);
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = ds.getConnection();
                LOG.info("Connected to database successfully " + conn);
            } catch (SQLException e) {
                LOG.fatal("Could not connect to database server", e);
                e.printStackTrace();
                System.exit(1);
            }

        }
        return conn;
    }
}