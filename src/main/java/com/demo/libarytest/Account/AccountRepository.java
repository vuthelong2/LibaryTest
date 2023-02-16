package com.demo.libarytest.Account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findAccountByEmail(String email);
    Account findAccountById(Long id);
    List<Account> findAccountsByEmailContains(String email);
}
