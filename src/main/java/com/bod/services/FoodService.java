package com.bod.services;

import com.bod.entity.Food;
import com.bod.repository.FoodRepository;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodService {
    private static final Logger LOG = Logger.getLogger(FoodService.class);

    public List<Food> getFoodLIst() {
        List<Food> foodList = null;

        try {
            ResultSet resultSet = new FoodRepository().readEntity(0);
            LOG.info("Get food list successfully");

            foodList = new ArrayList<>();
            Food foodUnit;
            while (resultSet.next()) {
//                System.out.println("First resultSet value: " + resultSet.getInt(1));
//                System.out.println("First resultSet value: " + resultSet.getString(2));
//                System.out.println("First resultSet value: " + resultSet.getInt(3));
//                System.out.println("First resultSet value: " + resultSet.getInt(4));
//                System.out.println("First resultSet value: " + resultSet.getDouble(5));
//                System.out.println("First resultSet value: " + resultSet.getDouble(6));
//                System.out.println("First resultSet value: " + resultSet.getInt(7));
//                System.out.println("-----------------------------------");

                foodUnit = new Food();
                foodUnit.setId(resultSet.getInt(1));
                foodUnit.setName(resultSet.getString(2));
                foodUnit.setNumber(resultSet.getInt(3));
                foodUnit.setCalories(resultSet.getInt(4));
                foodUnit.setProtein(resultSet.getDouble(5));
                foodUnit.setFat(resultSet.getDouble(6));
                foodUnit.setCarbohydrates(resultSet.getInt(7));

                foodList.add(foodUnit);
            }
        } catch (SQLException e) {
            LOG.error("Failed to get a food list\n" + e);
            e.printStackTrace();
        }
        return foodList;
    }
}
