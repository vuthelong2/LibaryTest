package com.demo.libarytest.Account;

import com.demo.libarytest.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }
    ResponseEntity<ResponseObject>  getAccountByID(Long id) {
        if (accountRepository.findAccountById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", "")
        );
    }
    ResponseEntity<ResponseObject> addNewAccount(Account account) {
        if (accountRepository.findAccountByEmail(account.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("email exist", "not good", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", accountRepository.save(account))
        );
    }

    ResponseEntity<ResponseObject> deleteAccount(Long id) {
        if (accountRepository.findAccountById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("email exist", "not good", "")
            );
        }
        accountRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", "")
        );
    }

    ResponseEntity<ResponseObject> updateAccount(Long id, Account account) {
        Account updateAccount = accountRepository.findAccountById(id);
        updateAccount.setEmail(account.getEmail());
        updateAccount.setName(account.getName());
        updateAccount.setPassword(account.getPassword());
        if (accountRepository.findAccountById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        } else if (accountRepository.findAccountByEmail(updateAccount.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("email exist", "not good", "")
            );

        }else
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", accountRepository.save(updateAccount))
        );
    }
}
