package com.hktri.beans;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private String profNo;
	private String profName;
	private List<Course> courses;
	
	public Professor(String profNo, String profName)
	{
		this.profNo = profNo;
		this.profName = profName;
		this.courses = new ArrayList<>();
	}
	
	public String getProfNo() {
		return profNo;
	}
	public void setProfNo(String profNo) {
		this.profNo = profNo;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
