package com.grayMatter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.entity.Student;
import com.grayMatter.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceInterface  {
	
	@Autowired
	public final StudentRepository studentRepository;

	@Override
	public List<Student> getAllData() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getById(int id) {
		return studentRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);;
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student update(Student student, Student newStudent) {
		student.setDepartment(newStudent.getDepartment());
		return studentRepository.save(student);
	}

}