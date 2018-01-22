package org.sample.integrationtest.glue;

import org.sample.integrationtest.util.Props;
import org.sample.integrationtest.util.Props.Key;
import org.sample.personservice.model.Person;
import org.sample.test.manager.StaticManager;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java8.En;

public class EndpointTestSteps implements En {

	public EndpointTestSteps() {
		When("^the person lookup endpoint is called$", () -> {
			
			String url = Props.getValue(Key.ROUTE) + "/person?email=" + 
					StaticManager.CRITERIA.getEmail();
			
			System.out.println("Request URL is {" + url + "}");
			
			RestTemplate template = new RestTemplate();
			Person person = template.getForObject(url, Person.class);
			
			StaticManager.RESULTS.getPeople().add(person);
		});
	}
}