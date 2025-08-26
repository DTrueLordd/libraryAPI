package org.example.springbook.BookPackage;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private String title;
    private String author;
    private int year;
    private String genre;

    public BookDTO(){

    }


    public BookDTO(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

}
