package com.demo.libarytest.Book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Library/Books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    ResponseEntity searchAllBook(@Param("name") String name) {
        return bookService.searchBooks(name);
    }
    @GetMapping()
    ResponseEntity getAllBook() {
        return bookService.getAllBooks();
    }
    @PostMapping("/insert")
    ResponseEntity addNewBook(@RequestBody Book book) {
        return bookService.addNewBooks(book);
    }

    @GetMapping("{id}")
    ResponseEntity getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteAccount(@PathVariable Long id) {
        return bookService.deleteBook(id);

    }

    @PutMapping("/update/{id}")
    ResponseEntity updateAccount(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);

    }


}