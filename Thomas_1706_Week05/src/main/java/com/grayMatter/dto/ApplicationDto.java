package com.grayMatter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
	
	private int applicationId;
    private int jobId;
    private int candidateId;
}
