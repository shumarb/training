package com.bookzone.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.bookzone.controller.LibrarianController;
import com.bookzone.model.Librarian;
import com.bookzone.repository.LibrarianRepository;
import com.bookzone.service.LibrarianService;

@ExtendWith(MockitoExtension.class)
class LibrarianControllerTest {

    @Mock
    private LibrarianController librarianController;

    @Mock
    private LibrarianService librarianService;
    
    @Mock
    private LibrarianRepository librarianRepository;

    @Mock
    private Model model;
    
    @Mock
    private Librarian librarian1;
    
    @Mock
    private Librarian librarian2;

    @BeforeEach
	void setUp() throws Exception {
		librarianController = new LibrarianController();
		librarianService = new LibrarianService();
		librarian1 = new Librarian("John Brooks", "john.brooks@sgbookcollectors.com", "OOO123mmm");
		librarian2 = new Librarian("Chris Evans", "chris.evans@gmailcom.com", "CHRisEVANs12344");
	}
    
    @Test
    void testGoToIndex() {
        String result = librarianController.goToIndex();
        assertEquals("index", result);
    }

    @Test
    void testGoToHome() {
        String result = librarianController.goToHome();
        assertEquals("home", result);
    }

    @Test
    void testGoToLogin() {
        String result = librarianController.goToLogin();
        assertEquals("login", result);
    }

    @Test
    void testGoToRegistration() {
        String result = librarianController.goToRegistration();
        assertEquals("register", result);
    }
    
    @Test
    void testLogoutLibrarian() {
        String result = librarianController.logoutLibrarian();
        assertEquals("redirect:/", result);
    }
}
