package com.fdmgroup.tdd.groupcontroller;

import java.util.HashMap;
import java.util.Map;

public class DatabaseReader {
	
	private Map<String, Trainee> trainees = new HashMap<String, Trainee> ();
	
	public Map<String, Trainee> readGroup() {
		return this.trainees;
	}
}
