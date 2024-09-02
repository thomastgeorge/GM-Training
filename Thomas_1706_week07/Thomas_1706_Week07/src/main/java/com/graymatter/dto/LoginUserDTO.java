package com.graymatter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUserDTO {
	
	@NotBlank(message = "Email cannot be null or empty.")
    @Email(message = "Email should be valid.")
    private String email;

    @NotBlank(message = "Password cannot be null or empty.")
    @Size(min = 6, message = "Password must be at least 8 characters long.")
    private String password;

}
