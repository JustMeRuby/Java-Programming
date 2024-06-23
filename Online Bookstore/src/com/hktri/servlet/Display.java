package com.hktri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hktri.classes.Book;
import com.hktri.classes.Bookstore;


@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Bookstore books = new Bookstore();
    public Display() {
        Book java = new Book("1", "Java", "Will Smith", "Java For Beginners", 10);
        Book cpp = new Book("2", "C++", "Chris Rock", "C++ For Chads", 15.5);
        Book python = new Book("3", "Python", "Jada", "Python For Snakes", 7.9);
        
        books.addBook(java);
        books.addBook(cpp);
        books.addBook(python);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		out.println("<h1 style=\"text-align:center\">BOOKSTORE</h1>");
		for (int i = 0; i < books.getBookList().size(); i++)
		{
			Book b = books.getBookList().get(i);
			out.println("<p>Title: " + b.getTitle() + "</p>");
			out.println("<p>Author: " + b.getAuthor() + "</p>");
			out.println("<p>Description: " + b.getDescription() + "</p>");
			out.println("<p>Price: " + String.valueOf(b.getPrice()) + "$</p>");
			out.println("<form action=\"Cart\" method=\"POST\">"
						+ "<input type=\"hidden\" name=\"id\" value=\"" + b.getId() + "\">"
						+ "<input type=\"submit\" value=\"Add to Shopping Cart\">"
						+ "</form>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
