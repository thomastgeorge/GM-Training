package com.grayMatter.dto;

import org.springframework.stereotype.Component;

import com.grayMatter.entity.Event;

@Component
public class EventMapper {
	
	public EventDto toEventDto(Event event) {
		EventDto eventDto = new EventDto(
				event.getEid(),
				event.getName(),
				event.getLocation(),
				event.getDate(),
				event.getStartTime(),
				event.getEndTime(),
				event.getCapacity()
				);
		return eventDto;
	}
	
	public Event toEvent(EventDto eventDto) {
		Event event = new Event(
				eventDto.getEid(),
				eventDto.getName(),
				eventDto.getLocation(),
				eventDto.getDate(),
				eventDto.getStartTime(),
				eventDto.getEndTime(),
				eventDto.getCapacity()
				);
		return event;
	}

}
