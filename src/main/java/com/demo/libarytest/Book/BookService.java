package com.demo.libarytest.Book;

import com.demo.libarytest.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    ResponseEntity<ResponseObject> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", bookRepository.findAll())
        );
    }
    ResponseEntity<ResponseObject> searchBooks(String name) {
        if(name != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "good", bookRepository.findAll(name))
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", bookRepository.findAll())
        );
    }
    ResponseEntity<ResponseObject> addNewBooks(Book book) {
        if (bookRepository.findBookByName(book.getName()) != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("book exist", "not good", book)
            );
        }
        if(book.getQuantity() <=0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("book's quantity must be more than 0", "not good", book)
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", bookRepository.save(book))
        );
    }
    ResponseEntity<ResponseObject>  getBookById(Long id) {
        if (bookRepository.findBookById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", bookRepository.findBookById(id))
        );
    }
    ResponseEntity<ResponseObject> deleteBook(Long id) {
        if (bookRepository.findBookById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        bookRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "delete success", "")
        );
    }

    ResponseEntity<ResponseObject> updateBook(Long id, Book book) {
        Book updateBook = bookRepository.findBookById(id);
        updateBook.setName(book.getName());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setType(book.getType());
        updateBook.setQuantity(book.getQuantity());
        updateBook.setInputDay(book.getInputDay());
        if(updateBook.getQuantity() <= 0){
            bookRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "delete success", "")
            );
        }
        if (bookRepository.findBookById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        } else if (bookRepository.findBookByName(updateBook.getName()) != null && updateBook != bookRepository.findBookById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("email exist", "not good", "")
            );

        }else
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "good", bookRepository.save(updateBook))
            );
    }

}
