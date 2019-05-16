package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DeflectionHistoryTest {
    private DeflectionHistory deflectionHistory;

    @Before
    public void setUp() throws Exception {
        deflectionHistory = new DeflectionHistory(new NutritiveValue(1716, 429, 190.6, 429),
                LocalDate.of(2019, 05, 13));
    }

    @Test
    public void getValue() {
        assertEquals(new NutritiveValue(1716, 429, 190.6, 429), deflectionHistory.getValue());
    }

    @Test
    public void getDate() {
        assertEquals(LocalDate.of(2019, 05, 13), deflectionHistory.getDate());
    }
}
