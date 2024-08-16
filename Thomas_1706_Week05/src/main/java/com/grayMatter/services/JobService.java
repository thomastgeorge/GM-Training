package com.grayMatter.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.JobDao;
import com.grayMatter.dto.JobDto;
import com.grayMatter.dto.JobMapper;
import com.grayMatter.entities.Job;

@Service
public class JobService implements JobServiceInterface {
	
	@Autowired
	private JobMapper jobMapper;
	
	@Autowired
	private JobDao jobDao;

	@Override
	public JobDto addJob(JobDto jobDTO) {
        return jobMapper.toJobDto(jobDao.addJob(jobMapper.toJob(jobDTO)));
	}

	@Override
	public JobDto getJobById(int jobId) {
		return jobMapper.toJobDto(jobDao.getJobById(jobId));
	}

	@Override
	public List<JobDto> getAllJobs() {
		List<Job> jlist = jobDao.getAllJobs();
		return jlist.stream()
                .map(jobMapper::toJobDto)
                .collect(Collectors.toList());
	}

	@Override
	public void deleteJob(int jobId) {
		jobDao.getJobById(jobId);
		
	}

	@Override
	public JobDto updateJob(JobDto jobDto) {
		return jobMapper.toJobDto(jobDao.updateJob(jobMapper.toJob(jobDto)));
	}

	@Override
	public List<JobDto> getJobByLocation(String loc) {
		List<Job> jlist = jobDao.getJobByLocation(loc);
		return jlist.stream()
                .map(jobMapper::toJobDto)
                .collect(Collectors.toList());
	}

	@Override
	public List<JobDto> getJobByTitle(String title) {
		List<Job> jlist = jobDao.getJobByTitle(title);
		return jlist.stream()
                .map(jobMapper::toJobDto)
                .collect(Collectors.toList());
	}

	@Override
	public List<JobDto> getJobBySkill(String skill) {
		List<Job> jlist = jobDao.getJobBySkill(skill);
		return jlist.stream()
                .map(jobMapper::toJobDto)
                .collect(Collectors.toList());
	}
	
}
