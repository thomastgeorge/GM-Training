package com.grayMatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grayMatter.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	
	
	@Query(value= "SELECT * FROM assessment05candidate c WHERE c.email LIKE ?1 AND c.password LIKE ?2", nativeQuery=true)
	public Candidate findByCredentials(String email, String password);

}
