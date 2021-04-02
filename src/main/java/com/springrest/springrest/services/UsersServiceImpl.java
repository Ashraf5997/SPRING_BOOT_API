package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.UsersDao;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Users;
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	 private UsersDao  usersDao;
	//List<Course>list;
	public UsersServiceImpl()
	{
	/*	list = new ArrayList<>();
		list.add(new Course(145,"Java Core"," thsi course contain basic of java"));
		list.add(new Course (4343 ," php core","this course contain basic of php ") );*/
	}
	@Override
	public Users userRegistration(Users userData) {
		
		return usersDao.save(userData);
	}
	
	@Override
	public Users userLogin(Users userData) {
		String useremail = userData.getUseremail();
		String userpassword = userData.getUserpassword();
		// System.out.println(useremail);
		// System.out.println(userpassword);
		Users  data =  usersDao.findByUseremailAndUserpassword(useremail,userpassword);
		return data;
	}
	@Override
	public List<Users> getUsers() {
	
			
			return usersDao.findAll();
		
	}
	
	@Override
	public List<Users> users(int pageNo) {
		Pageable  paging = PageRequest.of(pageNo , 12);
		Page<Users> pagedResult = usersDao.findAll(paging);
		//System.out.print("ITS PAGING");
		return pagedResult.toList();
		
	}

	@Override
	public Users getUserById(long parseLong) {
		return usersDao.findById(parseLong).get();
	}

	

	@Override
	public Users updateUserById(Users userData) {
		/*list.forEach( e ->{
			if(e.getId() == course.getId()) {
				
		         e.setTitle( course.getTitle() );
		         e.setDescription( course.getDescription());
			}
		} );*/
		usersDao.save(userData);
		return userData;
	}

	@Override
	public void deleteUserById(long parseLong) {
		Users entity = usersDao.getOne(parseLong) ;
		 System.out.println("DELETE DATA  :"+entity);
		usersDao.delete(entity);
		// TODO Auto-generated method stub
		// list = this.list.stream().filter(e -> e.getId() != parseLong ).collect(Collectors.toList());
	}
	
}
