package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodTest {
    private Food egg;

    @Before
    public void setUp() throws Exception {
        egg = new Food();
        egg.setName("chicken egg");
        egg.setNumber(100);
        egg.setCalories(144);
        egg.setProtein(12.7);
        egg.setFat(10.7);
        egg.setCarbohydrates(0.8);
        egg.setAmount(200);
    }

    @Test
    public void getValue() {
        assertEquals(new NutritiveValue(2 * 144, 2 * 12.7, 2 * 10.7, 2 * 0.8),
                egg.getValue());
    }

    @Test
    public void getName() {
        assertEquals("chicken egg", egg.getName());
    }

    @Test
    public void getAmount() {
        assertEquals(200, egg.getAmount(), 0.0);
    }

    @Test
    public void getNumber() {
        assertEquals(100, egg.getNumber());
    }

    @Test
    public void getCalories() {
        assertEquals(144, egg.getCalories(), 0.0);
    }

    @Test
    public void getProtein() {
        assertEquals(12.7, egg.getProtein(), 0.0);
    }

    @Test
    public void getFat() {
        assertEquals(10.7, egg.getFat(), 0.0);
    }

    @Test
    public void getCarbohydrates() {
        assertEquals(0.8, egg.getCarbohydrates(), 0.0);
    }
}