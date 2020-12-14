package com.practice.onetomanyrelationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.onetomanyrelationships.models.Student;
import com.practice.onetomanyrelationships.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
//	RETRIEVE
	public List<Student> allStudents(){
		return studentRepository.findAll();
	}
	
	
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		}
		else {
			return null;
		}

	}
	
//	CREATE
	public Student createStudent(Student student) {
		return studentRepository.save(student);
		
	}
}
