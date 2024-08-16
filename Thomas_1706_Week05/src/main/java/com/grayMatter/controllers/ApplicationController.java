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
import com.grayMatter.dto.ApplicationDto;
import com.grayMatter.services.ApplicationService;

@RestController
@RequestMapping("api/v1")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	@PostMapping("/application")
	public ResponseEntity<ApplicationDto> addApplication(@RequestBody ApplicationDto applicationDto) {
		return ResponseEntity.ok(applicationService.addApplication(applicationDto));
	}
	
	@GetMapping("/application")
	public ResponseEntity<List<ApplicationDto>> getAllApplications()throws ResourceNotFoundException{
		 List<ApplicationDto> applications = applicationService.getAllApplications();
		    if (applications.isEmpty()) {
		        return ResponseEntity.notFound().build();
		    } else {
		        return ResponseEntity.ok(applications);
		    }
	}
	
	@GetMapping("/application/{id}")
	public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable(value="id") int id)throws ResourceNotFoundException{
		 ApplicationDto application = applicationService.getApplicationById(id);
		 if (application == null) {
			 return ResponseEntity.notFound().build();
		 } else {
			 return ResponseEntity.ok(application);
		 }
	}
	
	@PatchMapping("/application")
	public ResponseEntity<ApplicationDto> updateApplication(@RequestBody ApplicationDto applicationDto)throws ResourceNotFoundException{
	    ApplicationDto updatedApplication = applicationService.updateApplication(applicationDto);
	    if (updatedApplication == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(updatedApplication);
	    }	}
	
	@DeleteMapping("/application/{id}")
	public void deleteApplication(@PathVariable(value="id") int id)throws ResourceNotFoundException{
		applicationService.deleteApplication(id);
	}
	
	@GetMapping("application/job/{id}")
	public ResponseEntity<List<ApplicationDto>> getAllApplicationsByJobId(@PathVariable(value="id") int id){
		List<ApplicationDto> applications = applicationService.getAllApplicationsByJobId(id);
	    if (applications.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(applications);
	    }
	}
	
	@GetMapping("application/candidate/{id}")
	public ResponseEntity<List<ApplicationDto>> getAllApplicationsByCandidateId(@PathVariable(value="id") int id){
		return ResponseEntity.ok(applicationService.getAllApplicationsByCandidateId(id));
	}
	
}
