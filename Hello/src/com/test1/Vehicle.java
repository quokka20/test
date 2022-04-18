package com.test1;

public class Vehicle {

	private int people;
	private String kind; // Truck, Motocycle
	private int length;
	private float maxloads;	
	private static String company = "Korea Trans";
	
	public Vehicle() {}
	
	public Vehicle(int people, String kind, int length, float maxloads) {
		super();
		setPeople(people);
		setKind(kind);
		setLength(length);
		setMaxloads(maxloads);
	}
	
	public int getCost() {
		return 0;
	}
	public void print() {
		System.out.printf("ž���ο�:%d, ����:%s, ����:%d, �����߷�:%.1f",people, kind, length, maxloads);
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		if(kind.equals("Truck") || kind.equals("Motocycle")) {
			this.kind = kind;
		} else {
			System.err.println("Truck, Motocycle �� �ϳ����� �մϴ�.");
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getMaxloads() {
		return maxloads;
	}

	public void setMaxloads(float maxloads) {
		this.maxloads = maxloads;
	}

	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {
		Vehicle.company = company;
	}
	

	
	
	
}
