package com.grayMatter.entities;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.domain.Persistable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="project22Person") //Captial letter gives underscore
public class Person implements Persistable<Long> {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private long aid;
	@Column(name="personName")
	@Size(min=3, message="Person name must be min 3 chars length")
	private String name;
	@NotBlank
	@Pattern(regexp = "[6789][0-9]{9}", message="mobile no. should be of 10 length, starting with 6,7,8,9")
	private String mobile;
	@Range(min=18, message="Age must be >= 18")
	private int age;
	@Email
	private String email;
	
	
	@Transient
	@Builder.Default
	private boolean isNewId=true;
	
	@Override
	public Long getId() {

		return null;
	}

	@Override
	public boolean isNew() {
		return isNewId;
	}

}
