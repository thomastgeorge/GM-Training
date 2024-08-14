package com.grayMatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entities.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer> {

}
