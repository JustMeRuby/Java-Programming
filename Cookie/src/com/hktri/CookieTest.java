package com.hktri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String getCookieValue(HttpServletRequest request, String name) {
    	String value = "";
    	return value;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		if (getCookieValue(request, "id") != null) {
			out.println("Has cookie");
			return;
		}
		
		String count = getCookieValue(request, "count");
		Cookie cookie = null;
		if (count != null) {
			cookie = new Cookie("count", "1");
			return;
		} else {
			cookie = new Cookie("count", String.valueOf(Integer.parseInt(count)+1));
		}
		 //out.println("Create cookie");
		 //Cookie cookie = new Cookie("id", "1");
		 response.addCookie(cookie);
		 out.println("Access Count " + cookie.getValue());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
