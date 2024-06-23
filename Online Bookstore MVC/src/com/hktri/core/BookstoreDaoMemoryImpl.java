package com.hktri.core;

import java.util.ArrayList;
import java.util.List;

import com.hktri.bean.Book;
import com.hktri.bean.Item;

public class BookstoreDaoMemoryImpl implements BookstoreDao{
	List<Item> items;
	List<Book> books;
	
	public BookstoreDaoMemoryImpl()
	{
		books = new ArrayList<>();
		books.add(new Book("1", "Java", "Will Smith", "Java For Beginners", 10));
		books.add(new Book("2", "C++", "Chris Rock", "C++ For Chads", 15.5));
		books.add(new Book("3", "Python", "Amber Turd", "Python For Snakes", 7.9));
		
		items = new ArrayList<>();
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
