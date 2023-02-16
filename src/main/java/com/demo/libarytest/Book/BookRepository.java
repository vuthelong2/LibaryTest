package com.demo.libarytest.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

   Book findBookByName(String name);
    Book findBookById(Long id);
    @Query("SELECT p from Book p WHERE p.name LIKE %?1%")
    List<Book> findAll(String name);
}
