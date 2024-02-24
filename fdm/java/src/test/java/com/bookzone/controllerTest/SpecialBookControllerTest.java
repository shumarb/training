package com.bookzone.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.bookzone.controller.SpecialBookController;
import com.bookzone.service.SpecialBookService;

@ExtendWith(MockitoExtension.class)
class SpecialBookControllerTest {

    @Mock
    private SpecialBookService specialBookService;

    @Mock
    private Model model;

    @InjectMocks
    private SpecialBookController specialBookController;

    @Test
    void testDeleteSpecialBook() {
        long id = 4;
        String expectedRedirect = "redirect:/specials";
        String actualRedirect = specialBookController.deleteSpecialBook(id);
        verify(specialBookService, times(1)).deleteSpecialBookById(id);
        assertEquals(expectedRedirect, actualRedirect);
    }

}
