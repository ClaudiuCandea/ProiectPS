package com.example.demo.DAO;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface DAO<T>{

    T get(int id);
    List<T> getAll();

    int save(T t);
    void delete(int id);
    int update(T t);
}
