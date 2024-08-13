package com.grayMatter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Person;
import com.grayMatter.repositories.PersonRepositoryInterface;


@Repository
public class PersonDao {

	@Autowired
	PersonRepositoryInterface repositoryInterface;
	
	public ResponseEntity<?> getAllPersons(){
		List<Person> pList = repositoryInterface.findAll();
		Map<String, Object> map = new  HashMap<>();
		
		if(!pList.isEmpty()) {
			map.put("status", 200);
			map.put("data", pList);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", 404);
			map.put("data", "No data found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> addPerson(Person person) {
		Person p = repositoryInterface.save(person);
		Map<String, Object> map = new  HashMap<>();
		if(p!=null) {
			map.put("status", 200);
			map.put("data", p);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", 404);
			map.put("data", "Data not Inserted");
			return new ResponseEntity<>(map, HttpStatus.I_AM_A_TEAPOT);
		}
	}
	
	public ResponseEntity<?> getPersonById(long aid) {
		Person p = repositoryInterface.findById(aid).get();
		Map<String, Object> map = new  HashMap<>();
		
		if(p != null) {
			map.put("status", 200);
			map.put("data", p);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", 404);
			map.put("data", "No data found");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}

	public void deletePerson(Person person) {
		repositoryInterface.delete(person);;
	}
	
	public void updatePerson(Person person) {
		Person p= repositoryInterface.findById(person.getAid()).get();
		p.setName(person.getName());
		p.setMobile(person.getMobile());
		p.setAge(person.getAge());
		p.setEmail(person.getEmail());
		repositoryInterface.save(p);
		
	}
}
