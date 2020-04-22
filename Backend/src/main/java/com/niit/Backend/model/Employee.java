package com.niit.Backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="details")
@Entity
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

public int id;

@Column(name="Employee name")
public String name;

@Column(name="Mailid")
public String email;

@Column(name="Contact")
public String phoneno;

@Column(name="Dob ")
public String dob;

@Column(name="Education")
public String qualifiction;

@Column(name="Field")
public String department;


public Employee()
{
	
}


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


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPhoneno() {
	return phoneno;
}


public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}


public String getDob() {
	return dob;
}


public void setDob(String dob) {
	this.dob = dob;
}


public String getQualifiction() {
	return qualifiction;
}


public void setQualifiction(String qualifiction) {
	this.qualifiction = qualifiction;
}


public String getDepartment() {
	return department;
}


public void setDepartment(String department) {
	this.department = department;
}


}
