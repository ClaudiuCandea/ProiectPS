package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that implements the business logic for object of type Car
 */
@Service
public class CarService {

    private DAO<Car> dao;

    public CarService(DAO<Car> dao){
        this.dao = dao;
    }

    /**
     * Method that receives an id and return the corespondent car from the repository
     * @param carID
     * @return
     */
    public Car getCar(int carID){
        return dao.get(carID);
    }

    /**
     * Method that returns all cars from the repository
     * @return
     */
    public List<Car> getAllCars(){
        return dao.getAll();
    }

    /**
     *  Method that receives a car as parameter and save it in the repository
     * @param car
     * @return
     */
    public int saveCar(Car car){
        return dao.save(car);
    }

    /**
     * Method that updates a car from the repository.
     * @param car
     * @return
     */
    public int updateCar(Car car){
        return dao.update(car);
    }

    /**
     * Method that deletes a car from the repository using his id
     * @param carID
     */
    public void deleteCar(int carID){
        dao.delete(carID);
    }
}
