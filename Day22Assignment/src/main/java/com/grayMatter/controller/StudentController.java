package com.grayMatter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.dao.StudentDao;
import com.grayMatter.entity.Student;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentController {
	
	public final StudentDao studentDao;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllData() {
		List<Student> student = studentDao.getAllData();
		if(student.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student data is Empty!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Student data is :"+student);
	}
	
	
	
	@GetMapping("/getData/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		Optional<Student> student = studentDao.getById(id);
		
		if(student == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student data is not present in DataBase!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Student data is :"+student.get());
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		Optional<Student> student = studentDao.getById(id);
		studentDao.deleteById(id);
		if(student == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student Not present in DataBase!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Student data is Deleted : "+student.get());
	}
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> add(@RequestBody Student student) {
		Student s = studentDao.addStudent(student);

		if(s == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student Data present in DataBase!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Student data is Added to DataBase : "+student);
	} 
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable int id) {
		
		Optional<Student> s1 = studentDao.getById(id);
		
		if(s1 == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student Data present in DataBase!!");
		}
		Student s = studentDao.update(s1.get(),student);
		return ResponseEntity.status(HttpStatus.OK).body("Student data is Added to DataBase : "+s);
		
	}

}