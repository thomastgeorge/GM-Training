package com.grayMatter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.ApplicationDao;
import com.grayMatter.dto.ApplicationDto;
import com.grayMatter.dto.ApplicationMapper;
import com.grayMatter.entities.Application;


@Service
public class ApplicationService implements ApplicationServiceInterface {

	@Autowired
	private ApplicationMapper applicationMapper;
	
	@Autowired
	private ApplicationDao applicationDao;
	
	@Override
	public List<ApplicationDto> getAllApplicationsByJobId(int jobId) {
		List<Application> alist = applicationDao.getAllApplicationsByJobId(jobId);
		return alist.stream()
                .map(applicationMapper::toApplicationDto)
                .collect(Collectors.toList());
	}
	
	@Override
	public List<ApplicationDto> getAllApplicationsByCandidateId(int cId) {
		List<Application> alist = applicationDao.getAllApplicationsByCandidateId(cId);
		return alist.stream()
                .map(applicationMapper::toApplicationDto)
                .collect(Collectors.toList());
	}

	@Override
	public ApplicationDto addApplication(ApplicationDto applicationDto) {
		return applicationMapper.toApplicationDto(applicationDao.addApplication(applicationMapper.toApplication(applicationDto)));
	}

	@Override
	public ApplicationDto getApplicationById(int applicationId) {
		return applicationMapper.toApplicationDto(applicationDao.getApplicationById(applicationId));
	}

	@Override
	public List<ApplicationDto> getAllApplications() {
		List<Application> alist = applicationDao.getAllApplications();
		return alist.stream()
                .map(applicationMapper::toApplicationDto)
                .collect(Collectors.toList());
	}

	@Override
	public void deleteApplication(int applicationId) {
		applicationDao.deleteApplication(applicationId);
	}

	@Override
	public ApplicationDto updateApplication(ApplicationDto applicationDto) {
		return applicationMapper.toApplicationDto(applicationDao.updateApplication(applicationMapper.toApplication(applicationDto))); 
	}

}
