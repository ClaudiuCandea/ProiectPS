package com.example.demo.Model;

public class Car {
    private int id;
    private String producer;
    private String model;
    private String registration_number;
    private Driver driver;

    public Car(int id, String producer, String model, String registration_number,Driver driver){
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.registration_number = registration_number;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
