package com.grayMatter.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.Repository.EventRepository;
import com.grayMatter.entity.Event;

@Repository
public class EventDao {
	
	@Autowired
	private EventRepository repository;

	public Event createEvent(Event event) {
		return repository.save(event);
	}

	public Event getEventById(int id) {
		return repository.findById(id).get();
	}

	public List<Event> getAllEvents() {
		return repository.findAll();
	}

	public Event updateEvent(int id, Event event) {
		Event e = repository.findById(id).get();
		if(e==null) {
			return null;
		} else {
			return repository.save(event);
		}
		
	}

	public void deleteEvent(int id) {
		repository.deleteById(id);
	}

	public List<Event> getEventsByLocation(String location) {
		return repository.findByLocation(location);
	}

	public boolean checkAvailability(int id) {
		Event e = repository.findById(id).get();
		if(e==null)
			return false;
		else
			return true;
	}

	public List<Event> getEventsByLocation(Date date) {
		return repository.findByDate(date);
	}

}
