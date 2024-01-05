package com.fdmgroup.tdd.groupcontroller;

import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GroupControllerServiceTest {
	
	MyGCS myGCS;
	
	@Mock
	DatabaseReader mockDatabaseReader;
	
	@Mock 
	DatabaseWriter mockDatabaseWriter;
	
	@Mock
	Trainee mockTrainee1;
	
	@BeforeEach
	void setUp() throws Exception {
		myGCS = new MyGCS();
	}
	
	// Test 1
	@Test
	public void getAllTrainees_returnMapFromReadGroupOfDatabaseReaderClass_whenCalled() {
		myGCS.setDatabaseReader(mockDatabaseReader);
		myGCS.getAllTrainees();
		
		verify(mockDatabaseReader).readGroup();
	}
	
	// Test 2
	@Test
	public void removeTrainee_removeTraineeByUserNameFromDatabaseWriter_whenCalled() {
		myGCS.setDatabaseWriter(mockDatabaseWriter);
		myGCS.removeTraineeByUsername(mockTrainee1.getUsername());
		
		verify(mockDatabaseWriter).deleteTraineeByUsername(mockTrainee1.getUsername());
	}
	
	// Test 3
	@Test
	public void addTrainee_addTraineeByDatabaseWriter_whenCalled() {
		myGCS.setDatabaseWriter(mockDatabaseWriter);
		myGCS.addTrainee(mockTrainee1);
		
		verify(mockDatabaseWriter).addTrainee(mockTrainee1);
	}
	
}
