package com.test1;

public class Product {
	private String name;
	private String madeBy;
	private String date;
	private int price;
	
	public Product() {}
	
	public Product(String name, String madeBy, String date, int price) {
		setName(name);
		setMadeBy(madeBy);
		setDate(date);
		setPrice(price);
	}

	public void print() {
		System.out.printf("%s\t%s\t%s\t%d \n",name,madeBy,date,price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
