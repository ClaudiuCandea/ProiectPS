package com.example.demo.DAO;

import com.example.demo.Connection.ConnectionFactory;
import com.example.demo.Model.Car;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that execute the basic CRUD operation on the Car table from the taxi database: INSERT, DELETE, SELECT, UPDATE.
 */
@Repository
public class CarDAO implements DAO<Car>{

    /**
     * Method that return the Car object created after executed a select query with the give id.
     * @param carID
     * @return
     */
    @Override
    public Car get(int carID) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM car WHERE car_id = " + carID;
        Car car = new Car();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                car.setId(resultSet.getInt("car_id"));
                car.setProducer(resultSet.getString("producer"));
                car.setModel(resultSet.getString("model"));
                car.setRegistration_number(resultSet.getString("registration_number"));
                car.setDriverID(resultSet.getInt("driver_id"));
                car.setNoTakenOrders(resultSet.getInt("no_taken_orders"));

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return car;
    }

    /**
     * Method that return a list of Car object after it executed a SELECT query that return all rows from the table.
     * @return
     */
    @Override
    public List<Car> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM car";
        List<Car> list = new ArrayList<Car>();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Car car = new Car();;
                car.setId(resultSet.getInt("car_id"));
                car.setProducer(resultSet.getString("producer"));
                car.setModel(resultSet.getString("model"));
                car.setRegistration_number(resultSet.getString("registration_number"));
                car.setDriverID(resultSet.getInt("driver_id"));
                car.setNoTakenOrders(resultSet.getInt("no_taken_orders"));
                list.add(car);

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return list;
    }

    @Override
    public Car getByEmail(String email) {
        return null;
    }

    /**
     * Method that execute a insert query to save the given Car object into the car table.
     * @param car
     * @return
     */
    @Override
    public int save(Car car) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "INSERT INTO car ( driver_id,producer,model,registration_number,no_taken_orders) VALUES (?,?,?,?,?)";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,car.getDriverID());
            statement.setString(2,car.getProducer());
            statement.setString(3,car.getModel());
            statement.setString(4,car.getRegistration_number());
            statement.setInt(5,car.getNoTakenOrders());
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                generatedKey = resultSet.getInt(1);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return generatedKey;
    }

    /**
     * Method that execute a delete query using the given id
     * @param id
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "DELETE FROM car WHERE car_id = ?";
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Method that update the row from the table coresponding to the given Car object. It executes a update query.
     * @param car
     * @return
     */
    @Override
    public int update(Car car) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "UPDATE car SET driver_id = ?, producer  = ? , model = ? , registration_number = ?, no_taken_orders = ? WHERE car_id = ?";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,car.getDriverID());
            statement.setString(2,car.getProducer());
            statement.setString(3,car.getModel());
            statement.setString(4,car.getRegistration_number());
            statement.setInt(5,car.getNoTakenOrders());
            statement.setInt(6,car.getId());
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                generatedKey = resultSet.getInt(1);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return generatedKey;

    }

    @Override
    public Object getByUserID(int userID) {
        return 0;
    }

    @Override
    public void deleteOrderByDriverID(int driverID) {

    }
}
