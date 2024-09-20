package com.grayMatter.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.Exception.EventNotFoundException;
import com.grayMatter.dto.EventDto;
import com.grayMatter.service.EventService;

@RestController
@RequestMapping("/api/v1")
public class EventController {
	
	@Autowired
	private EventService eventService;
	


	@PostMapping("/events")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventDto) {
        Map<String, Object> response = new HashMap<>();
        EventDto event = eventService.createEvent(eventDto);
        response.put("status", "created");
        response.put("event", event);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	@GetMapping("/events/{id}")
    public ResponseEntity<Map<String, Object>> getEvent(@PathVariable(value="id") int id) throws EventNotFoundException {
        Map<String, Object> response = new HashMap<>();
        EventDto event = eventService.getEventById(id);
		response.put("status", "found");
		response.put("event", event);
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@PutMapping("/events/{id}")
    public ResponseEntity<Map<String, Object>> updateEvent(@PathVariable int id, @RequestBody EventDto eventDto) throws EventNotFoundException {
        Map<String, Object> response = new HashMap<>();
        EventDto updatedEvent = eventService.updateEvent(id, eventDto);
		response.put("status", "updated");
		response.put("event", updatedEvent);
		return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Map<String, Object>> deleteEvent(@PathVariable(value="id") int id) throws EventNotFoundException {
        Map<String, Object> response = new HashMap<>();
        eventService.deleteEvent(id);
		response.put("status", "deleted");
		response.put("message", "Event deleted successfully.");
		return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/events")
    public ResponseEntity<Map<String, Object>> listAllEvents() {
        Map<String, Object> response = new HashMap<>();
        List<EventDto> events = eventService.getAllEvents();
        if (events.isEmpty()) {
            response.put("status", "not found");
            response.put("message", "No events found.");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("status", "found");
            response.put("events", events);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    
    @GetMapping("/events/location/{location}")
    public ResponseEntity<Map<String, Object>> listEventsByLocation(@PathVariable(value="location") String location) {
        Map<String, Object> response = new HashMap<>();
        List<EventDto> events = eventService.getEventsByLocation(location);
        if (events.isEmpty()) {
            response.put("status", "not found");
            response.put("message", "No events found at this location.");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("status", "found");
            response.put("events", events);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/events/date/{date}")
    public ResponseEntity<Map<String, Object>> listEventsByDate(@PathVariable(value="date") Date date) {
        Map<String, Object> response = new HashMap<>();
        List<EventDto> events = eventService.getEventsByDate(date);
        if (events.isEmpty()) {
            response.put("status", "not found");
            response.put("message", "No events found on this date.");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("status", "found");
            response.put("events", events);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/events/{id}/availability")
    public ResponseEntity<Map<String, Object>> checkAvailability(@PathVariable(value="id") int id) {
        Map<String, Object> response = new HashMap<>();
        boolean available = eventService.checkAvailability(id);
        if (available) {
            response.put("status", "available");
            response.put("message", "Event is available.");
        } else {
            response.put("status", "not available");
            response.put("message", "Event is not available.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
}
