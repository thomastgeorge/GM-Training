package com.grayMatter.services;

import java.util.List;

import com.grayMatter.dto.ApplicationDto;

public interface ApplicationServiceInterface {
	
	public List<ApplicationDto> getAllApplicationsByJobId(int jobId);
	
	public List<ApplicationDto> getAllApplicationsByCandidateId(int cId);
	
	public ApplicationDto addApplication(ApplicationDto applicationDto);
	
	public ApplicationDto getApplicationById(int applicationId);
	
	public List<ApplicationDto> getAllApplications();
	
	public void deleteApplication(int applicationId);
	
	public ApplicationDto updateApplication(ApplicationDto applicationDto);

}
