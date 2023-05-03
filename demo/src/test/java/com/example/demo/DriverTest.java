package com.example.demo;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import com.example.demo.Model.Driver;
import com.example.demo.Service.DriverService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DriverTest {

    @Mock
    DAO<Driver> dao;
    @Mock
    DAO<Car> daoCar;

    @Test
    void testSaveDriver(){
        Driver driver = new Driver(1,1,"Geroge","george@gmail.com","0744219891","hello","driver");
        DriverService driverService = new DriverService(dao,daoCar);
        driverService.saveDriver(driver);
        verify(dao).save(driver);

    }

    @Test
    void testDeleteDriver(){
        DriverService driverService = new DriverService(dao, daoCar);
        driverService.deleteDriver(1);
        verify(dao).delete(1);
    }

    @Test
    void testGetDriverById(){
        Driver driver = new Driver(1,1,"Geroge","george@gmail.com","0744219891","hello","driver");
        DriverService driverService = new DriverService(dao,daoCar);
        when(dao.get(1)).thenReturn(driver);
        driverService.getDriver(1);
        verify(dao).get(1);
    }

    @Test
    void testGetAllDriver(){
        Driver driver1 = new Driver(1,1,"Geroge","george@gmail.com","0744219891","hello","driver");
        Driver driver2 = new Driver(2,2,"Gelu","gelue@gmail.com","0744219891","hello","driver");
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        drivers.add(driver1);
        drivers.add(driver2);
        DriverService driverService = new DriverService(dao, daoCar);
        when(dao.getAll()).thenReturn(drivers);
        driverService.getAllDrivers();
        verify(dao).getAll();
    }

    @Test
    void testUpdateDriver(){
        Driver driver = new Driver(1,1,"Geroge","george@gmail.com","0744219891","hello","driver");
        Car car = new Car(1,"Dacia","Logan","B20GEO",1);
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(car);
        when(dao.update(driver)).thenReturn(1);
        when(daoCar.getAll()).thenReturn(cars);
        when(daoCar.update(car)).thenReturn(1);
        DriverService driverService = new DriverService(dao,daoCar);
        driverService.updateDriver(driver);
        verify(dao).update(driver);
        verify(daoCar).getAll();
        verify(daoCar).update(car);
    }
}
