package com.bookzone.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.bookzone.model.Book;

class BookTest {

	@Mock
	Book book1;
	
	@Mock
	Book book2;
	
	@BeforeEach
	void setUp() throws Exception {
		book1 = new Book(1, "King: A Life", "R.F. Kuang", "Fiction", 2023);
		book2 = new Book(2, "The Bad Beginning", "Daniel Handler", "Novel", 1999);
	}

	@Test
	void testTitle_returnsCorrectTitle() {
		
		assertEquals("King: A Life", book1.getTitle());
		
	}
	
	@Test
	void testTitle_doesNotReturnIncorrectTitle() {
		
		assertNotEquals(book2.getTitle(), book1.getTitle());
		
	}
	
	@Test
	void testTitle_doesNotReturnNullForCorrectTitle() {
		
		assertNotEquals(null, book1.getAuthor());
		
	}
	
	@Test
	void testAuthor_returnsCorrectAuthor() {
	
		assertEquals("Daniel Handler", book2.getAuthor());
		
	}
	
	@Test
	void testAuthor_doesNotReturnIncorrectAuthor() {
		
		assertNotEquals(book1.getAuthor(), book2.getAuthor());
		
	}
	
	@Test
	void testAuthor_doesNotReturnNullForCorrectAuthor() {
		
		assertNotEquals(null, book1.getAuthor());
		
	}
	
	@Test
	void testYear_returnsCorrectYear() {
		
		assertEquals(2023, book1.getYear());
		
	}
	
	@Test
	void testYear_doesNotReturnIncorrectPrice() {
		
		assertNotEquals(book2.getYear(), book1.getYear());
		
	}
	
	@Test
	void testCategory_returnsCorrectCategory() {
		
		assertEquals("Novel", book2.getCategory());
		
	}
	
	@Test
	void testCategory_doesNotReturnIncorrectCategory() {
		
		assertNotEquals(book1.getCategory(), book2.getCategory());
		
	}
	
	@Test
	void testCategory_doesNotReturnNullForCorrectUser() {
		
		assertNotEquals(null, book2.getCategory());
		
	}
	
	@Test
	void testId_returnsCorrectId() {
		
		assertEquals(1, book1.getId());
		
	}
	
	@Test
	void testId_doesNotReturnIncorrectId() {
		
		assertNotEquals(book2.getId(), book1.getId());
		
	}

}
