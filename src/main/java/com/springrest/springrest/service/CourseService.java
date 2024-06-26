package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getSpecificCourse(long x);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void removeCourse(long courseId);
	
}
