package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Job;
import com.grayMatter.repositories.JobRepository;

@Repository
public class JobDao {
	
	@Autowired
    private JobRepository jobRepository;
	
	public Job addJob(Job job) {
        return jobRepository.save(job);
	}
	
	public Job getJobById(int jobId) {
		return jobRepository.findById(jobId).get();
	}
	
	public List<Job> getAllJobs(){
		return jobRepository.findAll();
	}
	
	public void deleteJob(int jobId) {
		jobRepository.deleteById(jobId);
	}
	
	public Job updateJob(Job job) {
		return jobRepository.save(job);
	}

	public List<Job> getJobByLocation(String loc){
		return jobRepository.findByjobLocation(loc);
	}
	
	public List<Job> getJobByTitle(String title){
		return jobRepository.findByjobTitle(title);
	}
	
	public List<Job> getJobBySkill(String skill){
		return jobRepository.findJobsBySkill(skill);
	}
}
