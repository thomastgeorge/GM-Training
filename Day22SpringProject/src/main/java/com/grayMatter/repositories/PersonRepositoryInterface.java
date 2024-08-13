package com.grayMatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entities.Person;

public interface PersonRepositoryInterface extends JpaRepository<Person, Long>{

}
