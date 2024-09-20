package com.grayMatter.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

	List<Event> findByLocation(String location);

	List<Event> findByDate(Date date);

}
