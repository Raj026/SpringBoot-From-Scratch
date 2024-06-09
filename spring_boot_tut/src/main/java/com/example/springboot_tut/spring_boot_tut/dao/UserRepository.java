package com.example.springboot_tut.spring_boot_tut.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot_tut.spring_boot_tut.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    
    
}
