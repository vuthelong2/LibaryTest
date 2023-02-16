package com.demo.libarytest.ReturnCard;

import com.demo.libarytest.Book.Book;
import com.demo.libarytest.Borrow.Borrow;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "return_card")
public class ReturnCard{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date returnDate;
    @ManyToOne
    @JoinColumn(name = "borrow_id")
    private Borrow borrow;


    private Double money = (double) 0;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Double getMoney() {

        return money;

    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public ReturnCard() {

    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public ReturnCard(Date returnDate, Borrow borrow, Double money) {
        this.returnDate = returnDate;
        this.borrow = borrow;
        this.money = money;
    }
}
