package com.api.book.bootrestbook.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
    private String title;

    //Book has author but no book object in author thus we will perform uni-directional mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference // this will avoid recursion of book and authors as this is parent model otherwise both will be displayed continuosly.
    private Author author;

    public Books(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Books() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Books [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

}
