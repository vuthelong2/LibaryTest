package com.demo.libarytest.Borrow;

import com.demo.libarytest.Book.Book;
import com.demo.libarytest.ReturnCard.ReturnCard;
import com.demo.libarytest.User.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Book> books ;


    @OneToMany
    private Collection<ReturnCard> returnCards;
    private Date borrowDate;
    private Date needReturnDate;

    public Borrow() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getNeedReturnDate() {
        return needReturnDate;
    }

    public void setNeedReturnDate(Date needReturnDate) {
        this.needReturnDate = needReturnDate;
    }


    public Borrow(List<Book> books, Collection<ReturnCard> returnCards, Date borrowDate, Date needReturnDate) {
        this.books = books;
        this.returnCards = returnCards;
        this.borrowDate = borrowDate;
        this.needReturnDate = needReturnDate;
    }

    public Collection<ReturnCard> getReturnCards() {
        return returnCards;
    }

    public void setReturnCards(Collection<ReturnCard> returnCards) {
        this.returnCards = returnCards;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "books=" + books +
                ", borrowDate=" + borrowDate +
                ", needReturnDate=" + needReturnDate +
                '}';
    }
}
