package com.example.demo.Model;


import java.util.ArrayList;
import java.util.List;

/**
 * Class that extends User Class. A driver is a user that can take rides and have a car.
 */
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

    /**
     * Notify the Object obsever ( the car owned by the driver) that the number of taken orders has changed.
     */
    public void notifyObserver(){
        observer.update(this.noTakenOrders);
    }

    /**
     * Change the driver's car(Observer)
     * @param observer
     */
    public void addObserver(Observer observer){
        this.observer = observer;
    }


    public int getNoTakenOrders() {
        return noTakenOrders;
    }

    public void setNoTakenOrders(int noTakenOrders) {
        this.noTakenOrders = noTakenOrders;
        if(observer!=null){
            notifyObserver();
        }
    }
}
