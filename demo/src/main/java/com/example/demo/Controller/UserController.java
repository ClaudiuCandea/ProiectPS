package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that has the role of a REST controller. It is created using spring web
 */
@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Method that execute a get request on the user table. It returns only one user base on his id
     * @return
     */
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getAll();
    }

    /**
     * Method that execute a get request on the user tabel. It returns all users
     * @param id
     * @return
     */
    @GetMapping("/getUser")
    public User getUserByID(@RequestParam(value = "id")int id){
        return userService.get(id);
    }

    /**
     * Method that execute a put request on the user table
     * @param user
     */
    @PutMapping("/saveUser")
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

    /**
     * Method that execute an post request on the user table
     * @param user
     */
    @PostMapping("/post")
    public void saveUserPost(@RequestBody User user){
        userService.save(user);
    }

    /**
     * Method thate execute an delete request on the user tabele
     * @param id
     */
    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam(value = "id") int id){
        userService.delete(id);
    }

}
