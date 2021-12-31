package com.jwt.hibernate.entity;

import java.io.Serializable;


public class Employee implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private int empId;
    private String name;
    private int sal;
    private String city;
    private int phone;
	
    public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
    
    

}
