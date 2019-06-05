//package com.bod.entity;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class DailyRationTest {
//    private DailyRation dailyRation;
//
//    @Before
//    public void setUp() throws Exception {
//        dailyRation = new DailyRation();
//
//        FoodBuilder builder = new FoodBuilder();
//        builder.reset();
//        builder.setName("chicken egg");
//        builder.setNumber(100);
//        builder.setCalories(144);
//        builder.setProteins(12.7);
//        builder.setFats(10.7);
//        builder.setCarbohydrates(0.8);
//        builder.setAmount(100);
//        Food egg = builder.getResult();
//
//        builder.reset();
//        builder.setName("rice");
//        builder.setNumber(100);
//        builder.setCalories(330);
//        builder.setProteins(7.0);
//        builder.setFats(1.0);
//        builder.setCarbohydrates(77.3);
//        builder.setAmount(100);
//        Food rice = builder.getResult();
//
//        dailyRation.addFood(egg);
//        dailyRation.addFood(rice);
//        dailyRation.accumulateEaten();
//    }
//
//    @Test
//    public void getFoodList() {
//        assertNotNull(dailyRation.getFoodList());
//    }
//
//    @Test
//    public void getEaten() {
//        NutritiveValue eaten = dailyRation.getEaten();
//        assertEquals(new NutritiveValue(474, 19.7, 11.7, 78.1), dailyRation.getEaten());
//    }
//}
