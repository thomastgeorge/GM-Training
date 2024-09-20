package com.grayMatter.service;

import java.sql.Date;
import java.util.List;

import com.grayMatter.dto.EventDto;
public interface EventServiceInterface {
	
	public EventDto createEvent(EventDto eventdto);
	
	public EventDto getEventById(int id);
	
	public List<EventDto> getAllEvents();
	
	public EventDto updateEvent(int id, EventDto eventDto);

	public void deleteEvent(int id);
	
	public List<EventDto> getEventsByLocation(String location);

	public List<EventDto> getEventsByDate(Date date);
	
	public boolean checkAvailability(int id);

}
