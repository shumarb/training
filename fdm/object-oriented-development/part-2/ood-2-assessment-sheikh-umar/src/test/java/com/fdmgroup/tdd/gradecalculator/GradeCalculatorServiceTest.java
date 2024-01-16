package com.fdmgroup.tdd.gradecalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeCalculatorServiceTest {

	MyGrade myGrade;
	
	@BeforeEach
	void setUp() throws Exception {
		// Arrange
		myGrade = new MyGrade();
	}
	
	
	// Tests for scores < 75
	@Test
	public void test_returnFail_whenMark10IsPassed() {
		// Act
		String classification = myGrade.getClassification(10.0);
		
		// Assert
		assertEquals(classification, "fail");
	}
	
	@Test
	public void test_doesNotReturnPass_whenMark10IsPassed() {
		// Act
		String classification = myGrade.getClassification(10.0);
		
		// Assert
		assertNotEquals(classification, "pass");
	}
	
	@Test
	public void test_doesNotReturnMerit_whenMark10IsPassed() {
		// Act
		String classification = myGrade.getClassification(10.0);
		
		// Assert
		assertNotEquals(classification, "merit");
	}
	
	@Test
	public void test_doesNotReturnDistinction_whenMark10IsPassed() {
		// Act
		String classification = myGrade.getClassification(10.0);
		
		// Assert
		assertNotEquals(classification, "distinction");
	}
	
	@Test
	public void test_doesNotReturnNull_whenMark10IsPassed() {
		// Act
		String classification = myGrade.getClassification(10.0);
		
		// Assert
		assertNotEquals(classification, null);
	}
	
	
	// Tests for scores >= 75 and < 80
	@Test
	public void test_returnPass_whenMark77IsPassed() {
		// Act
		String classification = myGrade.getClassification(77.0);
		
		// Assert
		assertEquals(classification, "pass");
	}
	
	@Test
	public void test_doesNotReturnFail_whenMark77IsPassed() {
		// Act
		String classification = myGrade.getClassification(77.0);
		
		// Assert
		assertNotEquals(classification, "fail");
	}
	
	@Test
	public void test_doesNotReturnMerit_whenMark77IsPassed() {
		// Act
		String classification = myGrade.getClassification(77.0);
		
		// Assert
		assertNotEquals(classification, "merit");
	}
	
	@Test
	public void test_doesNotReturnDistinction_whenMark77IsPassed() {
		// Act
		String classification = myGrade.getClassification(77.0);
		
		// Assert
		assertNotEquals(classification, "distinction");
	}
	
	@Test
	public void test_doesNotReturnNull_whenMark77IsPassed() {
		// Act
		String classification = myGrade.getClassification(77.0);
		
		// Assert
		assertNotEquals(classification, null);
	}
	
	
	// Tests for scores >= 80 and < 90
	@Test
	public void test_returnMerit_whenMark82IsPassed() {
		// Act
		String classification = myGrade.getClassification(82.0);
		
		// Assert
		assertEquals(classification, "merit");
	}
	
	@Test
	public void test_doesNotReturnFail_whenMark82IsPassed() {
		// Act
		String classification = myGrade.getClassification(82.0);
		
		// Assert
		assertNotEquals(classification, "fail");
	}
	
	@Test
	public void test_doesNotReturnPass_whenMark82IsPassed() {
		// Act
		String classification = myGrade.getClassification(82.0);
		
		// Assert
		assertNotEquals(classification, "pass");
	}
	
	@Test
	public void test_doesNotReturnDistinction_whenMark82IsPassed() {
		// Act
		String classification = myGrade.getClassification(82.0);
		
		// Assert
		assertNotEquals(classification, "distinction");
	}
	
	@Test
	public void test_doesNotReturnNull_whenMark82IsPassed() {
		// Act
		String classification = myGrade.getClassification(82.0);
		
		// Assert
		assertNotEquals(classification, null);
	}
	
	
	// Tests for scores >= 90 and <= 100
	@Test
	public void test_returnDistinction_whenMark95IsPassed() {
		// Act
		String classification = myGrade.getClassification(95.0);
		
		// Assert
		assertEquals(classification, "distinction");
	}
	
	@Test
	public void test_doesNotReturnFail_whenMark95IsPassed() {
		// Act
		String classification = myGrade.getClassification(95.0);
		
		// Assert
		assertNotEquals(classification, "fail");
	}
	
	@Test
	public void test_doesNotReturnPass_whenMark95IsPassed() {
		// Act
		String classification = myGrade.getClassification(95.0);
		
		// Assert
		assertNotEquals(classification, "pass");
	}
	
	@Test
	public void test_doesNotReturnMerit_whenMark95IsPassed() {
		// Act
		String classification = myGrade.getClassification(95.0);
		
		// Assert
		assertNotEquals(classification, "merit");
	}
	
	@Test
	public void test_doesNotReturnNull_whenMark95IsPassed() {
		// Act
		String classification = myGrade.getClassification(95.0);
		
		// Assert
		assertNotEquals(classification, null);
	}
	
	
	// Tests for scores > 100
	@Test
	public void test_returnNull_whenMark101IsPassed() {
		// Act
		String classification = myGrade.getClassification(101.0);
		
		// Assert
		assertEquals(classification, null);
	}
	
	@Test
	public void test_doesNotReturnFail_whenMark101IsPassed() {
		// Act
		String classification = myGrade.getClassification(101.0);
		
		// Assert
		assertNotEquals(classification, "fail");
	}
	
	@Test
	public void test_doesNotReturnPass_whenMark101IsPassed() {
		// Act
		String classification = myGrade.getClassification(101.0);
		
		// Assert
		assertNotEquals(classification, "pass");
	}
	
	@Test
	public void test_doesNotReturnMerit_whenMark101IsPassed() {
		// Act
		String classification = myGrade.getClassification(101.0);
		
		// Assert
		assertNotEquals(classification, "merit");
	}
	
	@Test
	public void test_doesNotReturnDistinction_whenMark101IsPassed() {
		// Act
		String classification = myGrade.getClassification(101.0);
		
		// Assert
		assertNotEquals(classification, "distinction");
	}
	
}
