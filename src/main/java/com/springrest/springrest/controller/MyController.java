package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.service.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String homeAPI() {
		return "Welcome to home page!";
	}
	
	// get all course, Course > entity
	// alternatively 
	//@RequestMapping(path = "/getCourses", method=RequestMethod.GET)
	
	@GetMapping("/getCourses")
	public List<Course> getCoursesAPI() {
		return this.courseService.getCourses();
	}
	// get course with id
	@GetMapping("/getCourse/{courseId}")
	public Course getCourseAPI(@PathVariable String courseId) {
		return this.courseService.getSpecificCourse(Long.parseLong(courseId));
	}

	//Post the course
	@PostMapping(path =  "/addCourse", consumes = "application/json")
	public Course addCourseAPI(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/updateCourses")
	public Course updateCourseAPI(@RequestBody  Course course) {
		return this.courseService.updateCourse(course);
	}
	
//	@DeleteMapping("/removeCourse")
//	public String removeCourseAPI(@RequestBody Course course) {
//		return this.courseService.removeCourse(course);
//	}
	
	@DeleteMapping("/removecourse/{courseId}")
	public ResponseEntity<HttpStatus> removeCourseAPI(@PathVariable String courseId){
		try {
			this.courseService.removeCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		 
		 
	}
	
}
