package com.test1;

public class Truck extends Vehicle {
	
	private String fuel;
	
	public Truck() {
		super(); // Vehicle()을 호출함
	}
	
	// 생성자 오버로드(constructor overload)
	public Truck(int people, String kind, int length, float maxloads, String fuel) {
		super(people,kind,length,maxloads); // 부모클래스에 생성자가 있다면 그냥 상속받아서 쓰자
//		setPeople(people);
//		setKind(kind);
//		setLength(length);
//		setMaxloads(maxloads);
		setFuel(fuel);
	}
	
	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	//메소드 오버라이드(Override) 부모에게 상속받은 로직에 덮어 쓰는 것
	@Override
	public int getCost() {
		return (int)getMaxloads() * 2;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf(", 연료:%s \n", fuel);
	}
}
