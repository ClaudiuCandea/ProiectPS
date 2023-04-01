package com.example.demo.DAO;

import com.example.demo.Connection.ConnectionFactory;
import com.example.demo.Model.Order;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAO implements DAO<Order>{
    @Override
    public Order get(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM taxi.order WHERE order_id = " + id;
        Order order = new Order();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                order.setId(resultSet.getInt("order_id"));
                order.setClientID(resultSet.getInt("client_id"));
                order.setDriverID(resultSet.getInt("driver_id"));
                order.setStartLocation(resultSet.getString("start_location"));
                order.setDestinationLocation(resultSet.getString("destination_location"));
                order.setOrderDate(resultSet.getDate("order_date"));

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
        return order;
    }

    @Override
    public List<Order> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM taxi.order";
        List<Order> list = new ArrayList<Order>();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("order_id"));
                order.setClientID(resultSet.getInt("client_id"));
                order.setDriverID(resultSet.getInt("driver_id"));
                order.setStartLocation(resultSet.getString("start_location"));
                order.setDestinationLocation(resultSet.getString("destination_location"));
                order.setOrderDate(resultSet.getDate("order_date"));
                list.add(order);
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
    public int save(Order order) {
        System.out.println(order);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "INSERT INTO taxi.order (client_id,driver_id,order_date,start_location,destination_location) VALUES (?,?,?,?,?)";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,order.getClientID());
            statement.setInt(2,order.getDriverID());
            statement.setDate(3,order.getOrderDate());
            statement.setString(4,order.getStartLocation());
            statement.setString(5,order.getDestinationLocation());
            System.out.println(statement);
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
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "DELETE FROM taxi.order WHERE order_id = ?";
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

    @Override
    public int update(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "UPDATE taxi.order SET client_id = ?, driver_id = ?, order_date = ?, start_location = ?, destination_location = ?  WHERE order_id = ?";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,order.getClientID());
            statement.setInt(2,order.getDriverID());
            java.sql.Date sqlDate = new java.sql.Date(order.getOrderDate().getTime());
            statement.setDate(3,sqlDate);
            statement.setString(4,order.getStartLocation());
            statement.setString(5,order.getDestinationLocation());
            statement.setInt(6,order.getId());
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
