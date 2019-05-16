package com.bod.entity;

//todo get values form .properties
public enum LifeStyleEnum {
    MINIMAL(1.2),
    AVERAGE(1.375),
    INCREASED(1.55),
    HIGH(1.725),
    ULTIMATE(1.9);

    double coef;

    LifeStyleEnum(double c) {
        coef = c;
    }

    double getValue() {
        return coef;
    }
}
