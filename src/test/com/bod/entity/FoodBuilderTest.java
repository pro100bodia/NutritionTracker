package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodBuilderTest {
    private Food food;
    private FoodBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new FoodBuilder();
        builder.reset();
        builder.setName("chicken egg");
        builder.setNumber(100);
        builder.setCalories(144);
        builder.setProteins(12.7);
        builder.setFats(10.7);
        builder.setCarbohydrates(0.8);
        builder.setAmount(200);
        food = builder.getResult();
    }

    @Test
    public void getResult() {
        Food egg = new Food();
        egg.setName("chicken egg");
        egg.setNumber(100);
        egg.setCalories(144);
        egg.setProtein(12.7);
        egg.setFat(10.7);
        egg.setCarbohydrates(0.8);
        egg.setAmount(200);

        assertEquals(egg, food);
    }
}