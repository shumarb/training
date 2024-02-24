package com.bookzone.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookzone.model.SpecialBook;
import com.bookzone.repository.SpecialBookRepository;

@ExtendWith(MockitoExtension.class)
class SpecialBookRepositoryTest {

    @Mock
    private SpecialBookRepository specialBookRepository;

    @Test
    void testFindById() {
    	long id = 1;
        SpecialBook specialbook1 = new SpecialBook(1, "Trust", "Herman Diaz", "Novel", 2022);
        when(specialBookRepository.findById(id)).thenReturn(Optional.of(specialbook1));

        Optional<SpecialBook> optionalSpecialBook = specialBookRepository.findById(id);

        verify(specialBookRepository).findById(id);
        assertEquals(specialbook1, optionalSpecialBook.orElse(null));
    }
    
}
