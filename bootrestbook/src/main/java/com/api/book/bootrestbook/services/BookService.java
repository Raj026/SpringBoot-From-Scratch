package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Books;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Books> list = new ArrayList<>();

    // static{
    //     list.add(new Books(12, "Java Guide", "XZ"));
    //     list.add(new Books(13, "Python Guide", "AB"));
    //     list.add(new Books(14, "Rust Guide", "GD"));
    //     list.add(new Books(15, "Spring Guide", "Z"));
    // }

    //get all books
    public List<Books> getAllBooks() {
        List<Books> b = (List<Books>) this.bookRepository.findAll();
        return b;
    }

    //getr single book 
    public Books getBookById(int id) {
        Books b = this.bookRepository.findById(id);
        return b;
        // Books res = null;
        // //we can also use stream instead of foreach loop
        // //book = list.stream().filter(e->e.getId()==id).findFirst().get().
        // for(Books a: list) {
        //     if(a.getId() == id) {
        //         res = a;
        //     }
        // }
        // return res;

    }

    // adding the book
    public Books addBook(Books b) {
        // list.add(b);
        // return b;
        Books a = bookRepository.save(b);
        return a;
    }

    //deleting the book
    public String deleteBook(int id) {
        // for(Books a: list) {
        //     if(a.getId() == id){
        //         list.remove(a);
        //         return "Successfully Deleted";
        //     }
        // }
        // return "ID not Found";
        bookRepository.deleteById(id);
        return "Success";
    }

    //updating the book
    public String updateBook(Books b, int id) {
        //alternate way to handle this is using the stream
        // list.stream().map(b->{
        //     if(b.getId() == id) {
        //         b.setTitle(b.getTitle());
        //         b.setAuthor(b.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
        // for(int i=0;i<list.size();i++) {
        //     if(list.get(i).getId() == id) {
        //         list.set(i, b);
        //         return "Updated Successfully";
        //     }
        // }
        // return "ID not found";
        b.setId(id);
        bookRepository.save(b);
        return "Updated";
    }
}
