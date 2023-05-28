package com.example.demo.DAO;

import com.example.demo.Connection.ConnectionFactory;
import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
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
                user.setPassword(resultSet.getString("password"));
                user.setPassword(resultSet.getString("type"));

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

    @Override
    public User getByEmail(String email){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM user WHERE email = ?";
        User user = new User();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,email);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));

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
               user.setPassword(resultSet.getString("password"));
               user.setPassword(resultSet.getString("type"));
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
   public int save(User user){
       Connection connection = null;
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       int generatedKey = 0;
       String query = "INSERT INTO user (name,email,phone,password,type) VALUES (?,?,?,?,?)";
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1,user.getName());
           statement.setString(2,user.getEmail());
           statement.setString(3,user.getPhone());
           statement.setString(4,user.getPassword());
           statement.setString(5,user.getType());
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
           ConnectionFactory.close(statement);
           ConnectionFactory.close(connection);
       }
       return generatedKey;
    }

    /**
     * Method that receive an user id and a list o parameters of type string and update in the database
     * the user with the give id
     * This method create an update query and execute it
     */
    public int update(User user){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "UPDATE user SET name = ?, email  = ? , phone = ? , password = ? WHERE id = ?";
        int generatedKey = 0;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPhone());
            statement.setString(4,user.getPassword());
            statement.setInt(5,user.getId());
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
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return generatedKey;


    }

    @Override
    public Object getByUserID(int userID) {
        return null;
    }

    @Override
    public void deleteOrderByDriverID(int driverID) {

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
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}

