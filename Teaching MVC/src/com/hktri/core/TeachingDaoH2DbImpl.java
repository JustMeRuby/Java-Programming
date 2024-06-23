package com.hktri.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hktri.beans.Course;
import com.hktri.beans.Professor;

public class TeachingDaoH2DbImpl implements TeachingDao {
	List<Professor> profs;
	List<Course> courses;
	
	// Remember to add h2.jar to build path and apache-tomcat-8.5/lib
	public TeachingDaoH2DbImpl()
	{
		profs = new ArrayList<>();
		courses = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection connection;
		try {
			// Create Database
			// This database is stored inside Eclipse Folder (not project folder)
			connection = DriverManager.getConnection("jdbc:h2:./Database/Teaching", "root", "h2");
			Statement statement = connection.createStatement();
			String query;
			
			// Create Table
			query = "CREATE TABLE Professor(profNo varchar(MAX), profName varchar(MAX))";
    		statement.execute(query);
    		query = "CREATE TABLE Course(courseNo varchar(MAX), courseName varchar(MAX))";
    		statement.execute(query);
    		
    		// Insert Values
    		query = "INSERT INTO Professor values ('001', 'Bob'), ('002', 'Alice'), ('003', 'Jimmy')";
    		statement.executeUpdate(query);
    		query = "INSERT INTO Course values ('MTH001', 'Java'), ('MTH002', 'Python'), ('MTH003', 'C++')";
    		statement.executeUpdate(query);
    		
    		// Get Data
    		ResultSet resultSet;
    		
    		query = "SELECT profNo, profName FROM Professor";
    		resultSet = statement.executeQuery(query);
    		while(resultSet.next()) {
				String profNo = resultSet.getString("profNo");
				String profName = resultSet.getString("profName");
				
				this.profs.add(new Professor(profNo, profName));
			}
    		
    		query = "SELECT courseNo, courseName FROM Course";
    		resultSet = statement.executeQuery(query);
    		while(resultSet.next()) {
				String courseNo = resultSet.getString("courseNo");
				String courseName = resultSet.getString("courseName");
				
				this.courses.add(new Course(courseNo, courseName));
			}

    		connection.close();
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Course> addCourse(String profNo, String courseNo, HttpServletRequest request) {
		Course temp = null;
		List<Course> result = null;
		
		boolean check = false;
		for (Professor p: profs)
		{
			if (p.getProfNo().equals(profNo))
			{
				result = p.getCourses();
				check = true;
				break;
			}
			check = false;
		}
		for (Course c: courses)
		{
			if (c.getCourseNo().equals(courseNo))
			{
				temp = c;
				check = true;
				break;
			}
			check = false;
		}
		
		if (check)
		{
			for (Professor p: profs)
			{
				if (p.getProfNo().equals(profNo))
				{
					boolean check2 = true;
					for (Course c: p.getCourses())
					{
						if (c.getCourseNo().equals(courseNo))
						{
							check2 = false;
							break;
						}
					}
					if (check2)
					{
						p.getCourses().add(temp);
						result = p.getCourses();
					}
					else {request.setAttribute("message", "The professor already had this course.");}
					
				}
			}
		}
		else {request.setAttribute("message", "profNo and/or courseNo do not exist.");}
		
		return result;
	}

	@Override
	public List<Course> deleteCourse(String profNo, String courseNo, HttpServletRequest request) {
		Course temp = null;
		List<Course> result = null;
		
		boolean check = false;
		for (Professor p: profs)
		{
			if (p.getProfNo().equals(profNo))
			{
				result = p.getCourses();
				check = true;
				break;
			}
			check = false;
		}
		for (Course c: courses)
		{
			if (c.getCourseNo().equals(courseNo))
			{
				temp = c;
				check = true;
				break;
			}
			check = false;
		}

		if (check)
		{
			for (Professor p: profs)
			{
				if (p.getProfNo().equals(profNo))
				{
					boolean check2 = false;
					for (Course c: p.getCourses())
					{
						if (c.getCourseNo().equals(courseNo))
						{
							check2 = true;
							break;
						}
					}
					if (check2)
					{
						p.getCourses().remove(temp);
						result = p.getCourses();
					}
					else {request.setAttribute("message", "The professor does not have this course, cannot delete what does not exist.");}
				}
			}
		}
		else {request.setAttribute("message", "profNo and/or courseNo do not exist.");}
		
		return result;
	}

}
