package com.grayMatter.services;

import org.springframework.http.ResponseEntity;

import com.grayMatter.entities.Person;

public interface PersonServiceInterface {
	
	public ResponseEntity<?> getAllPersons();
	
	public ResponseEntity<?> addPerson(Person person);
	
	public ResponseEntity<?> getPersonById(long aid);

	public void deletePerson(Person person);
	
	public void updatePerson(Person person);
}
