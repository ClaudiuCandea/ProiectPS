package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/getCar")
    public Car getCarByID(@RequestParam(value = "carID") int carID){
        return carService.getCar(carID);
    }

    @GetMapping("/GetAllCars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @PostMapping("/saveCar")
    public int saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @PutMapping("/updateCar")
    public int updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @DeleteMapping("/deleteCar")
    public void deleteCar(@RequestParam(value = "carID") int carID){
        carService.deleteCar(carID);
    }

}
