package com.jean.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jean.model.Course;
import com.jean.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")

//@AllArgsConstructor
public class CourseController {
	
	private CourseRepository courseRepostiroy;
	
	

	public CourseController(CourseRepository courseRepostiroy) {
		this.courseRepostiroy = courseRepostiroy;
	}



	@GetMapping
	//@RequestMapping(method = RequestMethod.GET)
	public List<Course> list(){
		return this.courseRepostiroy.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Course> create(@RequestBody Course course) {
		//return courseRepostiroy.save(course);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(courseRepostiroy.save(course));
	}
	
}
