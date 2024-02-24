package com.bookzone.controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookzone.controller.ErrorPageController;

@ExtendWith(MockitoExtension.class)
class ErrorPageControllerTest {

	@Mock
	private ErrorPageController errorController;
	
	@BeforeEach
	void setUp() throws Exception {
		errorController = new ErrorPageController();
	}

	@Test
	void testGoesToErrorPage() {
		String result = errorController.goesToError();
		assertEquals(result, "error");
	}
	
	@Test
	void testDoesNotGoToOtherPage() {
		String result = errorController.goesToError();
		assertNotEquals(result, "catalogue");
	}

}
