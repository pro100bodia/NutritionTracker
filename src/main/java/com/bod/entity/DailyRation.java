package com.bod.entity;

import java.util.ArrayList;
import java.util.List;

public class DailyRation {
    private List<Food> foodList;
    private NutritiveValue eaten;

    public DailyRation() {
        foodList = new ArrayList<>();
        eaten = new NutritiveValue(0, 0, 0, 0);
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void accumulateEaten() {

        for (Food f : foodList) {
            eaten = eaten.add(f.getValue());
        }
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public NutritiveValue getEaten() {
        return eaten;
    }
}
