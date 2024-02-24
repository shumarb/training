package com.bookzone.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.bookzone.model.SpecialBook;

class SpecialBookTest {

	@Mock
	SpecialBook book1;
	
	@Mock
	SpecialBook book2;
	
	@BeforeEach
	void setUp() throws Exception {
		book1 = new SpecialBook(1, "King: A Life", "R.F.Kuang", "Fiction", 2023);
		book2 = new SpecialBook(2, "The Bad Beginning", "Daniel Handler", "Novel", 1999);
	}

	@Test
	void checksTitle_returnsCorrectTitle() {
		
		assertEquals("King: A Life", book1.getTitle());
		
	}
	
	@Test
	void checksTitle_doesNotReturnIncorrectTitle() {
		
		assertNotEquals(book2.getTitle(), book1.getTitle());
		
	}
	
	@Test
	void checksTitle_doesNotReturnNullForCorrectTitle() {
		
		assertNotEquals(null, book1.getAuthor());
		
	}
	
	@Test
	void checksAuthor_returnsCorrectAuthor() {
	
		assertEquals("Daniel Handler", book2.getAuthor());
		
	}
	
	@Test
	void checksAuthor_doesNotReturnIncorrectAuthor() {
		
		assertNotEquals(book1.getAuthor(), book2.getAuthor());
		
	}
	
	@Test
	void checksAuthor_doesNotReturnNullForCorrectAuthor() {
		
		assertNotEquals(null, book1.getAuthor());
		
	}
	
	@Test
	void checksYear_returnsCorrectYear() {
		
		assertEquals(2023, book1.getYear());
		
	}
	
	@Test
	void checksYear_doesNotReturnIncorrectPrice() {
		
		assertNotEquals(book2.getYear(), book1.getYear());
		
	}
	
	@Test
	void checksCategory_returnsCorrectCategory() {
		
		assertEquals("Novel", book2.getCategory());
		
	}
	
	@Test
	void checksCategory_doesNotReturnIncorrectCategory() {
		
		assertNotEquals(book1.getCategory(), book2.getCategory());
		
	}
	
	@Test
	void checksCategory_doesNotReturnNullForCorrectUser() {
		
		assertNotEquals(null, book2.getCategory());
		
	}
	
	@Test
	void checksId_returnsCorrectId() {
		
		assertEquals(1, book1.getId());
		
	}
	
	@Test
	void checksId_doesNotReturnIncorrectId() {
		
		assertNotEquals(book2.getId(), book1.getId());
		
	}

}
