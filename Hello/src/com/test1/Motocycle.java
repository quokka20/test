package com.test1;

public class Motocycle extends Vehicle {
	
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Motocycle(int people, String kind, int length, float maxloads ,int speed) {
		super(people,kind,length,maxloads);
		setSpeed(speed);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf(", ¼Óµµ:%d \n", speed);
	}
	
	@Override
	public int getCost() {
		return speed * 5;
	}
	
}
