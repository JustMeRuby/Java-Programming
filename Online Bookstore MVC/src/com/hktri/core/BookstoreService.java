package com.hktri.core;

import java.util.List;

import com.hktri.bean.*;

public interface BookstoreService {
	List<Book> getBooks();
	List<Item> updateCart(String id, String quantity);
}
