package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {

    private DAO<Car> dao;

    public CarService(DAO<Car> dao){
        this.dao = dao;
    }

    public Car getCar(int carID){
        return dao.get(carID);
    }

    public List<Car> getAllCars(){
        return dao.getAll();
    }

    public int saveCar(Car car){
        return dao.save(car);
    }

    public int updateCar(Car car){
        return dao.update(car);
    }

    public void deleteCar(int carID){
        dao.delete(carID);
    }
}
