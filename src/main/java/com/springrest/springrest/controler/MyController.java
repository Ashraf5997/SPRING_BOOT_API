package com.springrest.springrest.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Users;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	@GetMapping("/welcomes")
	
	public String welcomes()
	{
		//return "WELCOME TO DEMO FRC [FRESHERS RESUME CREATER] ";
		  return "<html><body>"
          + "<h1>WELCOME to sefef</h1>"
          + "</body></html>"; 
	}
	
	// get all courses 
	
	@GetMapping("/course/{pageNo}")
	public ResponseEntity<List<Course>> getCourses(@PathVariable int  pageNo)
	{
		//Pageable pageable = PageRequest.of(page, 5);
	//	l courseService.getCourses(pageNo);
		List<Course>list=courseService.getCourses(pageNo);
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
		
	}
	
	// get single course
	@GetMapping("/courses/{courseId}")
	public  Course getC( @PathVariable String courseId )
	{   
		return this.courseService.getC(Long.parseLong(courseId));
	}
	
	// post course
	@PostMapping("/courses")
	public ResponseEntity<HttpStatus>addCourse(@RequestBody Course course)
	{
		try {
			   
			 this.courseService.addCourse(course);
			 return new ResponseEntity<>(HttpStatus.CREATED);
			
		}catch(Exception e) {
			
			 return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	// update course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
			return this.courseService.updateCourse(course);
		
	}	
	
	// delete course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity <HttpStatus> deleteCourse (@PathVariable String courseId)
	{
	 try {   
			    this.courseService.deleteCourse(Long.parseLong(courseId));
				return new ResponseEntity<>(HttpStatus.OK);
				
		}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}	

}
