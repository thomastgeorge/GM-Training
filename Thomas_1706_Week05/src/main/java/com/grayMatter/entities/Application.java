package com.grayMatter.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="assessment05application")
public class Application {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;
    private Date appliedDate;

    @ManyToOne
    @JoinColumn(name = "jobId", nullable = false)
    private Job jobId;

    @ManyToOne
    @JoinColumn(name = "candidateId", nullable = false)
    private Candidate candidateId;
}
