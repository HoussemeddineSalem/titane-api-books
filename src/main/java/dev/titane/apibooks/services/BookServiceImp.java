package dev.titane.apibooks.services;

import dev.titane.apibooks.models.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService{
    @Override
    public Long createBook(BookDTO bookDTO) {
        return null;
    }

    @Override
    public List<BookDTO> getBook(String title, String author) {
        return null;
    }

    @Override
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        return null;
    }

    @Override
    public void deleteBook(Long bookId) {

    }
}
