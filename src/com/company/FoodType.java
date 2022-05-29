package com.company;

public enum FoodType {
    MEAT(0.7), CROPS(0.3), ALL(0.5);
    public double  foodToBodyRatio;
    FoodType(Double  foodToBodyRatio)
    {
        this. foodToBodyRatio =  foodToBodyRatio;
    }
}