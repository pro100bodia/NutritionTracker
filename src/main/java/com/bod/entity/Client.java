package com.bod.entity;

import java.time.LocalDate;

public class Client implements Databaseable {
    private int id;
    private String name;
    private String password;
    private String image;
    private String email;
    private DailyRation dailyRation;
    private DeflectionHistory deflectionHistory;
    private LocalDate birthDate;
    private Gender gender;
    private double height;
    private double weight;
    private LifeStyle lifeStyle;
    private NutritiveValue norm;

    public Client(String name, String password) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public LifeStyle getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(LifeStyle lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
