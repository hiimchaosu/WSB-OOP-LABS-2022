package com.company;

public class FarmAnimal extends Animal{
    public String name;
    public FarmAnimal(String species, FoodType foodType, String name) {
        super(species, foodType);
        this.name = name;
    }
}
