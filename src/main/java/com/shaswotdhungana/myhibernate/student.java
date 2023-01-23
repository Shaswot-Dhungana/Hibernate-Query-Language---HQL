package com.shaswotdhungana.myhibernate;



import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//to use custom name for table in database use :~
// @Entity Annotation is used to select which class will be linked with table in database.
//@Entity(name="student_details")
//OR
//@Table(name="student_details")
// if we use only @Entity then table name will be same as class name.
// @Id annotation is used to choose primary key.
// @GeneratedValue annotation for auto increment id / primary key.



@Entity(name="student_details")
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class student {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	private String name;
	private String gender;
	
	private Certificate certi;
	
	
	
	public student(int uid, String name, String gender) {
		super();
		this.uid = uid;
		this.name = name;
		this.gender = gender;
	}
	
	
	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String country) {
		this.gender = country;
	}


	
	
	
	public Certificate getCerti() {
		return certi;
	}


	public void setCerti(Certificate certi) {
		this.certi = certi;
	}


	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.uid+","+this.name+","+this.gender;
	}

	
}
