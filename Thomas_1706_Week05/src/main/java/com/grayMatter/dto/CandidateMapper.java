package com.grayMatter.dto;

import org.springframework.stereotype.Component;

import com.grayMatter.entities.Candidate;

@Component
public class CandidateMapper {
	
	public CandidateDto toCandidateDto(Candidate candidate) {
		CandidateDto candidateDto = new CandidateDto(
				candidate.getCandidateId(),
				candidate.getName(),
				candidate.getSkills(),
				candidate.getMobile(),
				candidate.getEmail(),
				candidate.getDob(),
				candidate.getPassword()
				);
		return candidateDto;
	}
	
	public Candidate toCandidate(CandidateDto candidateDto) {
		Candidate candidate = new Candidate(
				candidateDto.getCandidateId(),
				candidateDto.getName(),
				candidateDto.getSkills(),
				candidateDto.getMobile(),
				candidateDto.getEmail(),
				candidateDto.getDob(),
				candidateDto.getPassword()
				);
		return candidate;
	}

}
