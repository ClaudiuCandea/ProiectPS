package com.example.demo.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private int id;
    private Client client;
    private Driver driver;
    private String startLocation;
    private String destinationLocation;
    private Date orderDate;

    public Order(int id, Client client, Driver driver, String startLocation, String destinationLocation){
        this.id = id;
        this.client = client;
        this.driver = driver;
        this.startLocation = startLocation;
        this.destinationLocation = destinationLocation;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        formatter.format(this.orderDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
