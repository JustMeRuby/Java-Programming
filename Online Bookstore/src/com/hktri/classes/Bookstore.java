package com.hktri.classes;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {
	private List<Book> bookList;
	
	public Bookstore()
	{
		this.bookList = new ArrayList<>();
	}
	
	public void addBook(Book b)
	{
		this.bookList.add(b);
	}

	public List<Book> getBookList() {
		return bookList;
	}
}
