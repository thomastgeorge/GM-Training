package com.graymatter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegUserDTO {
	
	 @NotBlank(message = "Username cannot be null or empty.")
	    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
	    private String username;

	    @NotBlank(message = "Email cannot be null or empty.")
	    @Email(message = "Email should be valid.")
	    private String email;

	    @NotBlank(message = "Password cannot be null or empty.")
	    @Size(min = 8, message = "Password must be at least 8 characters long.")
	    private String password;

	    @NotBlank(message = "Role cannot be null or empty.")
	    @Pattern(regexp = "^(USER|ADMIN)$", message = "Role must be one of: USER, ADMIN, MODERATOR.")
	    private String role;
}
