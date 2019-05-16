package com.bod.entity;

import java.util.Objects;

public class Food {
    private String name;
    private double amount;
    private int number;
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

    public NutritiveValue getValue() {
        double multiplier = amount / number;

        return new NutritiveValue(multiplier * calories, multiplier * protein, multiplier * fat, multiplier * carbohydrates);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return Double.compare(food.getAmount(), getAmount()) == 0 &&
                getNumber() == food.getNumber() &&
                Double.compare(food.getCalories(), getCalories()) == 0 &&
                Double.compare(food.getProtein(), getProtein()) == 0 &&
                Double.compare(food.getFat(), getFat()) == 0 &&
                Double.compare(food.getCarbohydrates(), getCarbohydrates()) == 0 &&
                getName().equals(food.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAmount(), getNumber(), getCalories(), getProtein(), getFat(), getCarbohydrates());
    }
}
