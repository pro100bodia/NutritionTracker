package com.bod.repository;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class NutritionConnection {
    static Connection connection;

    public static void establishConnection() throws ClassNotFoundException, SQLException {

        try (InputStream input = NutritionConnection.class.getClassLoader().getResourceAsStream("jdbcProperties.properties")) {
            Properties jdbcProps = new Properties();


            jdbcProps.load(input);

            String JDBC_DRIVER = jdbcProps.getProperty("JDBC_DRIVER");
            String DATABASE_URL = jdbcProps.getProperty("DATABASE_URL");
            String USER = jdbcProps.getProperty("USER");
            String PASSWORD = jdbcProps.getProperty("PASSWORD");

            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
