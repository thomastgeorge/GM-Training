package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Application;
import com.grayMatter.repositories.ApplicationRepository;

@Repository
public class ApplicationDao {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	public List<Application> getAllApplicationsByJobId(int jobId){
		return applicationRepository.findByJobIdJobId(jobId);
	}
	
	public List<Application> getAllApplicationsByCandidateId(int cId){
		return applicationRepository.findByCandidateIdCandidateId(cId);
	}
	
	public Application addApplication(Application application) {
        return applicationRepository.save(application);
	}
	
	public Application getApplicationById(int applicationId) {
		return applicationRepository.findById(applicationId).get();
	}
	
	public List<Application> getAllApplications(){
		return applicationRepository.findAll();
	}
	
	public void deleteApplication(int applicationId) {
		applicationRepository.deleteById(applicationId);
	}
	
	public Application updateApplication(Application application) {
		return applicationRepository.save(application);
	}
	
	

}
