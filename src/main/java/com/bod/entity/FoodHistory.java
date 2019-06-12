package com.bod.entity;

import java.time.LocalDate;
import java.util.Map;

public class FoodHistory {
    private int client_id;
    private Map<Integer, Double> foodIds;
    private LocalDate date;

    public FoodHistory(int client_id, Map<Integer, Double> foodIds, LocalDate date) {
        this.client_id = client_id;
        this.foodIds = foodIds;
        this.date = date;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Map<Integer, Double> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(Map<Integer, Double> foodIds) {
        this.foodIds = foodIds;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
