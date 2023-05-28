package com.example.demo.Controller;


import com.example.demo.Model.Driver;
import com.example.demo.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that has the role of a REST controller. It is created using spring web
 */
@RestController
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    /**
     * Method that execute a get request on the driver and user table. It returns only one driver base on his id
     * @return
     */
    @GetMapping("/getDriver")
    public Driver getDriverByID(@RequestParam(value = "driverID") int driverID){
        return driverService.getDriver(driverID);
    }
    @GetMapping("/getDriverByUserID")
    public Driver getDriverByUserID(@RequestParam(value = "userID") int userID){
        return driverService.getDriverByUserID(userID);
    }

    /**
     * Method that execute a get request on the driver and user table. It returns all drivers.
     * @return
     */
    @GetMapping("/GetAllDrivers")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    /**
     * Method that execute a post request. It saves a driver into the database.
     * @param driver
     * @return
     */
    @PostMapping("/saveDriver")
    public int saveDriver(@RequestBody Driver driver){
        return driverService. saveDriver(driver);
    }

    /**
     * Method that execute a PUT request. It updates the information of a driver from the database.
     * @param driver
     * @return
     */
    @PutMapping("/updateDriver")
    public int updateDriver(@RequestBody Driver driver){
        return driverService.updateDriver(driver);
    }

    /**
     * Method that execute a DELETE request. It deletes the driver information from the driver table and the user table.
     * @param userID
     */
    @DeleteMapping("/deleteDriver")
    public void deleteDriver(@RequestParam(value = "userID") int userID){
        driverService.deleteDriver(userID);
    }
}
