package com.hktri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainTest
 */
@WebServlet("/MainTest")
public class MainTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		if (id == null) {
			session.setAttribute("id", "001");
			out.println("Welcome new");
		} else {
			out.println("Welcome back, id = " + id);
		}
		
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			session.setAttribute("count", 1);
		} else {
			count = count + 1;
			session.setAttribute("count", count);
		}
		out.println("Welcome, count = " + session.getAttribute("count"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
