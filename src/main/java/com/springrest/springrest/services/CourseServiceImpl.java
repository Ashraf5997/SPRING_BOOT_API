

package com.springrest.springrest.services;
import com.springrest.springrest.dao.CourseDao;
import  com.springrest.springrest.entities.Course;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	 private CourseDao  courseDao;
	//List<Course>list;
	public CourseServiceImpl()
	{
	/*	list = new ArrayList<>();
		list.add(new Course(145,"Java Core"," thsi course contain basic of java"));
		list.add(new Course (4343 ," php core","this course contain basic of php ") );*/
	}
	
	@Override
	public List<Course> getCourses(int pageNo) {
		Pageable  paging = PageRequest.of(pageNo , 4);
		Page<Course> pagedResult = courseDao.findAll(paging);
		System.out.print("ITS PAGING");
		return pagedResult.toList();
		
	}

	@Override
	public Course getC(long parseLong) {
		return courseDao.findById(parseLong).get();
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		/*list.forEach( e ->{
			if(e.getId() == course.getId()) {
				
		         e.setTitle( course.getTitle() );
		         e.setDescription( course.getDescription());
			}
		} );*/
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		Course entity = courseDao.getOne(parseLong) ;
		 System.out.println("DELETE DATA  :"+entity);
		courseDao.delete(entity);
		// TODO Auto-generated method stub
		// list = this.list.stream().filter(e -> e.getId() != parseLong ).collect(Collectors.toList());
	}
	
	

}
