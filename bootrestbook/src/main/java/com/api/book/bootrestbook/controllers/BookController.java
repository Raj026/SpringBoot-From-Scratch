package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Books;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    // @RequestMapping(value = "/books", method = RequestMethod.GET) // Instead of this Request mapping we can also use get mapping
    // @ResponseBody //If we use Rest COntroller instead of COntroller then no need of ResponseBody
    @GetMapping("/books")
    public List<Books> getBooks(){
        // Books book = new Books();
        // book.setId(12);
        // book.setTitle("Java Programming guide");
        // book.setAuthor("XYZ");
        // return book;
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Books getBook(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Books addBook(@RequestBody Books book){
        Books b = this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        return this.bookService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public String updateBook(@RequestBody Books b,@PathVariable("id") int id) {
        return this.bookService.updateBook(b, id);
    }
}
