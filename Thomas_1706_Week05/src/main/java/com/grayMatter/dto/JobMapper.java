package com.grayMatter.dto;

import org.springframework.stereotype.Component;

import com.grayMatter.entities.Job;

@Component
public class JobMapper {
	
	public JobDto toJobDto(Job job) {
		JobDto jobDto = new JobDto(
				job.getJobId(),
				job.getJobTitle(),
				job.getJobLocation(),
				job.getRequiredSkills(),
				job.getSalary()
				);
		return jobDto;
	}
	
	public Job toJob(JobDto jobDto) {
		Job job = new Job(
				jobDto.getJobId(),
				jobDto.getJobTitle(),
				jobDto.getJobLocation(),
				jobDto.getRequiredSkills(),
				jobDto.getSalary()
				);
		return job;
	}
	
}
