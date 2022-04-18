package com.test1;

public class Desktop extends ElectronicDevices {

	private String madeYear;
	
	public Desktop() {}

	public Desktop(String name, int price, String madeBy, String madeYear) {
		super(name, price, madeBy);
		setMadeYear(madeYear);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf(", 제조년도:%s \n",madeYear);
	}

	public String getMadeYear() {
		return madeYear;
	}

	public void setMadeYear(String madeYear) {
		this.madeYear = madeYear;
	}
	
	
}
