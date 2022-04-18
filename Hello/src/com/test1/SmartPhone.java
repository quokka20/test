package com.test1;

public class SmartPhone extends ElectronicDevices {
	
	private int weight;
	
	public SmartPhone() {}

	public SmartPhone(String name, int price, String madeBy, int weight) {
		super(name, price, madeBy);
		setWeight(weight);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf(", 제품무게:%d \n",weight);
	}


	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
