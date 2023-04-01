package com.example.demo.Controller;


import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/getOrder")
    public Order getOrderById(@RequestParam(value = "orderID") int orderID){
        return orderService.getOrder(orderID);
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/saveOrder")
    public int saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @PutMapping("/updateOrder")
    public int updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestParam(value = "orderID") int orderID){
        orderService.deleteOrder(orderID);
    }
}
