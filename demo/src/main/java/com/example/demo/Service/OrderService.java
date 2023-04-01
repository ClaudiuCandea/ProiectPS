package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private DAO<Order> dao;

    public OrderService(DAO<Order> dao){
        this.dao = dao;
    }

    public Order getOrder(int orderID){
        return dao.get(orderID);
    }

    public List<Order> getAllOrders(){
        return dao.getAll();
    }

    public int saveOrder(Order order){
        return dao.save(order);
    }

    public void deleteOrder(int orderID){
        dao.delete(orderID);
    }

    public int updateOrder(Order order){
        return dao.update(order);
    }


}
