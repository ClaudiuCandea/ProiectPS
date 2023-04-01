package com.example.demo.Model;

public class Driver extends User{
    public int driverID;

    public Driver(int driverID, int userID,String name, String mail, String phone, String password, String type ){
        super(userID,name,mail,phone,password,type);
        this.driverID = driverID;
    }
    public Driver(){

    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }
}
