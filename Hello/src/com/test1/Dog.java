package com.test1;

public class Dog extends Animal {
	private String food;
	
	public Dog() {}

	public Dog(String species, int age, int price, float weight, String color, String food) {
		super(species, age, price, weight, color);
		setFood(food);
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.printf(", ∏‘¿Ã:%s \n",food);
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("∏€∏€");
	}
	
	
}
