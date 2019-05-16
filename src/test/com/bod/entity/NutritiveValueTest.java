package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NutritiveValueTest {
    private NutritiveValue nutritiveValue;

    @Before
    public void setUp() throws Exception {
        nutritiveValue = new NutritiveValue(1716, 429, 190.6, 429);
    }

    @Test
    public void getCalories() {
        assertEquals(1716, nutritiveValue.getCalories(), 0.0);
    }

    @Test
    public void getProtein() {
        assertEquals(429, nutritiveValue.getProtein(), 0.0);
    }

    @Test
    public void getFat() {
        assertEquals(190.6, nutritiveValue.getFat(), 0.0);
    }

    @Test
    public void getCarbohydrates() {
        assertEquals(429, nutritiveValue.getCarbohydrates(), 0.0);
    }

    @Test
    public void subtract() {
        NutritiveValue subtrahend = new NutritiveValue(1716, 429, 190.6, 429);
        NutritiveValue result = nutritiveValue.subtract(subtrahend);

        assertEquals(new NutritiveValue(0, 0, 0, 0), result);
    }

    @Test
    public void add() {
        NutritiveValue adder = new NutritiveValue(1, 1, 1, 1);
        nutritiveValue = nutritiveValue.add(adder);

        assertEquals(new NutritiveValue(1717, 430, 191.6, 430), nutritiveValue);
    }
}