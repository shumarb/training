package com.bookzone.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookzone.model.Librarian;
import com.bookzone.repository.LibrarianRepository;

@ExtendWith(MockitoExtension.class)
class LibrarianRepositoryTest {

    @Mock
    private LibrarianRepository librarianRepository;

    @Test
    void testFindByEmail() {
        String email = "mike.lee@sgbookcollectors.com";
        Librarian librarian = new Librarian(1, "Mike Lee", email, "MMM22llla3");
        when(librarianRepository.findByEmail(email)).thenReturn(Optional.of(librarian));

        Optional<Librarian> optionalLibrarian = librarianRepository.findByEmail(email);

        verify(librarianRepository).findByEmail(email);
        assertEquals(librarian, optionalLibrarian.orElse(null));
    }
}
