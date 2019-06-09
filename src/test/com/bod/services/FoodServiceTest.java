package com.bod.services;

import com.bod.entity.Food;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class FoodServiceTest {
    @Test
    public void shouldReturnFoodList() {
        List<Food> foodList = new FoodService().getFoodLIst();
        assertNotNull(foodList);
    }
}