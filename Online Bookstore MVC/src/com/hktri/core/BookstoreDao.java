package com.hktri.core;

import java.util.List;

import com.hktri.bean.Book;
import com.hktri.bean.Item;

public interface BookstoreDao {
	List<Book> getBooks();
	List<Item> updateCart(String id, String quantity);
}
