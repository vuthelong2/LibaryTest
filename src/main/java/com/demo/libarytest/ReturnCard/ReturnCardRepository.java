package com.demo.libarytest.ReturnCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface ReturnCardRepository extends JpaRepository<ReturnCard,Long> {


@Query(value = " SELECT b.needReturnDate from Borrow b join ReturnCard r on r.borrow.id = b.id where b.id = ?1")
    Date getDate(Long id);

}
