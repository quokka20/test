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
		System.out.printf("탑승인원:%d, 차종:%s, 전장:%d, 적재중량:%.1f",people, kind, length, maxloads);
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
			System.err.println("Truck, Motocycle 중 하나여야 합니다.");
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
