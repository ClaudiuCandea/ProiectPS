package com.example.demo.Model;

public class Client extends User{
    private int clientID;
    private String cardNumber;

    public Client(int clientID, int userID,String name, String mail, String phone, String cardNumber,String password,String type){
        super(userID,name,mail,phone,password,type);
        this.clientID = clientID;
        this.cardNumber = cardNumber;

    }

    public Client(){

    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
