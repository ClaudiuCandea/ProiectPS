package com.example.demo.DAO;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface DAO<T>{

    T get(int id);
    List<T> getAll();

    void save(T t);
    void delete(int id);
    void update(int id,String params[]);
}
