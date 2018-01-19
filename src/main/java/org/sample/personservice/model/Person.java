package org.sample.personservice.model;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 8693245675925686564L;

	private String firstName;
	private String lastName;
	private String email;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
