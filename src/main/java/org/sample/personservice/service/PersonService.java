package org.sample.personservice.service;

import java.util.Optional;

import org.sample.personservice.data.Data;
import org.sample.personservice.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	public Optional<Person> lookupByEmail(String email) {
		return Data.PEOPLE.stream()
			.filter(p -> p.getEmail().equals(email))
			.findFirst();
	}
}
