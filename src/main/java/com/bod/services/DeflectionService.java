package com.bod.services;

import com.bod.entity.DeflectionHistory;
import com.bod.repository.DeflectionHistoryRepository;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.sql.SQLException;

public class DeflectionService {
    private static final Logger LOG = Logger.getLogger(DeflectionService.class);

    public void writeDeflection(DeflectionHistory history) {
        DeflectionHistoryRepository repo = new DeflectionHistoryRepository();

        Object[] args = new Object[6];
        args[0] = history.getClientId();
        args[1] = Date.valueOf(history.getDate());
        args[2] = history.getValue().getCalories();
        args[3] = history.getValue().getProtein();
        args[4] = history.getValue().getFat();
        args[5] = history.getValue().getCarbohydrates();

        try {
            repo.createEntity(args);
            LOG.info("Write deflection to database successfully");
        } catch (SQLException e) {
            LOG.error("Fail to write deflection to database");
        }
    }
}
