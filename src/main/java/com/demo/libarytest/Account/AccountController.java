package com.demo.libarytest.Account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Library/Accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public List<Account> getAllAccount() {

        return accountService.getAllAccount();
    }
    @GetMapping("{id}")
    ResponseEntity getAccountByID(@PathVariable Long id) {
        return accountService.getAccountByID(id);
    }

    @PostMapping("/insert")
    ResponseEntity addNewAccount(@RequestBody Account account) {

        return accountService.addNewAccount(account);

    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);

    }

    @PutMapping("/update/{id}")
    ResponseEntity updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);

    }
}
