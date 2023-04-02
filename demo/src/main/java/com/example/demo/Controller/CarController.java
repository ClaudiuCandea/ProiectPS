package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Class that has the role of a REST controller. It is created using spring web
 */
@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    /**
     * Method that execute a GET request. It returns a car form the database base on an id.
     * @param carID
     * @return
     */
    @GetMapping("/getCar")
    public Car getCarByID(@RequestParam(value = "carID") int carID){
        return carService.getCar(carID);
    }

    /**
     * Method that execute a GET request. It returns all cars from the database.
     * @return
     */
    @GetMapping("/GetAllCars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    /**
     * Method that execute a POST request. It saves a car into the database.
     * @param car
     * @return
     */
    @PostMapping("/saveCar")
    public int saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    /**
     * Method that execute a PUT request. It updates the information of a car from the database.
     * @param car
     * @return
     */
    @PutMapping("/updateCar")
    public int updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    /**
     * Method that execute a DELETE request. It deletes a car from the database.
     * @param carID
     */
    @DeleteMapping("/deleteCar")
    public void deleteCar(@RequestParam(value = "carID") int carID){
        carService.deleteCar(carID);
    }

}
