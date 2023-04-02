package com.example.demo.Controller;


import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that has the role of a REST controller. It is created using spring web
 */
@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    /**
     * Method that execute a GET request. It returns an order form the database based on an id.
     * @param orderID
     * @return
     */
    @GetMapping("/getOrder")
    public Order getOrderById(@RequestParam(value = "orderID") int orderID){
        return orderService.getOrder(orderID);
    }

    /**
     * Method that execute a GET request. It returns all orders from the database.
     * @return
     */
    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    /**
     * Method that execute a POST request. It saves an Order into the database.
     * @param order
     * @return
     */
    @PostMapping("/saveOrder")
    public int saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    /**
     * Method that execute a PUT request. It updates an order form the database.
     * @param order
     * @return
     */
    @PutMapping("/updateOrder")
    public int updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    /**
     * Method that execute a DELETE request. It deletes an order from the database.
     * @param orderID
     */
    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestParam(value = "orderID") int orderID){
        orderService.deleteOrder(orderID);
    }
}
