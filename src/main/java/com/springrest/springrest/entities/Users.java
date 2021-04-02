package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	
	private String username;
	@Column( unique=true )
	private String useremail ;
	private String userpassword;
	private String pincode;
	private String block;
	private String district;
	private String state;
	private String country;
	
public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	//	@OneToOne(cascade= CascadeType.ALL)
	//private Course course;
	public Users( String username, String useremail, String userpassword ) {
		super();
		
		this.username = username;
		this.useremail = useremail;
		this.userpassword = userpassword;
		//this.course = course;
	}
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}


	/*public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}*/
	
	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public String getUserpassword() {
		return userpassword;
	}


	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	

	/*@Override
	public String toString() {
		return " Users[username=" + username + ", useremail=" + useremail +",userpassword="+userpassword
				+ ", getUsername()=" + getUsername() + ", getUseremail()=" + getUseremail() +",getUserpassword()="+getUserpassword()+ ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}*/
	
	

}
