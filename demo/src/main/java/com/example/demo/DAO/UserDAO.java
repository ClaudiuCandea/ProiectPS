package com.example.demo.DAO;

import com.example.demo.Connection.ConnectionFactory;
import com.example.demo.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements DAO interface for accessing the User table from the database
 */
@Repository
public class UserDAO implements DAO<User>{
    /**
     * Method that receive an id and return the corespondent user from the database
     *  This method create an select query and execute it
     * @param id
     * @return
     */
   public User get(int id){
       Connection connection = null;
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       String query = "SELECT * FROM user WHERE id = " + id;
       User user = new User();
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(query);
           resultSet = statement.executeQuery();

           while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));

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
       return user;
    }

    /**
     * Method that return all users from the database
     * This method create an select query and execute it
     * @return
     */
   public List<User> getAll(){
       Connection connection = null;
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       String query = "SELECT * FROM user";
       List<User> list = new ArrayList<User>();
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(query);
           resultSet = statement.executeQuery();

           while(resultSet.next()){
               User user = new User();
               user.setId(resultSet.getInt("id"));
               user.setName(resultSet.getString("name"));
               user.setEmail(resultSet.getString("email"));
               user.setPhone(resultSet.getString("phone"));
               list.add(user);
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

    /**
     * Method that receive an user as parameter and save it in the database
     * This method create a save query and execute it
     * @param user
     */
   public void save(User user){
       Connection connection = null;
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       String query = "INSERT INTO user (name,email,phone) VALUES (?,?,?)";
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(query);
           statement.setString(1,user.getName());
           statement.setString(2,user.getEmail());
           statement.setString(3,user.getPhone());
            statement.execute();

       }
       catch(SQLException e){
           e.printStackTrace();
       }
       finally {
           ConnectionFactory.close(resultSet);
           ConnectionFactory.close(statement);
           ConnectionFactory.close(connection);
       }
    }

    /**
     * Method that receive an user id and a list o parameters of type string and update in the database
     * the user with the give id
     * This method create an update query and execute it
     * @param id
     * @param params
     */
    public void update(int id,String params[]){

    }

    /**
     * Method that delete an user from the database using his id
     * This method create a delte query and execute it
     * @param id
     */
    public void delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "DELETE FROM user WHERE id = ?";
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
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}

