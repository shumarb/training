package com.bookzone.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookzone.model.Book;
import com.bookzone.repository.BookRepository;
import com.bookzone.service.BookService;

@ExtendWith(MockitoExtension.class)
class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testFindById() {
        long id = 1;
        Book book1 = new Book(1, "Trust", "Herman Diaz", "Novel", 2022);
        when(bookRepository.findById(id)).thenReturn(Optional.of(book1));

        Optional<Book> optionalBook = bookRepository.findById(id);

        verify(bookRepository).findById(id);
        assertEquals(book1, optionalBook.orElse(null));
    }
}
