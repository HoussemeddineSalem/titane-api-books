package dev.titane.apibooks.services;

import dev.titane.apibooks.models.BookDTO;

import java.util.List;

public interface BookService {

    Long createBook(BookDTO bookDTO);

    List<BookDTO> getBook(String title, String author);

    BookDTO updateBook(Long bookId, BookDTO bookDTO);

    void deleteBook(Long bookId);
}
