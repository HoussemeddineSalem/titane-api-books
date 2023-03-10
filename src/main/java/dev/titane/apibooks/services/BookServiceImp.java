package dev.titane.apibooks.services;

import dev.titane.apibooks.entities.Book;
import dev.titane.apibooks.errors.ErrorResponses;
import dev.titane.apibooks.models.BookDTO;
import dev.titane.apibooks.repositories.BookRepository;
import dev.titane.apibooks.utils.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImp implements BookService {

    BookMapper bookMapper;
    BookRepository bookRepository;

    @Override
    public Long createBook(BookDTO bookDTO) {
        Book book = bookMapper.toDAO(bookDTO);
        bookRepository.save(book);

        return book.getId();

    }

    @Override
    public List<BookDTO> getBooks(Long id,String title, String author) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();

        Example<Book> exampleQuery = Example.of(new Book(id, title, author), matcher);
        List<Book> bookList = bookRepository.findAll(exampleQuery);

        return bookList.stream().map(book -> bookMapper.toDTO(book)).collect(Collectors.toList());
    }

    @Override
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> {
                    throw new RuntimeException(ErrorResponses.NO_BOOKS_FOUND.getMessage());
                });

        bookMapper.updateDAO(bookDTO, book);
        bookRepository.save(book);

        return bookMapper.toDTO(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
