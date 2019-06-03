package com.bod.repository;

import java.sql.*;

public class FoodHistoryRepository implements EntityRepository {
    @Override
    public void createEntity(Object... args) {
        try {
            PreparedStatement createPreparedStatement = NutritionConnection.getConnection()
                    .prepareStatement("INSERT INTO food_history VALUES(NULL, ?, ?, ?, ?)");

            createPreparedStatement.setInt(1, (Integer) args[0]);
            createPreparedStatement.setInt(2, (Integer) args[1]);
            createPreparedStatement.setDate(3, (Date) args[2]);

            createPreparedStatement.execute();


            createPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet readEntity(int historyId) throws SQLException {
        Statement readStatement = NutritionConnection.getConnection().createStatement();

        return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE id=%d", historyId));
    }

    @Override
    public void deleteEntity(int historyId) throws SQLException {
        PreparedStatement readStatement = NutritionConnection.getConnection().
                prepareStatement("DELETE FROM food_history WHERE id=?");

        readStatement.setInt(1, historyId);
        readStatement.execute();

        readStatement.close();
    }
}