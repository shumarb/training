package com.bookzone.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookzone.model.Book;
import com.bookzone.repository.BookRepository;
import com.bookzone.service.BookService;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
    	book1 = new Book(11, "Trust", "Herman Diaz", "Novel", 2022);
    	book2 = new Book(23, "The Reptile Room", "Daniel Handler", "Fiction", 1999);
    }

    @Test
    void testSave() {
        bookService.saveBook(book1);
        verify(bookRepository, times(1)).save(book1);
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = new ArrayList<> ();
        books.add(book1);
        books.add(book2);
        
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> result = bookService.getAllBooks();

        assertEquals(books.size(), result.size());
        assertEquals(books, result);
    }

    @Test
    void testGetBookById() {
        long id = book1.getId();
        when(bookRepository.findById(id)).thenReturn(Optional.of(book1));
        Book result = bookService.getBookById(id);
        assertEquals(book1, result);
    }

    @Test
    void testDeleteById() {
        long id = book1.getId();
        doNothing().when(bookRepository).deleteById(id);
        bookService.deleteById(id);
        verify(bookRepository, times(1)).deleteById(id);
    }
    
}

