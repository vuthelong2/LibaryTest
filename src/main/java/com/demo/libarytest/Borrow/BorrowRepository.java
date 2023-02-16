package com.demo.libarytest.Borrow;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Long> {
    Borrow getBorrowById(Long id);
}
