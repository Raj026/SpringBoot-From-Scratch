package com.example.springboot_tut.spring_boot_tut.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot_tut.spring_boot_tut.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    // Customer derived method for fetching the data
    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name, String city);
}
