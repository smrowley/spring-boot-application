package org.sample.personservice.rest;

import java.util.Optional;

import org.sample.personservice.model.Person;
import org.sample.personservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class EndpointsController {
	
	@Autowired
	private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonByEmail(@RequestParam(value="email", required=true) String email) {
        
    	Optional<Person> person = personService.lookupByEmail(email);
    	
    	if (person.isPresent()) {
    		return new ResponseEntity<Person>(person.get(), HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    	}
    }

}