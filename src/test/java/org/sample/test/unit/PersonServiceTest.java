package org.sample.test.unit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.sample.personservice.model.Person;
import org.sample.personservice.service.PersonService;

@Ignore
public class PersonServiceTest {
	
	@Test
	public void testLookup() {
		PersonService service = new PersonService();
		
		
		Person p = service.lookupByEmail("john@sample.org").get();
		
		assertThat(p.getFirstName(), equalTo("John"));
	}
}
