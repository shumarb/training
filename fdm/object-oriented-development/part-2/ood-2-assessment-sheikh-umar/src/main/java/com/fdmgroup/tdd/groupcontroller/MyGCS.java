package com.fdmgroup.tdd.groupcontroller;

import java.util.Map;

public class MyGCS implements GroupControllerService {
	
	private DatabaseReader databaseReader;
	private DatabaseWriter databaseWriter;
	
	public DatabaseWriter getDatabaseWriter() {
		return databaseWriter;
	}

	@Override
	public Map<String, Trainee> getAllTrainees() {
		return this.databaseReader.readGroup();
	}

	@Override
	public void addTrainee(Trainee trainee) {
		this.databaseWriter.addTrainee(trainee);	
	}

	@Override
	public void removeTraineeByUsername(String traineeUsername) {
		this.databaseWriter.deleteTraineeByUsername(traineeUsername);
	}

	public DatabaseReader getDatabaseReader() {
		return this.databaseReader;
	}

	public void setDatabaseReader(DatabaseReader databaseReader) {
		this.databaseReader = databaseReader;
	}

	public void setDatabaseWriter(DatabaseWriter databaseWriter) {
		this.databaseWriter = databaseWriter;
	}
	
}
