package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private DAO<Driver> dao;

    public DriverService(DAO<Driver> dao){
        this.dao = dao;
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
        return dao.update(driver);
    }

    public void deleteDriver(int userID){
        dao.delete(userID);
    }
}
