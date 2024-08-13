package com.grayMatter.service;

import java.util.List;
import java.util.Optional;

import com.grayMatter.entity.Student;

public interface ServiceInterface {

	public List<Student> getAllData();
	public Optional<Student> getById(int id);
	public void delete(int id);
	public Student addStudent(Student student);
	public Student update(Student student, Student newStudent);
}
