package com.hktri.core;


import java.util.List;

import com.hktri.bean.*;

public class ServiceImpl implements BookstoreService {	
	BookstoreDao dao = new BookstoreDaoH2DbImpl();

	@Override
	public List<Book> getBooks() {		
		return dao.getBooks();
	}

	@Override
	public List<Item> updateCart(String id, String quantity) {
		return dao.updateCart(id, quantity);
	}
}
