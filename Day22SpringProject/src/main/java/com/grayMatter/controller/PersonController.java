package com.grayMatter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.entities.Person;
import com.grayMatter.services.PersonServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	
	@Autowired
	PersonServiceImpl pService;
	
	@GetMapping("/person")
	public ResponseEntity<?> getAllPersons(){
		return pService.getAllPersons();
	}
	
	@PostMapping("/person")
	public ResponseEntity<?> addPerson(@RequestBody Person person) {
		return pService.addPerson(person);
	}
	
	@GetMapping("/person/{aid}")
	public ResponseEntity<?> getPersonById(@PathVariable long aid){
		return pService.getPersonById(aid);
	}
	
	@DeleteMapping("/person")
	public void deletePerson(@RequestBody Person person) {
		pService.deletePerson(person);
	}
	
	@PutMapping("/person")
	public void updatePerson(@RequestBody Person person) {
		pService.updatePerson(person);
	}

}
