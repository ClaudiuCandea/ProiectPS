package com.example.demo.Model;


import java.util.ArrayList;
import java.util.List;

public class Driver extends User{
    private int driverID;
    private Observer observer;
    private int noTakenOrders;

    public Driver(int driverID, int userID,String name, String mail, String phone, String password, String type ){
        super(userID,name,mail,phone,password,type);
        this.driverID = driverID;
        this.noTakenOrders = 0;
    }
    public Driver(){

    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public void notifyObserver(){
        observer.update(this.noTakenOrders);
    }

    public void addObserver(Observer observer){
        this.observer = observer;
    }

    public void removeObserver(){
        this.observer = null;
    }

    public int getNoTakenOrders() {
        return noTakenOrders;
    }

    public void setNoTakenOrders(int noTakenOrders) {
        this.noTakenOrders = noTakenOrders;
    }
}
