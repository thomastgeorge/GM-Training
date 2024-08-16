package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Candidate;
import com.grayMatter.repositories.CandidateRepository;

@Repository
public class CandidateDao {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	public Candidate addCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}
	
	public Candidate getCandidateById(int cId) {
		return candidateRepository.findById(cId).get();
	}
	
	public List<Candidate> getAllCandidates(){
		return candidateRepository.findAll();
	}
	
	public void deleteCandidate(int cId) {
		candidateRepository.deleteById(cId);
	}
	
	public Candidate updateCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}
	
	public Candidate loginCandidate(String email, String password) {
		return candidateRepository.findByCredentials(email, password);
	}

}
