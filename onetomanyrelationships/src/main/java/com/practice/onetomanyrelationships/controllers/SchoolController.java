package com.practice.onetomanyrelationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.onetomanyrelationships.models.School;
import com.practice.onetomanyrelationships.models.Student;
import com.practice.onetomanyrelationships.services.SchoolService;

@Controller
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	// New School
	@RequestMapping("/schools/new")
	public String newSchool(@ModelAttribute("school") School school, Model model) {
		return "/school/newSchool.jsp";
	}
	
	// Create Student
	@RequestMapping(value = "/School", method = RequestMethod.POST)
	public String newSchool(@Valid @ModelAttribute("school") School school, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/schools/new";
		} else {
			schoolService.createSchool(school);
			return "redirect:/students/new";
		}	
	}
	
	// Selected School
	@RequestMapping("/schools/{id}")
	public String schoolLog(@PathVariable("id") Long id, Model model) {
		School school = schoolService.findSchool(id);
		List<Student> students = school.getStudent();
		model.addAttribute("school", school);
		model.addAttribute("students", students);
		return "/school/school.jsp";
	}
}
