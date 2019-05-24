package com.bod.repository;

import com.bod.entity.Client;
import com.bod.entity.Food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class FoodHistoryRepository implements EntityRepository {
    private int historyId;
    private Food foodUnit;
    private Client client;
    private LocalDate date;


    public FoodHistoryRepository(int historyId, Food foodUnit, Client client, LocalDate date) {
        this.historyId = historyId;
        this.foodUnit = foodUnit;
        this.client = client;
        this.date = date;
    }

    @Override
    public void createEntity() {
        try {
            PreparedStatement createPreparedStatement = NutritionConnection.connection
                    .prepareStatement("INSERT INTO food_history VALUES(NULL, ?, ?, ?, ?)");

            createPreparedStatement.setInt(1, client.getId());
            createPreparedStatement.setInt(2, foodUnit.getId());
            createPreparedStatement.setDate(2, java.sql.Date.valueOf(date));

            createPreparedStatement.execute();


            createPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet readEntity() throws SQLException {
        Statement readStatement = NutritionConnection.connection.createStatement();

        return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE id=%d", historyId));
    }

    @Override
    public void deleteEntity() throws SQLException {
        Statement readStatement = NutritionConnection.connection.createStatement();

        readStatement.execute("DELETE FROM food_history WHERE id=%d", historyId);

        readStatement.close();
    }
}
