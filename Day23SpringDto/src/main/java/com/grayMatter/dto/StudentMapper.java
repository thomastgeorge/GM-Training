package com.grayMatter.dto;

import org.springframework.stereotype.Component;

import com.grayMatter.entities.Student;

@Component
public class StudentMapper {
	
	public Student maptoStudent(StudentDto sDto) {
		return new Student(sDto.getName(), sDto.getId());
	}
	
	public StudentDto mapToStudentDto(Student s) {
		return new StudentDto(s.getName(), s.getId());
	}

}
