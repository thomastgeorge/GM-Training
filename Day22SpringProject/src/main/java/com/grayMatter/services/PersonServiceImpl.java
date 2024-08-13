package com.grayMatter.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.PersonDao;
import com.grayMatter.entities.Person;

@Service
public class PersonServiceImpl implements PersonServiceInterface {

	@Autowired
	PersonDao pDao;
	
	@Override
	public ResponseEntity<?> getAllPersons() {
		return pDao.getAllPersons();
	}

	@Override
	public ResponseEntity<?> addPerson(Person person) {
		return pDao.addPerson(person);
	}

	@Override
	public ResponseEntity<?> getPersonById(long aid) {
		return pDao.getPersonById(aid);
	}

	@Override
	public void deletePerson(Person person) {
		pDao.deletePerson(person);
	}

	@Override
	public void updatePerson(Person person) {
		pDao.updatePerson(person);
	}
	

}
