package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService{

    private DAO<User> dao;

    @Autowired
    public UserService(DAO<User> dao){
        this.dao = dao;
    }

    public User get(int id){
        return dao.get(id );
    }

    public List<User> getAll(){
        return dao.getAll();
    }

    public void save(User user){
        dao.save(user);
    }

    public void delete(int id){
        dao.delete(id);
    }


}