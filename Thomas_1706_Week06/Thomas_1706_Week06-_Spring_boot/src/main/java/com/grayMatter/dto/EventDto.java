package com.grayMatter.dto;

import java.sql.Date;
import java.sql.Time;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
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
public class EventDto {
	
	 	@Positive(message = "Event ID must be positive")
	    private int eid;

	    @NotBlank(message = "Event name must not be blank")
	    @Size(max = 100, message = "Event name must not exceed 100 characters")
	    private String name;

	    @NotBlank(message = "Location must not be blank")
	    @Size(max = 200, message = "Location must not exceed 200 characters")
	    private String location;

	    @FutureOrPresent(message = "Date must be today or in the future")
	    private Date date;

	    @NotNull(message = "Start time must not be null")
	    @FutureOrPresent(message = "Start time must be in the past or present")
	    private Time startTime;

	    @NotNull(message = "End time must not be null")
	    @Future(message = "End time must be in the future")
	    private Time endTime;

	    @Positive(message = "Capacity must be positive")
	    @Min(value = 1, message = "Capacity must be at least 1")
	    private int capacity;

	
}
