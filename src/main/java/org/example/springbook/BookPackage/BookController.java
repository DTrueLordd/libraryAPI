package org.example.springbook.BookPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping()
    public String libraryPage(){
        return "index";
    }


    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        BookDTO book = service.getBookById(id);
        return ResponseEntity.ok(book);
    }


    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book saved = service.createBook(book);
        return ResponseEntity.created(
                        URI.create("/books" + saved.getId()))
                .body(saved);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updated = service.updateBook(id, book);
        return ResponseEntity.ok(updated);
    }
}
