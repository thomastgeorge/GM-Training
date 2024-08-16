package com.grayMatter.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobDto {
	
	 private int jobId;
	 @NotBlank(message = "Job title cannot be blank")
	 @Size(min = 2, message = "Job title should be at least 2 characters long")
	 private String jobTitle;

	 @NotBlank(message = "Job location cannot be blank")
	 @Size(min = 2, message = "Job location should be at least 2 characters long")
	 private String jobLocation;

	 @NotNull(message = "Required skills list cannot be null")
	 @Size(min = 1, message = "Required skills list should contain at least one skill")
	 private List<String> requiredSkills;

    @Positive(message = "Salary should be a positive number")
    private float salary;
}
