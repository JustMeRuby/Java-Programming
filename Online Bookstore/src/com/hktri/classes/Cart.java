package com.hktri.classes;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Item> itemList;
	
	public Cart()
	{
		this.itemList = new ArrayList<>();
	}
	
	public void addItem(Item i)
	{
		this.itemList.add(i);
	}

	public List<Item> getItemList() {
		return itemList;
	}
}
