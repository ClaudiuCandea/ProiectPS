package com.example.demo.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private int id;
    private int clientID;
    private int driverID;
    private String startLocation;
    private String destinationLocation;
    private Date orderDate;

    public Order(int id, int clientID, int driverID, String startLocation, String destinationLocation){
        this.id = id;
        this.clientID = clientID;
        this.driverID = driverID;
        this.startLocation = startLocation;
        this.destinationLocation = destinationLocation;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        formatter.format(this.orderDate);
    }

    public Order(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
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
