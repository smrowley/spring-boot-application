package org.sample.personservice.data;

import java.util.ArrayList;
import java.util.List;

import org.sample.personservice.model.Person;

/*
 * 
 */
public class Data {
	public static List<Person> PEOPLE = new ArrayList<>();
	
	static {
		PEOPLE.add(new Person("John", "Connor", "john@sample.org"));
		PEOPLE.add(new Person("Ryan", "Sanders", "ryan@sample.org"));
	}
}
