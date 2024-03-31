package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{
	
	// declaring an List
	private List<Course> list;
	
	public CourseServiceImpl() {
		
		list = new ArrayList<>();
		list.add(new Course(1, "Java", "This is java course"));
		list.add(new Course(2, "C++", "This is C++ course"));
		list.add(new Course(3, "SQL", "This is SQL course"));
		list.add(new Course(4, "Python", "This is Python course"));
		
		
	}
	
	@Override
	public List<Course> getCourses() {
		
		return list;
	}
	
	@Override
	public Course getSpecificCourse(long x) {
		
		for(Course c: list) {
			if(c.getId()==x){
				return c;
			}	
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	public Course updateCourse1(Course course) {
		for(Course c: list) {
			if(c.getId()==course.getId()) {
				c.setName(course.getName());
				c.setDescription(course.getDescription());
				return c;
			}
		}
		return null;
	}
	
	@Override
	public Course updateCourse(Course course) {
		
		Course c = getSpecificCourse(course.getId());

		c.setName(course.getName());
		c.setDescription(course.getDescription());
		return c;

	}

	@Override
	public void removeCourse(long courseId) {
//		Course c = getSpecificCourse(course.getId());
//		list.remove(c);
//		return "Removed the course : "+ course.toString() +" successfully!";
		
	list  = this.list.stream().filter(e->e.getId()!= courseId).collect(Collectors.toList());

	}
	
	
	
	

}
