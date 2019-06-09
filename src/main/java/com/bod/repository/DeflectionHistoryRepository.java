package com.bod.repository;

import com.bod.entity.Databaseable;

import java.sql.*;

public class DeflectionHistoryRepository implements EntityRepository {
    @Override
    public void createEntity(Object... args) throws SQLException {
        PreparedStatement createPreparedStatement = NutritionConnection.getConnection()
                .prepareStatement("INSERT INTO deflection_history" +
                        " VALUES(NULL, ?, ?, ?, ?, ?, ?)");

        createPreparedStatement.setInt(1, (Integer) args[0]);
        createPreparedStatement.setDate(2, (Date) args[1]);
        createPreparedStatement.setDouble(3, (Double) args[2]);
        createPreparedStatement.setDouble(4, (Double) args[3]);
        createPreparedStatement.setDouble(5, (Double) args[4]);
        createPreparedStatement.setDouble(6, (Double) args[5]);

        createPreparedStatement.execute();

        createPreparedStatement.close();
    }

    @Override
    public ResultSet readEntity(int id) throws SQLException {
        Statement readStatement = NutritionConnection.getConnection().createStatement();

        return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE id=%d", id));
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        PreparedStatement deleteStatement = NutritionConnection.getConnection()
                .prepareStatement("DELETE FROM food_history WHERE id=?");

        deleteStatement.setInt(1, id);
        deleteStatement.execute();

        deleteStatement.close();
    }

    @Override
    public int updateEntity(Databaseable entity) throws SQLException {
        return 0;
    }
}
