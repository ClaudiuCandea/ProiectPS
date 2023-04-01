package com.example.demo.DAO;

import com.example.demo.Connection.ConnectionFactory;
import com.example.demo.Model.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverDAO implements DAO<Driver>{
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
    public int save(Driver driver) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        String query = "INSERT INTO user (name,email,phone,password,type) VALUES (?,?,?,?,?)";
        String query2 = "INSERT INTO driver (user_id) VALUES (?)";
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

    @Override
    public int update(Driver driver) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "UPDATE user SET name = ?, email  = ? , phone = ? , password = ? WHERE id = ?";
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
