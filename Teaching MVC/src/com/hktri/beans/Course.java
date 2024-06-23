package com.hktri.beans;

public class Course {
	private String courseNo;
	private String courseName;
	
	public Course(String courseNo, String courseName)
	{
		this.courseNo = courseNo;
		this.courseName = courseName;
	}
	
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
