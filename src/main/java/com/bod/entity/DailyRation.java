package com.bod.entity;

import java.util.ArrayList;
import java.util.List;

public class DailyRation {
    private int id;
    private List<Food> foodList;
    private NutritiveValue eaten;

    public DailyRation() {
        foodList = new ArrayList<>();
        eaten = new NutritiveValue(0, 0, 0, 0);
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public int getId() {
        return id;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public NutritiveValue getEaten() {
        return eaten;
    }
}
