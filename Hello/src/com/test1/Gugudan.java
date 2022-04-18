package com.test1;

public class Gugudan {
	int dan;
	
	public Gugudan(int dan) {
		this.dan = dan;
	}
	
	public void printGugudan() {
		for(int j = 1; j<10; j++) {
			System.out.printf("%d * %d = %d \n",dan,j,dan*j);
		}
	}
	
}
