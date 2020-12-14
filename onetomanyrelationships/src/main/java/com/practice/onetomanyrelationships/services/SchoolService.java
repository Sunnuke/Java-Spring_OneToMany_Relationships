package com.practice.onetomanyrelationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.practice.onetomanyrelationships.models.School;
import com.practice.onetomanyrelationships.repositories.SchoolRepository;

public class SchoolService {
	
	@Autowired
	private SchoolRepository schoolRepository;
	
//	RETRIEVE
	public List<School> allSchools(){
		return schoolRepository.findAll();
	}
	
	
	public School findSchool(Long id) {
		Optional<School> optionalSchool = schoolRepository.findById(id);
		if (optionalSchool.isPresent()) {
			return optionalSchool.get();
		}
		else {
			return null;
		}

	}
	
//	CREATE
	public School createSchool(School school) {
		return schoolRepository.save(school);
		
	}
}
