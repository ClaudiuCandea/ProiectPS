package com.example.demo.Model;

public class Car implements Observer{
    private int id;
    private String producer;
    private String model;
    private String registration_number;
    private int driverID;
    private int noTakenOrders;

    public Car(int id, String producer, String model, String registration_number,int driverID){
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.registration_number = registration_number;
        this.driverID = driverID;
        this.noTakenOrders = 0;
    }

    public Car(){

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

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }


    @Override
    public void update(int noTakenOrders) {
        this.noTakenOrders =noTakenOrders;
    }

    public int getNoTakenOrders() {
        return noTakenOrders;
    }

    public void setNoTakenOrders(int noTakenOrders) {
        this.noTakenOrders = noTakenOrders;
    }
}
