package org.example.springbook.BookPackage;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity



@Table(name = "books")

@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int year;
    private String genre;

    public Book() {

    }

    public Book(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }
}
