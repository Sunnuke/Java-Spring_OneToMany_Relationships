package com.practice.onetomanyrelationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.onetomanyrelationships.models.School;
import com.practice.onetomanyrelationships.models.Student;
import com.practice.onetomanyrelationships.services.SchoolService;
import com.practice.onetomanyrelationships.services.StudentService;

public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private SchoolService schoolService;
	
	// New Student
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		List<School> schools = schoolService.allSchools();
		model.addAttribute("schools", schools);
		return "/student/newStudent.jsp";
	}
	
	// Create Student
	@RequestMapping(value = "/Student", method = RequestMethod.POST)
	public String newStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/student/new";
		} else {
			Student stud = studentService.createStudent(student);
			Long id = stud.getSchool().getId();
			return "redirect:/schools/" + id;
		}	
	}
}
