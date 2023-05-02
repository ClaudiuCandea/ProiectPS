package com.example.demo;


import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import com.example.demo.Service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        Car car = new Car(1,"VW","Golf 5","CJ25CLA",2);
        CarService carService = new CarService(dao);
        when(dao.get(1)) .thenReturn(car);
        carService.getCar(1);
        verify(dao).get(1);
    }

    @Test
    void testGetAllCars(){
        ArrayList<Car> cars = new ArrayList<Car>();
        Car car1 = new Car(1,"VW","Golf 5","CJ25CLA",2);
        Car car2 = new Car(2,"Opel","Astra G","CJ25RAR",3);
        cars.add(car1);
        cars.add(car2);
        CarService carService = new CarService(dao);
        when(dao.getAll()).thenReturn(cars);
        carService.getAllCars();
        verify(dao).getAll();
    }

    @Test
    void testUpdateCar(){
        Car car1 = new Car(1,"VW","Golf 5","CJ25CLA",2);
        CarService carService = new CarService(dao);
        when(dao.update(car1)).thenReturn(1);
        carService.updateCar(car1);
        verify(dao).update(car1);
    }
}
