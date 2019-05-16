package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientTest {
    private Client client;

    private int id;
    private String name;
    private String password;

    private DailyRation dailyRation;

    private DeflectionHistory deflectionHistory;
    private LocalDate birthDate;
    private GenderEnum gender;
    private double height;
    private double weight;
    private LifeStyleEnum lifeStyle;
    private NutritiveValue norm;

    @Before
    public void setUp() throws Exception {
        id = 0;
        name = "Bohdan";
        password = "1111";
        client = new Client(id, name, password);
        client.setNorm(new NutritiveValue(1716, 429, 190.6, 429));
        client.setDailyRation(new DailyRation());
        client.setDeflectionHistory(new DeflectionHistory(new NutritiveValue(1716, 429, 190.6, 429), LocalDate.of(2019, 05, 13)));
        client.setBirthDate(LocalDate.of(2000, 05, 17));
        client.setGender(GenderEnum.MALE);
        client.setHeight(165.9);
        client.setWeight(66.6);
        client.setLifeStyle(LifeStyleEnum.MINIMAL);
    }

    @Test
    public void getNorm() {
        assertEquals(new NutritiveValue(1716, 429, 190.6, 429), client.getNorm());
    }

    @Test
    public void getId() {
        assertEquals(0, client.getId());
    }

    @Test
    public void getName() {
        assertEquals("Bohdan", client.getName());
    }

    @Test
    public void getPassword() {
        assertEquals("1111", client.getPassword());
    }

    @Test
    public void getDailyRation() {
        assertNotNull(client.getDailyRation());
    }

    @Test
    public void getDeflectionHistory() {
        assertEquals(new DeflectionHistory(new NutritiveValue(1716, 429, 190.6, 429),
                        LocalDate.of(2019, 05, 13)),
                client.getDeflectionHistory()
        );

    }

    @Test
    public void getGender() {
        assertEquals(GenderEnum.MALE, client.getGender());
    }

    @Test
    public void getHeight() {
        assertEquals(165.9, client.getHeight(), 0.0);
    }

    @Test
    public void getWeight() {
        assertEquals(66.6, client.getWeight(), 0.0);
    }

    @Test
    public void getBirthDate() {
        assertEquals(LocalDate.of(2000, 05, 17), client.getBirthDate());
    }

    @Test
    public void getLifeStyle() {
        assertEquals(LifeStyleEnum.MINIMAL, client.getLifeStyle());
    }
}
