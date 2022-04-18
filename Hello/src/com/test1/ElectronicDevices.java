package com.test1;

public class ElectronicDevices {
	private String name;
	private int price;
	private String madeBy;
	
	public ElectronicDevices() {}

	public ElectronicDevices(String name, int price, String madeBy) {
		super();
		setName(name);
		setPrice(price);
		setMadeBy(madeBy);
	}
	
	public void print() {
		System.out.printf("제품명:%s, 가격:%d, 제조사:%s", name, price, madeBy);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}
	
	
}
