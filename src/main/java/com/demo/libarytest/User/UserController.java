package com.demo.libarytest.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Library/Users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/insert")
    ResponseEntity addNewBook(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("{id}")
    ResponseEntity getBookById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteAccount(@PathVariable Long id) {
        return userService.deleteUser(id);

    }

    @PutMapping("/update/{id}")
    ResponseEntity updateAccount(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);

    }






}
