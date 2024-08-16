package com.grayMatter.services;

import java.util.List;

import com.grayMatter.dto.CandidateDto;

public interface CandidateServiceInterface {
	
	public CandidateDto addCandidate(CandidateDto candidateDto);
	
	public CandidateDto getCandidateById(int cId);
	
	public List<CandidateDto> getAllCandidates();
	
	public void deleteCandidate(int cId);
	
	public CandidateDto updateCandidate(CandidateDto candidateDto);
	
	public Boolean loginCandidate(String email, String password);

}
