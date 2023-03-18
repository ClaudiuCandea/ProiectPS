package com.example.demo.Model;

public class Driver extends User{
    public int driverID;

    public Driver(int driverID, int userID,String name, String mail, String phone ){
        super(userID,name,mail,phone);
        this.driverID = driverID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }
}
