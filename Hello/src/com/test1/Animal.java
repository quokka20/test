package com.test1;

// �� �� �̻��� �߻� �޼ҵ带 ������ Ŭ������ �ݵ�� abstract Ű���带 ������ �Ѵ�.
public abstract class Animal {
	private String species;
	private int age;
	private int price;
	private float weight;
	private String color;
	
	public Animal() {}
	
	public Animal(String species, int age, int price, float weight, String color) {
		super();
		setSpecies(species);
		setAge(age);
		setPrice(price);
		setWeight(weight);
		setColor(color);
	}

	public void print() {
		System.out.printf("ǰ��:%s, ����:%d, ����:%d, ü��:%.1f, ����:%s",species, age, price, weight, color);
	}
	
	//���� �ǹ��� ����
//	public void sound() {
//		// ��ü�� ���带 ǥ���ϱ⿡�� �������� ����
//	} // ���� Ŭ�������� �������̵��ص� �ǰ� ���ص� �ȴ�.

	// ���� �ǹ��� ���鶧, ����Ŭ�������� �������̵带 ����
	abstract void sound();
	
	
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
