package com.hktri.core;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hktri.beans.Course;

public interface TeachingDao {
	List<Course> addCourse(String profNo, String courseNo, HttpServletRequest request);
	List<Course> deleteCourse(String profNo, String courseNo, HttpServletRequest request);
}
