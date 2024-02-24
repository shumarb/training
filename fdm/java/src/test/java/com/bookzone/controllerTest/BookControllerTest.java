package com.bookzone.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.bookzone.controller.BookController;
import com.bookzone.model.Book;
import com.bookzone.model.SpecialBook;
import com.bookzone.service.BookService;
import com.bookzone.service.SpecialBookService;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    BookService bookService;

    @Mock
    SpecialBookService specialBookService;

    @InjectMocks
    BookController bookController;

    Book book1;
    
    Book book2;

    @BeforeEach
    void setUp() throws Exception {
        book1 = new Book(1, "Trust", "Herman Diaz", "Novel", 2022);
        book2 = new Book(2, "The Reptile Room", "Daniel Handler", "Fiction", 1999);
    }

    @Test
    void testAddBook() {
    	
        doNothing().when(bookService).saveBook(book1);
        String result = bookController.addBook(book1);
        verify(bookService, times(1)).saveBook(book1);
        assertEquals("redirect:/catalogue", result);
        
    }
    
    @Test
    void testEditBook() {
        long id = 1L;
        Book book = new Book(id, "Title", "Author", "Category", 2022);
        Model model = mock(Model.class);

        when(bookService.getBookById(id)).thenReturn(book);

        String viewName = bookController.editBook(id, model);

        assertEquals("edit", viewName);
        verify(model, times(1)).addAttribute("book", book);
    }
    
    @Test
    void testDeleteBook() {
        long id = 1;

        String result = bookController.deleteBook(id);

        assertEquals("redirect:/catalogue", result);
        verify(specialBookService, times(1)).deleteSpecialBookById(id);
        verify(bookService, times(1)).deleteById(id);
    }
    
    @Test
    void testGetAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        when(bookService.getAllBooks()).thenReturn(bookList);

        ModelAndView modelAndView = bookController.getAllBooks();

        assertEquals("catalogue", modelAndView.getViewName());
        assertEquals(bookList, modelAndView.getModel().get("book"));
    }

    @Test
    void testAddBookToSpecials() {
        long id = 2;
        Book book = new Book(id, "Title", "Author", "Category", 2022);

        when(bookService.getBookById(id)).thenReturn(book);
        doNothing().when(specialBookService).saveSpecialBook(any(SpecialBook.class));

        String result = bookController.addBookToSpecials(id);

        assertEquals("redirect:/specials", result);
    }
    
    @Test
    void testGetSpecialBooks() {
        List<SpecialBook> specialBookList = new ArrayList<>();
        specialBookList.add(new SpecialBook());
        specialBookList.add(new SpecialBook());

        Model model = mock(Model.class);

        when(specialBookService.getAllSpecialBooks()).thenReturn(specialBookList);

        String viewName = bookController.getSpecialBooks(model);

        assertEquals("specials", viewName);
        verify(model, times(1)).addAttribute("book", specialBookList);
    }

}
