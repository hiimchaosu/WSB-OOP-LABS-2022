package com.company.devices;

public abstract class Device {
    public String producer;
    public String model;

    public Device(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

    abstract public void turnOn();

    public String toString() {
        return producer + " " + model;
    }
}
