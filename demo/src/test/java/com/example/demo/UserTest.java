package com.example.demo;


import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import com.example.demo.Model.User;
import com.example.demo.Service.CarService;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserTest {

    @Mock
    DAO<User> dao;

    @Test
    void testSaveUser(){
        User user = new User(1,"Claudiu","claudiu.candea@gmail.com","0754757898","hellohello","client");
        UserService userService = new UserService(dao);
        userService.save(user);
        verify(dao).save(user);
    }

    @Test
    void testDeleteUser(){
        UserService userService = new UserService(dao);
        userService.delete(1);
        verify(dao).delete(1);
    }

    @Test
    void testGetUserById(){
        User user = new User(1,"Claudiu","claudiu.candea@gmail.com","0754757898","hellohello","client");
        UserService userService = new UserService(dao);
        when(dao.get(1)).thenReturn(user);
        userService.get(1);
        verify(dao).get(1);
    }

    @Test
    void testGetUserByEmail(){
        User user = new User(1,"Claudiu","claudiu.candea@gmail.com","0754757898","hellohello","client");
        UserService userService = new UserService(dao);
        when(dao.getByEmail("claudiu.candea@gmail.com")).thenReturn(user);
        userService.getByEmail("claudiu.candea@gmail.com");
        verify(dao).getByEmail("claudiu.candea@gmail.com");
    }

    @Test
    void testGetAllUsers(){
        User user1 = new User(1,"Claudiu","claudiu.candea@gmail.com","0754757898","hellohello","client");
        User user2 = new User(1,"Marian","marian.candea@gmail.com","0754757899","hellohello","client");
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        UserService userService = new UserService(dao);
        when(dao.getAll()).thenReturn(users);
        userService.getAll();
        verify(dao).getAll();
    }

    @Test
    void testUpdateUser(){
        User user1 = new User(1,"Claudiu","claudiu.candea@gmail.com","0754757898","hellohello","client");
        UserService userService = new UserService(dao);
        when(dao.update(user1)).thenReturn(1);
        userService.update(user1);
        verify(dao).update(user1);
    }
}
