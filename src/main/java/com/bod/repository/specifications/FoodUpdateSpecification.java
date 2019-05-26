package com.bod.repository.specifications;

import com.bod.entity.Food;
import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodUpdateSpecification implements SQLSpecification {
    private Food food;

    public FoodUpdateSpecification(Food food) {
        this.food = food;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement updateStatement = NutritionConnection.getConnection()
                .prepareStatement("UPDATE food SET name='?', number=?, " +
                        "calories=?, proteins=?, fats=?, carbohydrates=?" +
                        "WHERE id=?");

        updateStatement.setString(1, food.getName());
        updateStatement.setInt(2, food.getNumber());
        updateStatement.setDouble(3, food.getCalories());
        updateStatement.setDouble(4, food.getProtein());
        updateStatement.setDouble(5, food.getFat());
        updateStatement.setDouble(6, food.getCarbohydrates());

        return updateStatement;
    }
}
