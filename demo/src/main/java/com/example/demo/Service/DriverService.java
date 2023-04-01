package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import com.example.demo.Model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private DAO<Driver> dao;
    private DAO<Car> daoCar;

    public DriverService(DAO<Driver> dao, DAO<Car> daoCar){
        this.dao = dao;
        this.daoCar = daoCar;
    }

    public Driver getDriver(int driverID){
        return dao.get(driverID);
    }

    public List<Driver> getAllDrivers(){
        return dao.getAll();
    }

    public int saveDriver(Driver driver){
        return dao.save(driver);
    }

    public int updateDriver(Driver driver){
         Car searchCar = null;
         List<Car> cars = daoCar.getAll();
         for(Car car : cars){
             if(car.getDriverID()==driver.getDriverID()){
                 searchCar = car;
                 break;
             }
         }
         driver.addObserver(searchCar);
         driver.notifyObserver();
         daoCar.update(searchCar);
        return dao.update(driver);
    }

    public void deleteDriver(int userID){
        dao.delete(userID);
    }
}
