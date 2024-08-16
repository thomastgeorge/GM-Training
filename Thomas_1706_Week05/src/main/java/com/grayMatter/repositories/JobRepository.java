package com.grayMatter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grayMatter.entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
	
	public List<Job> findByjobLocation(String loc);
	
	public List<Job> findByjobTitle(String title);
	
	@Query(value = "SELECT * FROM assessment05job WHERE required_skills LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
	public List<Job> findJobsBySkill(String skill);


}
