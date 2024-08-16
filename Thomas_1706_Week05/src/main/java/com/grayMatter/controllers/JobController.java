package com.grayMatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.Exception.ResourceNotFoundException;
import com.grayMatter.dto.JobDto;
import com.grayMatter.services.JobService;

@RestController
@RequestMapping("api/v1")
public class JobController {
	
	@Autowired
    private JobService jobService;

    @PostMapping("/job")
    public ResponseEntity<JobDto> addJob(@RequestBody JobDto jobDto) {
        return ResponseEntity.ok(jobService.addJob(jobDto));
    }
    
    @GetMapping("/job")
    public ResponseEntity<List<JobDto>> getAllJobs() throws ResourceNotFoundException {
        List<JobDto> jobs = jobService.getAllJobs();
        if (jobs.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(jobs);
        }
}
    
    @GetMapping("/job/{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable(value = "id") int id)throws ResourceNotFoundException {
    	JobDto job = jobService.getJobById(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(job);
        }
    }
    
    @PatchMapping("/job")
    public ResponseEntity<JobDto> updateJob(@RequestBody JobDto jobDto)throws ResourceNotFoundException {
    	JobDto updatedJob = jobService.updateJob(jobDto);
    	if (updatedJob == null) {
    		return ResponseEntity.notFound().build();
    	} else {
    	        return ResponseEntity.ok(updatedJob);
    	    }
}
    
    @DeleteMapping("/job/{id}")
    public void deleteJob(@PathVariable(value="id") int id) throws ResourceNotFoundException {
    	jobService.deleteJob(id);
    }
    
    @GetMapping("/job/title/{title}")
    public ResponseEntity<List<JobDto>> getJobByTitle(@PathVariable(value="title") String title){
    	 List<JobDto> jobs = jobService.getJobByTitle(title);
    	 if (jobs.isEmpty()) {
    		 return ResponseEntity.notFound().build();
    	 } else {
    		 return ResponseEntity.ok(jobs);
    	 }
    }

    @GetMapping("/job/location/{loc}")
    public ResponseEntity<List<JobDto>> getJobByLocation(@PathVariable(value="loc") String loc){
    	return ResponseEntity.ok(jobService.getJobByLocation(loc));
    }
    
    @GetMapping("/job/skill/{skill}")
    public ResponseEntity<List<JobDto>> getJobBySkill(@PathVariable(value="skill") String skill){
    	return ResponseEntity.ok(jobService.getJobBySkill(skill));
    }
}
