package com.grayMatter.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="assessment05candidate")
public class Candidate {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidateId;
    private String name;
    private List<String> skills;
    private String mobile;
    private String email;
    private Date dob;
    private String password;
    
}
