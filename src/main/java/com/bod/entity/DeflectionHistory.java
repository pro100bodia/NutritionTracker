package com.bod.entity;

import java.time.LocalDate;
import java.util.Objects;

public class DeflectionHistory {
    private int id;
    private NutritiveValue value;
    private LocalDate date;

    public DeflectionHistory(NutritiveValue value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    public NutritiveValue getValue() {
        return value;
    }

    public void setValue(NutritiveValue value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeflectionHistory)) return false;
        DeflectionHistory that = (DeflectionHistory) o;
        return getValue().equals(that.getValue()) &&
                getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getDate());
    }
}
