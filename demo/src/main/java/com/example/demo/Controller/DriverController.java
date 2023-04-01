package com.example.demo.Controller;


import com.example.demo.Model.Driver;
import com.example.demo.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping("/getDriver")
    public Driver getDriverByID(@RequestParam(value = "driverID") int driverID){
        return driverService.getDriver(driverID);
    }

    @GetMapping("/GetAllDrivers")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @PostMapping("/saveDriver")
    public int saveDriver(@RequestBody Driver driver){
        return driverService.saveDriver(driver);
    }

    @PutMapping("/updateDriver")
    public int updateDriver(@RequestBody Driver driver){
        return driverService.updateDriver(driver);
    }

    @DeleteMapping("/deleteDriver")
    public void deleteDriver(@RequestParam(value = "userID") int userID){
        driverService.deleteDriver(userID);
    }
}
