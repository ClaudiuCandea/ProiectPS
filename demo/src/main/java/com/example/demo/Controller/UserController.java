package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/getUser")
    public User getUserByID(@RequestParam(value = "id")int id){
        return userService.get(id);
    }

    @PutMapping("/saveUser")
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

    @PostMapping("/post")
    public void saveUserPost(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam(value = "id") int id){
        userService.delete(id);
    }

}
