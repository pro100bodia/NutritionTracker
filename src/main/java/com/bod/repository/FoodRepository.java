package com.bod.repository;

import com.bod.entity.Food;
import com.bod.repository.specifications.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodRepository implements EntityRepository, UpdateQuery {
    private Food foodUnit;

    public FoodRepository(Food foodUnit) {
        this.foodUnit = foodUnit;
    }

    @Override
    public void createEntity() throws SQLException {
        PreparedStatement insertFoodUnit = NutritionConnection.connection
                .prepareStatement("INSERT INTO food VALUES(NULL, ?, ?, ?, ?, ?, ?)");

        insertFoodUnit.setString(1, foodUnit.getName());//name
        insertFoodUnit.setInt(2, foodUnit.getNumber());//number
        insertFoodUnit.setDouble(3, foodUnit.getCalories());//calories
        insertFoodUnit.setDouble(4, foodUnit.getProtein());//proteins
        insertFoodUnit.setDouble(5, foodUnit.getFat());//fats
        insertFoodUnit.setDouble(6, foodUnit.getCarbohydrates());//carbohydrates

        insertFoodUnit.execute();

        insertFoodUnit.close();

    }

    @Override
    public ResultSet readEntity() throws SQLException {
        Statement readStatement = NutritionConnection.connection.createStatement();

        ResultSet foodUnitsResultSet = readStatement.executeQuery("SELECT * FROM food");
        readStatement.close();
        return foodUnitsResultSet;
    }

    @Override
    public void deleteEntity() throws SQLException {
        PreparedStatement deleteStatement = NutritionConnection.connection
                .prepareStatement("DELETE FROM food WHERE id = ?");

        deleteStatement.setInt(1, foodUnit.getId());
        deleteStatement.execute();

        deleteStatement.close();
    }

    @Override
    public int specificUpdateQuery(SQLSpecification sqlSpecification) throws SQLException {
        Statement updateStatement = NutritionConnection.connection.createStatement();

        int result = updateStatement.executeUpdate(sqlSpecification.toSqlClauses());

        updateStatement.close();

        return result;
    }
}
