package com.bod.entity;

import java.time.LocalDate;

public class Client {
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

    public Client(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public NutritiveValue getNorm() {
        return norm;
    }

    public void setNorm(NutritiveValue norm) {
        this.norm = norm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DailyRation getDailyRation() {
        return dailyRation;
    }

    public void setDailyRation(DailyRation dailyRation) {
        this.dailyRation = dailyRation;
    }

    public DeflectionHistory getDeflectionHistory() {
        return deflectionHistory;
    }

    public void setDeflectionHistory(DeflectionHistory deflectionHistory) {
        this.deflectionHistory = deflectionHistory;
    }

    public void setLocalDateOfBirth(LocalDate birthLocalDate) {
        this.birthDate = birthLocalDate;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LifeStyleEnum getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(LifeStyleEnum lifeStyle) {
        this.lifeStyle = lifeStyle;
    }


}
