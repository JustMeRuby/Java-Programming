package com.hktri.bean;

public class Item extends Book{
	private int quantity;
	
	public Item(String id, String title, String author, String description, double price, int quantity)
	{
		super(id, title, author, description, price);
		setQuantity(quantity);
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
