//package com.bod.entity;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.LocalDate;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class ClientTest {
//    private Client client;
//
//    private int id;
//    private String name;
//    private String password;
//
//    private DailyRation dailyRation;
//
//    private DeflectionRecord deflectionHistory;
//    private LocalDate birthDate;
//    private Gender gender;
//    private double height;
//    private double weight;
//    private LifeStyle lifeStyle;
//    private NutritiveValue norm;
//
//    @Before
//    public void setUp() throws Exception {
//        id = 0;
//        name = "Bohdan";
//        password = "1111";
//        client = new Client(name, password);
//        client.setId(0);
//        client.setNorm(new NutritiveValue(1716, 429, 190.6, 429));
//        client.setDailyRation(new DailyRation());
//        client.setDeflectionHistory(new DeflectionRecord(new NutritiveValue(1716, 429, 190.6, 429), LocalDate.of(2019, 05, 13)));
//        client.setBirthDate(LocalDate.of(2000, 05, 17));
//        client.setGender(GenderEnum.M);
//        client.setHeight(165.9);
//        client.setWeight(66.6);
//        client.setLifeStyle(LifeStyleEnum.M);
//    }
//
//    @Test
//    public void getNorm() {
//        assertEquals(new NutritiveValue(1716, 429, 190.6, 429), client.getNorm());
//    }
//
//    @Test
//    public void getId() {
//        assertEquals(0, client.getId());
//    }
//
//    @Test
//    public void getName() {
//        assertEquals("Bohdan", client.getName());
//    }
//
//    @Test
//    public void getPassword() {
//        assertEquals("1111", client.getPassword());
//    }
//
//    @Test
//    public void getDailyRation() {
//        assertNotNull(client.getDailyRation());
//    }
//
//    @Test
//    public void getDeflectionHistory() {
//        assertEquals(new DeflectionRecord(new NutritiveValue(1716, 429, 190.6, 429),
//                        LocalDate.of(2019, 05, 13)),
//                client.getDeflectionHistory()
//        );
//
//    }
//
//    @Test
//    public void getGender() {
//        assertEquals(GenderEnum.M, client.getGender());
//    }
//
//    @Test
//    public void getHeight() {
//        assertEquals(165.9, client.getHeight(), 0.0);
//    }
//
//    @Test
//    public void getWeight() {
//        assertEquals(66.6, client.getWeight(), 0.0);
//    }
//
//    @Test
//    public void getBirthDate() {
//        assertEquals(LocalDate.of(2000, 05, 17), client.getBirthDate());
//    }
//
//    @Test
//    public void getLifeStyle() {
//        assertEquals(LifeStyleEnum.M, client.getLifeStyle());
//    }
//}
