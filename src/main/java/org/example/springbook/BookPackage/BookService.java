package org.example.springbook.BookPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;


    @Autowired
    public BookService( BookRepository repository){
        this.repository = repository;
    }

    public List<BookDTO> getAllBooks(){
       List<Book> books = repository.findAll();
        System.out.println(BookMapper.mapListOfBooksToDTO(books));
       return BookMapper.mapListOfBooksToDTO(books);
    }

    public BookDTO getBookById(Long id){
        Book book = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found")
        );

        return BookMapper.mapBookToDTO(book);
    }

    public Book createBook(Book book){
       return repository.save(book);
    }

    public Book updateBook(Long id, Book newBook){
        Book book = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found")
        );

        book.setTitle(newBook.getTitle());
        book.setGenre(newBook.getGenre());
        book.setAuthor(newBook.getAuthor());
        book.setYear(newBook.getYear());

        return repository.save(book);
    }

}
