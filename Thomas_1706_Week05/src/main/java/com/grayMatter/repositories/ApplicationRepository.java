package com.grayMatter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entities.Application;


public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	public List<Application> findByJobIdJobId(int jobId);
	
	public List<Application> findByCandidateIdCandidateId(int cId);
	
}
