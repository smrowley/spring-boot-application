package org.sample.test.manager;

import java.util.ArrayList;
import java.util.List;

import org.sample.personservice.model.Person;

/*
 * use this class to store results for service/rest calls
 */
public class ResultManager {

	private List<Person> people;
	
	public ResultManager() {
		people = new ArrayList<>();
	}
	
	public List<Person> getPeople() {
		return this.people;
	}
}
