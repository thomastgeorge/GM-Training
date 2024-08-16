package com.grayMatter.dto;

import java.sql.Date;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
	
	private int candidateId;
	@Size(min=3, message="Person name should be atleast 3 chars!")
	@NotBlank(message = "Person name cannot be blank")
    private String name;
	
	@NotNull(message = "Skills list cannot be null")
    @Size(min = 1, message = "Skills list should contain at least one skill")
    private List<String> skills;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Mobile number should be between 10 to 15 digits")
    private String mobile;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Past(message = "Date of Birth should be a past date")
    private Date dob;

    @Size(min = 8, message = "Password should be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
             message = "Password must include at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String password;

}
