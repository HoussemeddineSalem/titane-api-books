package dev.titane.apibooks.controllers;

import dev.titane.apibooks.models.BookDTO;
import dev.titane.apibooks.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/book")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BookController {

    BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getBook(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        return bookService.getBooks(id,title, author);
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(bookId, bookDTO);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }

}
