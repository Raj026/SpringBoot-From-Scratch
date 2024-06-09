package com.example.springboot_tut.spring_boot_tut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.springboot_tut.spring_boot_tut.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    // Customer derived method for fetching the data
    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name, String city);
    
    @Query("select u from User u")
    public List<User> getAllUser();
    
    @Query("select u from User u where u.name =:n")
    public List<User> getUserByName(@Param("n") String name);
}
