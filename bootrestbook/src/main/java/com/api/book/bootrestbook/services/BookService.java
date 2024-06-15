package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Books;

@Service
public class BookService {
    private static List<Books> list = new ArrayList<>();

    static{
        list.add(new Books(12, "Java Guide", "XZ"));
        list.add(new Books(13, "Python Guide", "AB"));
        list.add(new Books(14, "Rust Guide", "GD"));
        list.add(new Books(15, "Spring Guide", "Z"));
    }

    //get all books
    public List<Books> getAllBooks() {
        return list;
    }

    //getr single book 
    public Books getBookById(int id) {
        Books res = null;
        //we can also use stream instead of foreach loop
        //book = list.stream().filter(e->e.getId()==id).findFirst().get().
        for(Books a: list) {
            if(a.getId() == id) {
                res = a;
            }
        }
        return res;

    }

    // adding the book
    public Books addBook(Books b) {
        list.add(b);
        return b;
    }

    //deleting the book
    public String deleteBook(int id) {
        for(Books a: list) {
            if(a.getId() == id){
                list.remove(a);
                return "Successfully Deleted";
            }
        }
        return "ID not Found";
    }
}
