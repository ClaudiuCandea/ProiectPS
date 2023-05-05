package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that implements the business logic for object of type User
 */
@Service
public class UserService{

    private DAO<User> dao;

    @Autowired
    public UserService(DAO<User> dao){
        this.dao = dao;
    }

    /**
     * Method that receives an id and return the corespondent user from the repository
     * @param id
     * @return
     */
    public User get(int id){
        return dao.get(id );
    }

    /**
     * Method that receives an email and return the corespondent user from the repository
     * @param email
     * @return
     */
    public User getByEmail(String email){
        return dao.getByEmail(email);
    }

    /**
     *  Method that returns all users from the repository
     * @return
     */
    public List<User> getAll(){
        return dao.getAll();
    }

    /**
     *  Method that receives an user as parameter and save it in the repository
     * @param user
     */
    public void save(User user){
        dao.save(user);
        if(user.getType().equals("client")){

        }
    }
    /**
     Method that deletes an user from the repository using his id
     */
    public void delete(int id){
        dao.delete(id);
    }
    public void update(User user){
        dao.update(user);
    }


}