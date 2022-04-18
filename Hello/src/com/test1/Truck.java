package com.test1;

public class Truck extends Vehicle {
	
	private String fuel;
	
	public Truck() {
		super(); // Vehicle()�� ȣ����
	}
	
	// ������ �����ε�(constructor overload)
	public Truck(int people, String kind, int length, float maxloads, String fuel) {
		super(people,kind,length,maxloads); // �θ�Ŭ������ �����ڰ� �ִٸ� �׳� ��ӹ޾Ƽ� ����
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

	//�޼ҵ� �������̵�(Override) �θ𿡰� ��ӹ��� ������ ���� ���� ��
	@Override
	public int getCost() {
		return (int)getMaxloads() * 2;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf(", ����:%s \n", fuel);
	}
}
