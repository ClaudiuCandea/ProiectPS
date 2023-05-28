package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import com.example.demo.Model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Class that implements the business logic for object of type Driver
 */
@Service
public class DriverService {

    private DAO<Driver> dao;
    private DAO<Car> daoCar;

    public DriverService(DAO<Driver> dao, DAO<Car> daoCar){
        this.dao = dao;
        this.daoCar = daoCar;
    }

    /**
     *  Method that receives an id and return the corespondent Driver from the repository
     * @param driverID
     * @return
     */
    public Driver getDriver(int driverID){
        return dao.get(driverID);
    }

    /**
     * Method that returns all drivers from the repository
     * @return
     */
    public List<Driver> getAllDrivers(){
        return dao.getAll();
    }

    /**
     *  Method that receives a driver as parameter and save it in the repository
     * @param driver
     * @return
     */
    public int saveDriver(Driver driver){
        return dao.save(driver);
    }

    /**
     * Method that updates a driver from the repository.
     * @param driver
     * @return
     */
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

    /**
     * Method that deletes a driver from the repository using his id
     * @param userID
     */
    public void deleteDriver(int userID){
        dao.delete(userID);
    }

    public Driver getDriverByUserID(int userID){
        return (Driver)dao.getByUserID(userID);
    }
}
