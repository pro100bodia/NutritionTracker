package com.bod.repository;


import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class NutritionConnection {
    static Connection connection;

    private static BasicDataSource ds = new BasicDataSource();

    static {
        try (InputStream input = NutritionConnection.class.getClassLoader().getResourceAsStream("db_connection.properties")) {
            Properties jdbcProps = new Properties();


            jdbcProps.load(input);

            ds.setUrl(jdbcProps.getProperty("DATABASE_URL"));
            ds.setUsername(jdbcProps.getProperty("USER"));
            ds.setPassword(jdbcProps.getProperty("PASSWORD"));
            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
