package com.grayMatter.services;


import java.util.List;

import com.grayMatter.dto.JobDto;

public interface JobServiceInterface {

	public JobDto addJob(JobDto jobDTO);
	
	public JobDto getJobById(int jobId);
	
	public List<JobDto> getAllJobs();
	
	public void deleteJob(int jobId);
	
	public JobDto updateJob(JobDto jobDto);
	
	public List<JobDto> getJobByLocation(String loc);
	
	public List<JobDto> getJobByTitle(String title);
	
	public List<JobDto> getJobBySkill(String skill);
	
}
