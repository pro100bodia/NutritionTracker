package com.bod.services;

import com.bod.entity.FoodHistory;
import com.bod.repository.FoodHistoryRepository;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.sql.SQLException;

public class DailyService {
    private static final Logger LOG = Logger.getLogger(DailyService.class);

    public void writeToFoodHistory(FoodHistory foodHistory) {
        FoodHistoryRepository repo = new FoodHistoryRepository();

        Object[] args = new Object[4];

        for (Integer foodId : foodHistory.getFoodIds().keySet()) {
            args[0] = foodHistory.getClient_id();
            args[1] = foodId;
            args[2] = foodHistory.getFoodIds().get(foodId);
            args[3] = Date.valueOf(foodHistory.getDate());

            try {
                repo.createEntity(args);
                LOG.info("Write plate to database successfully");
            } catch (SQLException e) {
                LOG.error("Failed to write plate to database");
            }
        }
    }
}
