package com.bookzone.serviceTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookzone.model.Librarian;
import com.bookzone.repository.LibrarianRepository;
import com.bookzone.service.LibrarianService;

@ExtendWith(MockitoExtension.class)
class LibrarianServiceTest {

    @Mock
    private LibrarianRepository librarianRepository;

    @InjectMocks
    private LibrarianService librarianService;

    @Test
    void testIsValidEmailAddress_validExistingEmail() {
        String email = "john.tan@sgbookcollectors.com";
        when(librarianRepository.findByEmail(email)).thenReturn(Optional.of(new Librarian()));
        boolean result = librarianService.isValidEmailAddress(email);
        assertFalse(result);
    }

    @Test
    void testIsValidEmailAddress_validNewEmail() {
        String email = "john.wayne@sgbookcollectors.com";
        when(librarianRepository.findByEmail(email)).thenReturn(Optional.empty());
        boolean result = librarianService.isValidEmailAddress(email);
        assertTrue(result);
    }

    @Test
    void testIsValidPassword_validPassword() {
        String password = "SSSSSSSnnnnn981231";
        boolean result = librarianService.isValidPassword(password);
        assertTrue(result);
    }

    @Test
    void testIsValidPassword_invalidPassword_insufficientUpperCaseLetters() {
        String password = "WWmmm11";
        boolean result = librarianService.isValidPassword(password);
        assertFalse(result);
    }

    @Test
    void testIsValidName_validName() {
        String name = "John Doe";
        boolean result = librarianService.isValidName(name);
        assertTrue(result);
    }

    @Test
    void testIsValidName_InvalidName() {
        String name = "John";
        boolean result = librarianService.isValidName(name);
        assertFalse(result);
    }

    @Test
    void testLoginLibrarian_existingEmailAndWrongPassword() {
        String email = "john.tan@sgbookcollectors.com";
        String password = "PPPlll333";
        Librarian librarian = new Librarian();
        librarian.setPassword("StrongPassword");
        when(librarianRepository.findByEmail(email)).thenReturn(Optional.of(librarian));

        boolean result = librarianService.loginLibrarian(email, password);
        assertFalse(result);
    }

}

