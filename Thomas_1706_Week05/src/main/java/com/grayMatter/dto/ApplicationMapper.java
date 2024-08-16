package com.grayMatter.dto;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grayMatter.entities.Application;
import com.grayMatter.repositories.CandidateRepository;
import com.grayMatter.repositories.JobRepository;

@Component
public class ApplicationMapper {
	
	@Autowired
    private JobRepository jobRepository;
	
	@Autowired
    private CandidateRepository candidateRepository;
	
	public ApplicationDto toApplicationDto(Application application) {
		ApplicationDto applicationDto = new ApplicationDto(
				application.getApplicationId(),
				application.getJobId().getJobId(),
				application.getCandidateId().getCandidateId()
				);
		return applicationDto;
	}
	
	public Application toApplication(ApplicationDto applicationDto) {
		Application application=null;
		try {
			application = new Application(
					applicationDto.getApplicationId(),
					null,
					jobRepository.findById(applicationDto.getJobId()).orElse(null),
					candidateRepository.findById(applicationDto.getCandidateId()).orElse(null)
					);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		Date adate= new Date(System.currentTimeMillis());
		application.setAppliedDate(adate);
		return application;
	}

}
