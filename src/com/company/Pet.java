package com.company;

public class Pet extends Animal{
    public String name;
    public Pet(String species, FoodType foodType, String name) {
        super(species, foodType);
        this.name = name;
    }
}
