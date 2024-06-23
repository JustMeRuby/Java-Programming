package com.hktri.core;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hktri.beans.Course;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    TeachingService service = new TeachingServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String profNo = request.getParameter("profNo");
		String courseNo = request.getParameter("courseNo");
		
		String address = "WEB-INF/mainPage.jsp";
		if (profNo != null && courseNo != null && request.getParameter("add") != null)
		{
			List<Course> temp = service.addCourse(profNo, courseNo, request);
			if (temp != null)
			{
				request.setAttribute("profNo", profNo);
				request.setAttribute("courses", temp);
				address = "WEB-INF/displayCourses.jsp";
			}
		}
		else if (profNo != null && courseNo != null && request.getParameter("delete") != null)
		{
			List<Course> temp = service.deleteCourse(profNo, courseNo, request);
			if (temp != null)
			{
				request.setAttribute("profNo", profNo);
				request.setAttribute("courses", temp);
				address = "WEB-INF/displayCourses.jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
