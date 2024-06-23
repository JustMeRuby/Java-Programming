package com.hktri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hktri.classes.Book;
import com.hktri.classes.Bookstore;
import com.hktri.classes.Item;
import com.hktri.classes.Cart;


@WebServlet("/Cart")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	Bookstore books = new Bookstore();
    public Payment() {
        Book java = new Book("1", "Java", "Will Smith", "Java For Beginners", 10);
        Book cpp = new Book("2", "C++", "Chris Rock", "C++ For Chads", 15.5);
        Book python = new Book("3", "Python", "Jada", "Python For Snakes", 7.9);
        
        books.addBook(java);
        books.addBook(cpp);
        books.addBook(python);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String quantity = request.getParameter("quantity");
		Cart itemList = (Cart) session.getAttribute("ItemList");
		
		if (itemList == null)
			itemList = new Cart();
		
		boolean check = true;
		if (id != null)
		{
			if (quantity == null)
			{
				for (Item i: itemList.getItemList())
				{
					if (i.getId().equals(id))
					{
						i.setQuantity(i.getQuantity() + 1);
						check = false;
						break;
					}
				}
				if (check)
				{
					for (int i = 0; i < books.getBookList().size(); i++)
					{
						Book b = books.getBookList().get(i);
						if (b.getId().equals(id))
						{
							itemList.addItem(new Item(b.getId(), b.getTitle(), b.getAuthor(), b.getDescription(), b.getPrice(), 1));
							break;
						}
					}
				}
			}
			else
			{
				for (Item i: itemList.getItemList())
				{
					if (i.getId().equals(id))
					{					
						if (quantity.matches("-?\\d+")) i.setQuantity(Integer.parseInt(quantity));
						else if (quantity.length() == 0) i.setQuantity(0);
						else out.println("<script>alert(\"Wrong Format For Quantity: \" + \"" + quantity + "\")</script>");
						break;
					}
				}
			}
		}
		
		session.setAttribute("ItemList", itemList);
		
		out.println("<h1 style=\"text-align:center\">SHOPPING CART</h1>");
		for (Item i: itemList.getItemList())
		{
			if (i.getQuantity() > 0)
			{
				out.println("<p>Item ID: " + i.getId() + "</p>");
				out.println("<p>Description: " + i.getTitle() + " by " + i.getAuthor() + "</p>");
				out.println("<p>Unit Cost: " + i.getPrice() + "$");
				out.println("<form action=\"Cart\" method=\"POST\">"
						+ "<input type=\"hidden\" name=\"id\" value=\"" + i.getId() + "\">"
						+ "Quantity: <input type=\"number\" name=\"quantity\" value=\"" + i.getQuantity() + "\">"
						+ "<input type=\"submit\" name=\"update\" value=\"Update\">"
						+ "</form>");
				out.println("<p>Total Cost: " + i.getPrice() * i.getQuantity() + "$</p><br>");
			}
		}
		
		out.println("<p style=\"text-align:center\">Click <a href=\"Display\">here</a> to return to home page</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
