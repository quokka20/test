package com.test1;

public class OOP_Fundamental {

	public static void main(String[] args) {
		// Object Oriented Programming
		// Object : 고유한 속성, 기능을 가진 사물
		// 객체: 전화기, 사람, 컵 자동차...
		// 소프트웨어: 정보 처리
		// 전화기 판매 : 디자인, 가격, 제조사, 크기, 색상
		// 실물객체 모방(추상화)하여 클래스 모델링
		// 실물객체 추상화 -> 클래스(코드)
		Phone.seller = "더조은폰";
		
		//참조객체 생성, 초기화
		Phone p = new Phone(30000, 20, "cp-1029", "Modern");
		Phone p2 = new Phone(42000, 19, "cp-3210", "Samsung");

//		System.out.printf("%s\t%s\t%d\t%d \n",p.model, p.madeBy, p.price, p.screenSize);
//		System.out.printf("%s\t%s\t%d\t%d \n",p2.model, p2.madeBy, p2.price, p2.screenSize);
		
		Phone[] pn = new Phone[2];
		pn[0] = p;
		pn[1] = p2;
		
		System.out.println(Phone.seller+"의 상품정보");
		for(int i = 0; i<pn.length; i++) {
			System.out.printf("%s\t%s\t%d\t%d \n",pn[i].model, pn[i].madeBy, pn[i].price, pn[i].screenSize);
		}
	}

}
