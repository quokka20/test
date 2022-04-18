package com.test1;

// 한 개 이상의 추상 메소드를 포함한 클래스는 반드시 abstract 키워드를 가져야 한다.
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
		System.out.printf("품종:%s, 나이:%d, 가격:%d, 체중:%.1f, 색상:%s",species, age, price, weight, color);
	}
	
	//약한 의무만 생김
//	public void sound() {
//		// 구체적 사운드를 표시하기에는 적합하지 않음
//	} // 하위 클래스에서 오버라이드해도 되고 안해도 된다.

	// 강한 의무를 만들때, 하위클래스에서 오버라이드를 강제
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
