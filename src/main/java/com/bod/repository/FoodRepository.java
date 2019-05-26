package com.bod.repository;

import com.bod.repository.specifications.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodRepository implements EntityRepository, UpdateQuery {
    @Override
    public void createEntity(Object... args) throws SQLException {
        PreparedStatement insertFoodUnit = NutritionConnection.getConnection()
                .prepareStatement("INSERT INTO food VALUES(NULL, ?, ?, ?, ?, ?, ?)");

        insertFoodUnit.setString(1, (String) args[0]);
        insertFoodUnit.setInt(2, (Integer) args[1]);
        insertFoodUnit.setDouble(3, (Double) args[2]);
        insertFoodUnit.setDouble(4, (Double) args[3]);
        insertFoodUnit.setDouble(5, (Double) args[4]);
        insertFoodUnit.setDouble(6, (Double) args[5]);

        insertFoodUnit.execute();

        insertFoodUnit.close();

    }

    @Override
    public ResultSet readEntity(int id) throws SQLException {
        Statement readStatement = NutritionConnection.getConnection().createStatement();

        ResultSet foodUnitsResultSet = readStatement.executeQuery("SELECT * FROM food");
        readStatement.close();
        return foodUnitsResultSet;
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        PreparedStatement deleteStatement = NutritionConnection.getConnection()
                .prepareStatement("DELETE FROM food WHERE id = ?");

        deleteStatement.setInt(1, id);
        deleteStatement.execute();

        deleteStatement.close();
    }

    @Override
    public int specificUpdateQuery(SQLSpecification sqlSpecification) throws SQLException {
        Statement updateStatement = NutritionConnection.getConnection().createStatement();

        int result = sqlSpecification.toSqlClauses().executeUpdate();

        updateStatement.close();

        return result;
    }
}
