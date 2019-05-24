package com.bod.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DeflectionHistoryRepository implements EntityRepository {
    private int id;
    private int clientId;
    private LocalDate date;
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;


    @Override
    public void createEntity() throws SQLException {
        PreparedStatement createPreparedStatement = NutritionConnection.connection
                .prepareStatement("INSERT INTO deflection_history" +
                        " VALUES(NULL, ?, ?, ?, ?, ?, ?)");

        createPreparedStatement.setInt(1, clientId);
        createPreparedStatement.setDate(2, java.sql.Date.valueOf(date));
        createPreparedStatement.setDouble(3, calories);
        createPreparedStatement.setDouble(4, proteins);
        createPreparedStatement.setDouble(5, fats);
        createPreparedStatement.setDouble(6, carbohydrates);

        createPreparedStatement.execute();

        createPreparedStatement.close();
    }

    @Override
    public ResultSet readEntity() throws SQLException {
        Statement readStatement = NutritionConnection.connection.createStatement();

        return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE id=%d", id));
    }

    @Override
    public void deleteEntity() throws SQLException {
        Statement deleteStatement = NutritionConnection.connection.createStatement();

        deleteStatement.execute("DELETE FROM food_history WHERE id=%d", id);

        deleteStatement.close();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
