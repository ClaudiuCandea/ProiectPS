package com.example.demo;


import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import com.example.demo.Service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class CarTest {

    @Mock
    private DAO<Car> dao;

    @Test
    void testSaveCar(){
        Car car = new Car(1,"VW","Golf 5","CJ25CLA",2);
        CarService carService = new CarService(dao);
        carService.saveCar(car);
        verify(dao).save(car);

    }

    @Test
    void testDeleteCar(){
        CarService carService = new CarService(dao);
        carService.deleteCar(1);
        verify(dao).delete(1);
    }

    @Test
    void testGetCarById(){

    }

    @Test
    void testGetAllCars(){

    }

    @Test
    void testUpdateCar(){

    }
}
