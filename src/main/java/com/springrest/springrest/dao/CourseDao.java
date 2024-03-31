package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	// JpaRepository >> contains all the method required for dao layer
	
}
