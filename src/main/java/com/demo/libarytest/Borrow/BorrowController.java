package com.demo.libarytest.Borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Library/Borrows")
public class BorrowController {
    private final BorrowService borrowService;
@Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }


    @PostMapping("/insert")
    ResponseEntity addNewBorrow(@RequestBody Borrow borrow) {
        return borrowService.addNewBorrow(borrow);
    }

    @GetMapping
    public List<Borrow> getAllBorrow(){
        return borrowService.getAllBorrows();
    }



    @GetMapping("{id}")
    ResponseEntity getBookById(@PathVariable Long id) {
        return borrowService.getBorrowById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteAccount(@PathVariable Long id) {
        return borrowService.deleteBook(    id);

    }

}
