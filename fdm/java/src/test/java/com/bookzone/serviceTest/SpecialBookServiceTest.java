package com.bookzone.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
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

import com.bookzone.model.SpecialBook;
import com.bookzone.repository.SpecialBookRepository;
import com.bookzone.service.SpecialBookService;

@ExtendWith(MockitoExtension.class)
class SpecialBookServiceTest {

    @Mock
    private SpecialBookRepository specialBookRepository;

    @InjectMocks
    private SpecialBookService specialBookService;

    private SpecialBook specialBook1;
    private SpecialBook specialBook2;

    @BeforeEach
    void setUp() {
        specialBook1 = new SpecialBook(11, "Trust", "Herman Diaz", "Novel", 2022);
        specialBook2 = new SpecialBook(23, "The Reptile Room", "Daniel Handler", "Fiction", 1999);
    }

    @Test
    void testSaveMyBooks() {
        specialBookService.saveSpecialBook(specialBook1);
        verify(specialBookRepository, times(1)).save(specialBook1);
    }

    @Test
    void testGetAllMyBooks() {
        List<SpecialBook> specialBooks = new ArrayList<>();
        specialBooks.add(specialBook1);
        specialBooks.add(specialBook2);
        when(specialBookRepository.findAll()).thenReturn(specialBooks);

        List<SpecialBook> result = specialBookService.getAllSpecialBooks();
        assertEquals(specialBooks.size(), result.size());
        assertEquals(specialBooks, result);
    }

    @Test
    void testDeleteById() {
        long id = specialBook1.getId();
        doNothing().when(specialBookRepository).deleteById(id);
        specialBookService.deleteSpecialBookById(id);
        verify(specialBookRepository, times(1)).deleteById(id);
    }
    
}
