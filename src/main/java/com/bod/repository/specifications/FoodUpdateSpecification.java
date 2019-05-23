package com.bod.repository.specifications;

import com.bod.entity.Food;

public class FoodUpdateSpecification implements SQLSpecification {
    private Food food;

    public FoodUpdateSpecification(Food food) {
        this.food = food;
    }

    @Override
    public String toSqlClauses() {
        return String.format(
                "UPDATE food SET " +
                        "name='%s', number=%d, calories=%f, proteins=%f, fats=%f, carbohydrates=%f" +
                        "   WHERE id=?",
                food.getName(), food.getNumber(), food.getCalories(), food.getProtein(),
                food.getFat(), food.getCarbohydrates()
        );
    }
}
