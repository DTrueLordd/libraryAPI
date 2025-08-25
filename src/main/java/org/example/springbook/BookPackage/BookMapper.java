package org.example.springbook.BookPackage;

import java.util.ArrayList;
import java.util.List;


public class BookMapper {

    public static BookDTO mapBookToDTO(Book book){
        return new BookDTO(book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre());
    }

    public static List<BookDTO> mapListOfBooksToDTO(List<Book> books){
        List<BookDTO> booksDTO = new ArrayList<>();
        for(Book book : books){
           BookDTO bookDTO = BookMapper.mapBookToDTO(book);
           booksDTO.add(bookDTO);
        }
        return booksDTO;
    }
}
