package com.api.book.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootrestbook.entities.Books;

public interface BookRepository extends CrudRepository<Books, Integer>{
    public Books findById(int id);

}
