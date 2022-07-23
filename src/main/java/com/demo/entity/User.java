package com.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
@Entity
@Table(name="users")
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE users SET is_active=false WHERE id=?")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mobileNumber; 
	private boolean isActive = true;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
		
	}
	public User() {
		super();
		//TODO Auto-generated constructor stub
	}
	public User(int id, String name, String mobileNumber, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.isActive = isActive;
		
	}
	
	
	
	
	
	

}