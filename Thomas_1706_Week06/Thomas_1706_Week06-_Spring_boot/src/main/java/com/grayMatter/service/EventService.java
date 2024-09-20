package com.grayMatter.service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.EventDao;
import com.grayMatter.dto.EventDto;
import com.grayMatter.dto.EventMapper;
import com.grayMatter.entity.Event;

@Service
public class EventService implements EventServiceInterface {
	
	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private EventMapper eventMapper;

	@Override
	public EventDto createEvent(EventDto eventdto) {
		return eventMapper.toEventDto(eventDao.createEvent(eventMapper.toEvent(eventdto)));
	}

	@Override
	public EventDto getEventById(int id) {
		return eventMapper.toEventDto(eventDao.getEventById(id));
	}

	@Override
	public List<EventDto> getAllEvents() {
		List<Event> levent = eventDao.getAllEvents();
		return levent.stream()
                .map(eventMapper::toEventDto)
                .collect(Collectors.toList());
	}

	@Override
	public EventDto updateEvent(int id, EventDto eventDto) {
		return eventMapper.toEventDto(eventDao.updateEvent(id, eventMapper.toEvent(eventDto)));
	}

	@Override
	public void deleteEvent(int id) {
		eventDao.deleteEvent(id);
	}

	@Override
	public List<EventDto> getEventsByLocation(String location) {
		List<Event> levent = eventDao.getEventsByLocation(location);
		return levent.stream()
                .map(eventMapper::toEventDto)
                .collect(Collectors.toList());
		
	}

	@Override
	public List<EventDto> getEventsByDate(Date date) {
		List<Event> levent = eventDao.getEventsByLocation(date);
		return levent.stream()
                .map(eventMapper::toEventDto)
                .collect(Collectors.toList());
	}
	
	@Override
	public boolean checkAvailability(int id) {
		return eventDao.checkAvailability(id);
	}

}
