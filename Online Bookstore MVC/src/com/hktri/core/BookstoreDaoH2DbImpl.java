package com.hktri.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hktri.bean.Book;
import com.hktri.bean.Item;

public class BookstoreDaoH2DbImpl implements BookstoreDao{
	List<Item> items;
	List<Book> books;
	
	// Remember to add h2.jar to build path and apache-tomcat-8.5/lib
	public BookstoreDaoH2DbImpl()
	{
		books = new ArrayList<>();
		items = new ArrayList<>();
		
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
			connection = DriverManager.getConnection("jdbc:h2:./Database/Bookstore", "root", "h2");
			Statement statement = connection.createStatement();
			String query;
			
			// Create Table
			query = "CREATE TABLE Book(id varchar(MAX), title varchar(MAX), author varchar(MAX), description varchar(MAX), price double)";
    		statement.execute(query);
    		
    		// Insert Values
    		query = "INSERT INTO Book values ('1', 'Java', 'Will Smith', 'Java For Beginners', 10), "
    				+ "('2', 'C++', 'Chris Rock', 'C++ For Chads', 15.5), "
    				+ "('3', 'Python', 'Amber Turd', 'Python For Snakes', 7.9)";
    		statement.executeUpdate(query);
    		
    		// Get Data
    		query = "SELECT id, title, author, description, price " + "FROM Book";
    		ResultSet resultSet = statement.executeQuery(query);
    		while(resultSet.next()) {
				String id = resultSet.getString("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String description = resultSet.getString("description");
				Double price = resultSet.getDouble("price");
				
				this.books.add(new Book(id, title, author, description, price));
			}

    		connection.close();
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Book> getBooks() {		
		return books;
	}

	@Override
	public List<Item> updateCart(String id, String quantity) {
		if (quantity == null)
		{
			boolean check = true;
			for (Item i: items)
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
				for (int i = 0; i < books.size(); i++)
				{
					Book b = books.get(i);
					if (b.getId().equals(id))
					{
						items.add(new Item(b.getId(), b.getTitle(), b.getAuthor(), b.getDescription(), b.getPrice(), 1));
						break;
					}
				}
			}
		}
		else
		{
			for (Item i: items)
			{
				if (i.getId().equals(id))
				{					
					if (quantity.matches("-?\\d+"))
					{
						if (Integer.parseInt(quantity) >= 0) i.setQuantity(Integer.parseInt(quantity));
						else i.setQuantity(0);
					}
					else if (quantity.length() == 0) i.setQuantity(0);
//					else System.out.println("Wrong Format For Quantity: " + quantity);
					break;
				}
			}
		}
		return items;
	}
}
