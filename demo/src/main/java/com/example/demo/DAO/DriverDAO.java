package com.example.demo.DAO;

import com.example.demo.Connection.ConnectionFactory;
import com.example.demo.Model.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that execute the basic CRUD operation on the driver table from the taxi database: INSERT, DELETE, SELECT, UPDATE.
 * Some operation need to execute query also on user table to insert a client properly.
 */
@Repository
public class DriverDAO implements DAO<Driver>{

    /**
     * Execute 2 queries. One to get the corresponding information to the given id form the driver table and
     *  ne to select the corresponding information from the user table. It returns a driver object
     * @param id
     * @return
     */
    @Override
    public Driver get(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        String query = "SELECT * FROM driver WHERE driver_id = " + id;
        String query2 = "SELECT * FROM user  WHERE id = ?";
       Driver driver = new Driver();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                driver.setDriverID(resultSet.getInt("driver_id"));
                driver.setNoTakenOrders(resultSet.getInt("no_taken_orders"));
                int userID = resultSet.getInt("user_id");
                statement2 = connection.prepareStatement(query2);
                statement2.setInt(1,userID);
                resultSet2=statement2.executeQuery();
                driver.setId(userID);
                resultSet2.next();
                driver.setName(resultSet2.getString("name"));
                driver.setEmail(resultSet2.getString("email"));
                driver.setPhone(resultSet2.getString("phone"));
                driver.setPassword(resultSet2.getString("password"));
                driver.setType(resultSet2.getString("type"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(statement2);
            ConnectionFactory.close(connection);
        }
        return driver;
    }

    /**
     * Execute 2 queries. One to get all the information about drivers from the driver table and
     * one to select the corresponding information from the user table. It returns a list of drivers.
     * @return
     */
    @Override
    public List<Driver> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        String query2 = "SELECT * FROM taxi.user WHERE id = ?";
        List<Driver> list = new ArrayList<Driver>();
        String query1 = "SELECT * FROM driver";
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query1);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Driver driver = new Driver();
                driver.setDriverID(resultSet.getInt("driver_id"));
                driver.setNoTakenOrders(resultSet.getInt("no_taken_orders"));
                driver.setId(resultSet.getInt("user_id"));
                int userID = resultSet.getInt("user_id");
                statement2 = connection.prepareStatement(query2);
                statement2.setInt(1,userID);
                resultSet2 = statement2.executeQuery();
                resultSet2.next();
                driver.setId(resultSet2.getInt("id"));
                driver.setName(resultSet2.getString("name"));
                driver.setEmail(resultSet2.getString("email"));
                driver.setPhone(resultSet2.getString("phone"));
                driver.setPassword(resultSet2.getString("password"));
                driver.setType(resultSet2.getString("type"));
                list.add(driver);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(resultSet2);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(statement2);
            ConnectionFactory.close(connection);
        }
        return list;
    }

    @Override
    public Driver getByEmail(String email) {
        return null;
    }

    /**
     * Execute 2 insert queries. One to insert information into the driver table and one to insert information on user table.
     * Return the generated key from the driver table
     * @param driver
     * @return
     */
    @Override
    public int save(Driver driver) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        String query = "INSERT INTO user (name,email,phone,password,type) VALUES (?,?,?,?,?)";
        String query2 = "INSERT INTO driver (user_id,no_taken_orders) VALUES (?,?)";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,driver.getName());
            statement.setString(2,driver.getEmail());
            statement.setString(3,driver.getPhone());
            statement.setString(4,driver.getPassword());
            statement.setString(5,driver.getType());
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                generatedKey = resultSet.getInt(1);
            }
            statement2 = connection.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS);
            statement2.setInt(1,generatedKey);
            statement2.setInt(2,driver.getNoTakenOrders());
            statement2.execute();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(statement2);
            ConnectionFactory.close(connection);
        }
        return generatedKey;
    }

    /**
     * Execute 2 queries to delete a driver from the database, one on the user table and one on the driver table.
     * It returns the deleted key from driver table.
     * @param userID
     */
    @Override
    public void delete(int userID) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        String query = "DELETE FROM driver WHERE user_id = ?";
        String query2 = "DELETE FROM user WHERE id = ?";
        try{

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,userID);
            statement.execute();
            statement2 = connection.prepareStatement(query2);
            statement2.setInt(1,userID);
            statement2.execute();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(statement2);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Method that execute 2 queries to update the information about a driver already in the database.
     * One query is on the user table and one on the driver table.
     * @param driver
     * @return
     */
    @Override
    public int update(Driver driver) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        String query = "UPDATE user SET name = ?, email  = ? , phone = ? , password = ? WHERE id = ?";
        String query2 = "UPDATE driver SET no_taken_orders = ? WHERE user_id = ?";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,driver.getName());
            statement.setString(2,driver.getEmail());
            statement.setString(3,driver.getPhone());
            statement.setString(4,driver.getPassword());
            statement.setInt(5,driver.getId());
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                generatedKey = resultSet.getInt(1);
            }
            statement2 = connection.prepareStatement(query2);
            statement2.setInt(1,driver.getNoTakenOrders());
            statement2.setInt(2,driver.getId());
            statement2.execute();

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
}
