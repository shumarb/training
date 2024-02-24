package com.bookzone.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.bookzone.model.Librarian;

class LibrarianTest {

	@Mock
	Librarian librarian1;
	
	@Mock
	Librarian librarian2;
	
	@BeforeEach
	void setUp() throws Exception {
		librarian1 = new Librarian(1, "Lucy Tan", "lucy.tan@bookzone.com", "Lf21SafS@");
		librarian2 = new Librarian(2, "Farah Ali", "farah.ali@bookzone.com", "M8@fz23");
	}
	
	@Test
	void checkId_returnsCorrectId() {
		
		assertEquals(1, librarian1.getId());
		
	}
	
	@Test
	void checkId_doesNotReturnInorrectId() {
		
		assertNotEquals(librarian2.getId(), librarian1.getId());
		
	}
	
	@Test
	void checkName_returnsCorrectName() {
		
		assertEquals("Farah Ali", librarian2.getName());
		
	}
	
	@Test
	void checkName_doesNotReturnIncorrectName() {
		
		assertNotEquals(librarian1.getName(), librarian2.getName());
		
	}
	
	@Test
	void checkName_doesNotReturnNullForExistingLibrarian() {
		
		assertNotEquals(null, librarian2.getName());
		
	}
	
	@Test
	void checkEmail_returnsCorrectEmail() {
		
		assertEquals("farah.ali@bookzone.com", librarian2.getEmail());
		
	}
	
	@Test
	void checkEmail_doesNotReturnIncorrectEmail() {
		
		assertNotEquals(librarian1.getEmail(), librarian2.getEmail());
		
	}
	
	@Test
	void checkEmail_doesNotReturnNullForExistingLibrarian() {
		
		assertNotEquals(null, librarian2.getEmail());
		
	}

	@Test
	void checkPassword_returnsCorrectPassword() {
		
		assertEquals("Lf21SafS@", librarian1.getPassword());
		
	}
	
	@Test
	void checkPassword_doesNotReturnIncorrectEmail() {
		
		assertNotEquals(librarian1.getPassword(), librarian2.getPassword());
		
	}
	
	@Test
	void checkPassword_doesNotReturnNullForExistingLibrarian() {
		
		assertNotEquals(null, librarian1.getPassword());
		
	}
	
}
