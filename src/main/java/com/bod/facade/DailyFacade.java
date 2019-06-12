package com.bod.facade;

import com.bod.entity.DailyRation;
import com.bod.entity.Food;
import com.bod.entity.FoodHistory;
import com.bod.services.DailyService;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class DailyFacade {
    public void writeToFoodHistory(DailyRation ration, int client_id) {
        Map<Integer, Double> foodIds = new LinkedHashMap<>();
        Map<Food, Double> foodMap = ration.getFoodMap();
        for (Food food : foodMap.keySet()) {
            foodIds.put(food.getId(), foodMap.get(food));
        }

        FoodHistory foodHistrory = new FoodHistory(client_id, foodIds, LocalDate.now());

        DailyService dailyService = new DailyService();
        dailyService.writeToFoodHistory(foodHistrory);
    }
}
