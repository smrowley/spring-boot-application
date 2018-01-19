package org.sample.cucumber.steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.sample.personservice.model.Person;
import org.sample.personservice.service.PersonService;

import cucumber.api.java8.En;

public class PersonServiceSteps implements En {

	private String email;
	private Person foundPerson;
	
	private PersonService personService;
	
	public PersonServiceSteps() {
		
		Before(() -> {
			personService = new PersonService();
		});
		
		After(() -> {
			email = null;
			foundPerson = null;
			personService = null;
		});
		
		Given("^an email address of " + RegexHelper.EMAIL + "$", (String email) -> {
		    this.email = email;
		});
	
		When("^a person is looked up with the email address$", () -> {
			personService = new PersonService();
			personService.lookupByEmail(email)
				.ifPresent(p -> foundPerson = p);
		});
	
		Then("^the person name should be " + RegexHelper.WORD + "$", (String name) -> {
			assertThat(foundPerson, is(notNullValue()));
		    assertThat(foundPerson.getFirstName(), equalTo(name));
		});
		
	}
}
