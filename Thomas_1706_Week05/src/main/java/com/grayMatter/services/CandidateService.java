package com.grayMatter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.CandidateDao;
import com.grayMatter.dto.CandidateDto;
import com.grayMatter.dto.CandidateMapper;
import com.grayMatter.entities.Candidate;

@Service
public class CandidateService implements CandidateServiceInterface {

	@Autowired
	private CandidateMapper candidateMapper;
	
	@Autowired
	private CandidateDao candidateDao;
	
	
	@Override
	public CandidateDto addCandidate(CandidateDto candidateDto) {
		return candidateMapper.toCandidateDto(candidateDao.addCandidate(candidateMapper.toCandidate(candidateDto)));
	}

	@Override
	public CandidateDto getCandidateById(int cId) {
		return candidateMapper.toCandidateDto(candidateDao.getCandidateById(cId));
	}

	@Override
	public List<CandidateDto> getAllCandidates() {
		List<Candidate> jlist = candidateDao.getAllCandidates();
		return jlist.stream()
                .map(candidateMapper::toCandidateDto)
                .collect(Collectors.toList());
	}

	@Override
	public void deleteCandidate(int cId) {
		candidateDao.deleteCandidate(cId);
	}

	@Override
	public CandidateDto updateCandidate(CandidateDto candidateDto) {
		return candidateMapper.toCandidateDto(candidateDao.updateCandidate(candidateMapper.toCandidate(candidateDto)));
	}

	@Override
	public Boolean loginCandidate(String email, String password) {
		return candidateDao.loginCandidate(email, password)!=null;
	}

}
