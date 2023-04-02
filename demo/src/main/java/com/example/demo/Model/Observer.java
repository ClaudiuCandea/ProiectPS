package com.example.demo.Model;


/**
 * Interface for the observer design patter.
 * It models the observer.
 */
public interface Observer {
    /**
     * Method to modify the number of take orders in the observer objects.
     * @param noTakenOrders
     */
    public void update(int noTakenOrders);
}
