package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Class that implements the business logic for object of type Order
 */
@Service
public class OrderService {
    private DAO<Order> dao;

    public OrderService(DAO<Order> dao){
        this.dao = dao;
    }

    /**
     *  Method that receives an id and return the corespondent Order from the repository
     * @param orderID
     * @return
     */
    public Order getOrder(int orderID){
        return dao.get(orderID);
    }

    /**
     * Method that returns all orders from the repository
     * @return
     */
    public List<Order> getAllOrders(){
        return dao.getAll();
    }

    /**
     *  Method that receives an order as parameter and save it in the repository
     * @param order
     * @return
     */
    public int saveOrder(Order order){
        return dao.save(order);
    }

    /**
     * Method that deletes a client from the repository using his id.
     * @param orderID
     */
    public void deleteOrder(int orderID){
        dao.delete(orderID);
    }

    /**
     * Method that updates an order from the repository.
     * @param order
     * @return
     */
    public int updateOrder(Order order){
        return dao.update(order);
    }


}
