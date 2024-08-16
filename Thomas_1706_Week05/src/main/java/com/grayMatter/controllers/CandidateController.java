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
import com.grayMatter.dto.CandidateDto;
import com.grayMatter.services.CandidateService;

@RestController
@RequestMapping("api/v1")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@PostMapping("candidate")
	public ResponseEntity<CandidateDto> addCandidate(@RequestBody CandidateDto candidateDto){
		return ResponseEntity.ok(candidateService.addCandidate(candidateDto));
	}
	
	@GetMapping("candidate")
	public ResponseEntity<List<CandidateDto>> getAllCandidates()throws ResourceNotFoundException{
		List<CandidateDto> candidates = candidateService.getAllCandidates();
	    if (candidates.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(candidates);
	    }
	}
	
	@GetMapping("/candidate/{id}")
	public ResponseEntity<CandidateDto> getCandidateById(@PathVariable(value="id") int id)throws ResourceNotFoundException{
		CandidateDto candidate = candidateService.getCandidateById(id);
	    if (candidate == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(candidate);
	    }
}
	
	@PatchMapping("/candidate")
	public ResponseEntity<CandidateDto> updateCandidate(@RequestBody CandidateDto candidateDto)throws ResourceNotFoundException{
		CandidateDto updatedCandidate = candidateService.updateCandidate(candidateDto);
	    if (updatedCandidate == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(updatedCandidate);
	    }
	}
	
	@DeleteMapping("/candidate/{id}")
	public void deleteCandidate(@PathVariable(value="id") int id) throws ResourceNotFoundException {
		candidateService.deleteCandidate(id);
	}

}
