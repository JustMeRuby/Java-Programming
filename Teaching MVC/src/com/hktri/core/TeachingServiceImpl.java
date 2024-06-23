package com.hktri.core;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hktri.beans.Course;

public class TeachingServiceImpl implements TeachingService {
	TeachingDao dao = new TeachingDaoH2DbImpl();

	@Override
	public List<Course> addCourse(String profNo, String courseNo, HttpServletRequest request) {
		return dao.addCourse(profNo, courseNo, request);
	}

	@Override
	public List<Course> deleteCourse(String profNo, String courseNo, HttpServletRequest request) {		
		return dao.deleteCourse(profNo, courseNo, request);
	}
}
