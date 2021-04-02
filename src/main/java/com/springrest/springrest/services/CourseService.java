
package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springrest.springrest.entities.Course;

public interface CourseService {

	//public List<Course> getCourses(); 
	public List<Course> getCourses( int pageNo ); 
	public Course getC(long parseLong);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long parseLong);
}
