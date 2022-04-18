package com.test1;

public class Pet {
	
	String species;
	String color;
	float weight;
	int price;
	static String seller;
	
	public Pet(String species, String color, float weight, int price) {
		this.species = species;
		this.color = color;
		this.weight = weight;
		this.price = price;
	}

	public void printPet() {
		System.out.printf("%s\t%s\t%.1f\t%d\t%s \n",species, color, weight, price, Pet.seller);
	}
	
	public static void main(String[] args) {
		seller = "seongmin";
		
		Pet p1 = new Pet("∏Æ∆Æ∏Æπˆ","∞ÒµÂ",12.5f,10000);
		Pet p2 = new Pet("«„Ω∫≈∞","∞À»Ú",15,15000);
		Pet p3 = new Pet("Ω√√Ú","»Úªˆ",6.7f,5000);

		
		Pet[] p = new Pet[3];
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
		
		for(int i = 0; i<p.length; i++) {
			p[i].printPet();
		}
	}

}
