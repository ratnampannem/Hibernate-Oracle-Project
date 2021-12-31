package com.jwt.hibernate.entity;

import java.io.Serializable;

public class Department implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int deptId;
	private String name;
	private int strength;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
	
	
}
