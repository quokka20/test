package com.test1;

public class Cat extends Animal {
	
	private String caution;
	
	public Cat() {}
	
	public String getCaution() {
		return caution;
	}



	public void setCaution(String caution) {
		this.caution = caution;
	}



	public Cat(String species, int age, int price, float weight, String color, String caution) {
		super(species, age, price, weight, color);
		setCaution(caution);
	}



	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.printf(", 주의사항:%s \n", caution);
	}
	
	
}
