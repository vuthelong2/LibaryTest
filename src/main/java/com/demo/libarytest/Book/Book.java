package com.demo.libarytest.Book;

import com.demo.libarytest.Borrow.Borrow;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table
public class Book {

    private static final String SQ_CLIENT = "a";
    @Id
    @SequenceGenerator(name = SQ_CLIENT, sequenceName = SQ_CLIENT,
            allocationSize = 1,initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_CLIENT)

    private Long id;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL) // Quan hệ n-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    // MapopedBy trỏ tới tên biến Address ở trong Person.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<Borrow> borrows;
    private String name;

    private String type;
    private String author;


    private int quantity;
    private Date inputDay;

    public Book(java.util.Collection<Borrow> borrows, String name, String type, String author, int quantity, Date inputDay) {
        this.borrows = borrows;
        this.name = name;
        this.type = type;
        this.author = author;
        this.quantity = quantity;
        this.inputDay = inputDay;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getInputDay() {
        return inputDay;
    }

    public void setInputDay(Date inputDay) {
        this.inputDay = inputDay;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                ", inputDay=" + inputDay +
                '}';
    }
}
