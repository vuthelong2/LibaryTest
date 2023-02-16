package com.demo.libarytest.ReturnCard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Library/ReturnCard")
public class ReturnCardController {
    private final ReturnCardService returnCardService;

    public ReturnCardController(ReturnCardService returnCardService) {
        this.returnCardService = returnCardService;
    }

    @PostMapping("/insert")
    ResponseEntity addNewBorrow(@RequestBody ReturnCard borrow) {
        return returnCardService.addNewReturn(borrow);
    }

    @GetMapping
    public List<ReturnCard> getAllBorrow(){
        return returnCardService.getAllReturn();
    }



    @GetMapping("{id}")
    ResponseEntity getReturnById(@PathVariable Long id) {
        return returnCardService.getReturnById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteReturn(@PathVariable Long id) {
        return returnCardService.deleteReturn(id);

    }
}
