package com.example.demo.DAO;

import com.example.demo.Connection.ConnectionFactory;
import com.example.demo.Model.Client;
import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDAO implements DAO<Client>{
    @Override
    public Client get(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        String query = "SELECT * FROM client WHERE client_id = " + id;
        String query2 = "SELECT * FROM user  WHERE id = ?";
        Client client = new Client();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                client.setClientID(resultSet.getInt("client_id"));
                client.setCardNumber(resultSet.getString("card_number"));
                int userID = resultSet.getInt("user_id");
                statement2 = connection.prepareStatement(query2);
                statement2.setInt(1,userID);
                resultSet2=statement2.executeQuery();
                client.setId(userID);
                resultSet2.next();
                client.setName(resultSet2.getString("name"));
                client.setEmail(resultSet2.getString("email"));
                client.setPhone(resultSet2.getString("phone"));
                client.setPassword(resultSet2.getString("password"));
                client.setType(resultSet2.getString("type"));
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
        return client;
    }

    @Override
    public List<Client> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        String query = "SELECT * FROM user WHERE id=?";
        List<Client> list = new ArrayList<Client>();
        String query2 = "SELECT * FROM client";
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query2);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Client client = new Client();
                client.setClientID(resultSet.getInt("client_id"));
                client.setCardNumber(resultSet.getString("card_number"));
                int userID = resultSet.getInt("user_id");
                statement2 = connection.prepareStatement(query);
                statement2.setInt(1,userID);
                resultSet2 = statement.executeQuery();
                resultSet2.next();
                client.setId(resultSet2.getInt("id"));
                client.setName(resultSet2.getString("name"));
                client.setEmail(resultSet2.getString("email"));
                client.setPhone(resultSet2.getString("phone"));
                client.setPassword(resultSet2.getString("password"));
                client.setPassword(resultSet2.getString("type"));
                list.add(client);
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
        return list;
    }

    @Override
    public int save(Client client) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        String query = "INSERT INTO user (name,email,phone,password,type) VALUES (?,?,?,?,?)";
        String query2 = "INSERT INTO client (user_id,card_number) VALUES (?,?)";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,client.getName());
            statement.setString(2,client.getEmail());
            statement.setString(3,client.getPhone());
            statement.setString(4,client.getPassword());
            statement.setString(5,client.getType());
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                generatedKey = resultSet.getInt(1);
            }
            statement2 = connection.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS);
            statement2.setInt(1,generatedKey);
            statement2.setString(2,client.getCardNumber());
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
        String query = "DELETE FROM client WHERE user_id = ?";
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
    public int update(Client client) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        String query = "UPDATE user SET name = ?, email  = ? , phone = ? , password = ? WHERE id = ?";
        String query2 = "UPDATE client SET card_number = ? WHERE user_id = ? ";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,client.getName());
            statement.setString(2,client.getEmail());
            statement.setString(3,client.getPhone());
            statement.setString(4,client.getPassword());
            statement.setInt(5,client.getId());
            statement.execute();
            statement2 =connection.prepareStatement(query2);
            statement2.setString(1,client.getCardNumber());
            statement2.setInt(2,client.getId());
            statement2.execute();
            resultSet = statement2.getGeneratedKeys();
            if(resultSet.next()){
                generatedKey = resultSet.getInt(1);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement2);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return generatedKey;


    }
}