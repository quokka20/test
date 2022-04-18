package com.test1;

public class Vector {
	int num1;
	int num2;
	
	public Vector(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public Vector add(Vector v) {

		return new Vector(num1+v.num1,num2+v.num2);
	}
	
	public Vector sub(Vector v) {

		return new Vector(num1-v.num1, num2-v.num2);
	}
	
	public void print() {
		System.out.printf("(%d,%d)",num1,num2);
	}
}
