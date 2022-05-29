package com.company.devices;

public class Car extends Device implements Refillable, Comparable<Car> {

    public Double engineSize;
    public String fuelType;
    public Engine engine;
    public boolean isRunning;
    public Car(String producer, String model) {
        super(producer, model);
        this.engine = new Engine();
    }
    public void startACar(){
        this.engine.turnOn();
    }
    public void stopACar(){
        this.engine.turnOff();
    }
    @Override
    public void turnOn() {
        System.out.println("turning the key");
        System.out.println("engine starts");
        System.out.println("you can drive now");
    }

    @Override
    public void refill() {
        System.out.println("go to gas awefaw");
        System.out.println("fill the tank with gas");
        System.out.println("PAY!");
    }
    @Override
    public void refillToFull() {

    }
    @Override
    public int compareTo(Car car) {
        return (int) (this.engineSize - car.engineSize);

    }
    private class Engine{
        public int horsePower;
        public double volume;
        public double mileage;

        public void turnOn() {
            System.out.println("turning the key");
            System.out.println("engine starts");
            System.out.println("you can drive now");
            System.out.println("Now you can go fast !!");
            isRunning = true;
        }

        public void turnOff(){
            System.out.println("The car is turning off, finally!");
            isRunning = false;
        }
    }
}
