package com.example.demo;


import com.example.demo.DAO.DAO;
import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderTest {

    @Mock
    DAO<Order> dao;

    @Test
    void testSaveOrder(){
        Order order = new Order(1,1,2,"Strada Livezii nr. 20","Strada Liliacului nr.5");
        OrderService orderService = new OrderService(dao);
        orderService.saveOrder(order);
        verify(dao).save(order);

    }

    @Test
    void testDeleteOrder(){
        OrderService orderService = new OrderService(dao);
        orderService.deleteOrder(1);
        verify(dao).delete(1);
    }

    @Test
    void testGetOrderById(){
        Order order = new Order(1,1,2,"Strada Livezii nr. 20","Strada Liliacului nr.5");
        OrderService orderService = new OrderService(dao);
        when(dao.get(1)).thenReturn(order);
        orderService.getOrder(1);
        verify(dao).get(1);
    }

    @Test
    void testGetAllOrders(){
        Order order1 = new Order(1,1,2,"Strada Livezii nr. 20","Strada Liliacului nr.5");
        Order order2 = new Order(2,1,2,"Str. Observatorului nr. 20","Strada Liliacului nr.5");
        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(order1);
        orders.add(order2);
        OrderService orderService = new OrderService(dao);
        when(dao.getAll()).thenReturn(orders);
        orderService.getAllOrders();
        verify(dao).getAll();
    }

    @Test
    void testUpdateOrder(){
        Order order = new Order(1,1,2,"Strada Livezii nr. 20","Strada Liliacului nr.5");
        OrderService orderService = new OrderService(dao);
        when(dao.update(order)).thenReturn(1);
        orderService.updateOrder(order);
        verify(dao).update(order);
    }
}
