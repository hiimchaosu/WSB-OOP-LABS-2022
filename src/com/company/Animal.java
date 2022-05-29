package com.company;

import java.util.HashMap;

public class Animal {

    final static Double DEFAULT_DOG_WEIGHT = 6.0;
    private static final Double DEFAULT_FOOD_WEIGHT = 1.0;
    public String name;
    final static Double DEFAULT_CAT_WEIGHT = 1.0;
    final static Double DEFAULT_ELEPHANT_WEIGHT = 2000.0;
    final static Double DEFAULT_WEIGHT = 0.5;
    final static Double DEFAULT_HOMO_SAPIENS = 80.0;
    final static Double DEFAULT_COW_WIGHT = 1200.0;
    public final String species;
    private Double weight;
    public  final FoodType foodType;

    public Animal(String species, FoodType foodType) {
        this.species = species;
        this.foodType = foodType;

        switch (species) {
            case "dog":
                this.weight = DEFAULT_DOG_WEIGHT;
                break;
            case "cat":
                this.weight = DEFAULT_CAT_WEIGHT;
                break;
            case "elephant":
                this.weight = DEFAULT_ELEPHANT_WEIGHT;
                break;
            case "homo sapiens":
                this.weight = DEFAULT_HOMO_SAPIENS;
                break;
            case "cow":
                this.weight = DEFAULT_COW_WIGHT;
            default:
                this.weight = DEFAULT_WEIGHT;
        }

    }

    void printWeight() {
        System.out.println(weight);
    }

    void feed(Double foodWeight, FoodType foodType) {
        if(this.foodType == foodType){
            this.weight += (foodWeight * foodType.foodToBodyRatio);
            System.out.println(this.weight);
        } else{
            System.out.println("No body mass gained");
        }

    }

    void feed(Double foodWeight) {
        this.weight += foodWeight;
        System.out.println("thx for food, bro");
        System.out.println("my weight is now " + this.weight);
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    String returnSpeciesAndName() {
        return species + " " + name;
    }

    String returnNameAndOwner(String owner) {
        return name + " " + owner;
    }

    public void sell(Human seller, Human buyer, Double price) {
        System.out.println(this.name);
        if (seller.pet == this) {
            seller.pet = null;
            buyer.pet = this;
        }
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.species + " " + this.weight + "kg";
    }
}
