package org.sample.test.glue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.sample.personservice.model.Person;
import org.sample.personservice.service.PersonService;
import org.sample.test.manager.StaticManager;
import org.sample.test.util.RegexHelper;

import cucumber.api.DataTable;
import cucumber.api.java8.En;

public class PersonServiceSteps implements En {

	private PersonService personService;
	
	public PersonServiceSteps() {
		
		Before(() -> {
			personService = new PersonService();
			StaticManager.reset();
		});
		
		After(() -> {
			personService = null;
		});
		
		Given("^an email address of " + RegexHelper.EMAIL + "$", (String email) -> {
		    StaticManager.CRITERIA.setEmail(email);
		});
	
		When("^a person is looked up with the email address$", () -> {
			personService = new PersonService();
			Optional<Person> person = personService.lookupByEmail(StaticManager.CRITERIA.getEmail());
			
			if (person.isPresent()) {
				StaticManager.RESULTS.getPeople().add(person.get());
			}
		});
	
		Then("^the person name should be " + RegexHelper.WORD + "$", (String name) -> {
			Person foundPerson = StaticManager.RESULTS.getPeople().get(0);
			assertThat(foundPerson, is(notNullValue()));
		    assertThat(foundPerson.getFirstName(), equalTo(name));
		});
		
		Then("^the found (?:person|people) should be:$", (DataTable dataTable) -> {
	        // Write code here that turns the phrase above into concrete actions
	        // For automatic transformation, change DataTable to one of
	        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	        // E,K,V must be a scalar (String, Integer, Date, enum etc)
			List<Person> people = dataTable.asList(Person.class);
			
			Person expected = people.get(0);
			Person found = StaticManager.RESULTS.getPeople().get(0);
			
			assertThat(found, equalTo(expected));
	    });
		
	}
}
