package com.test1;

public class InheritanceTest {
	
	// 객체지향 언어의 3대특징 (상속성, 다형성, 은닉성)
	// Inheritance(상속성) : 다른 클래스의 속성과 기능을 하위 클래스가 그대로 받아서 새로운 클래스 생성
	// Polymorphism(다형성) : 상속하여 파생된 클래스의 기능은 부모와 약간 다른 특정 기능을 갖는 성질
	// Encapsulation(은닉성) : 속성을 다른 클래스에서 접근하지 못하도록 감추는 것
	// 상속성 활용 : 부모 클래스 선언 > 자식 클래스 파생, class Child extends Parents{ }
	// 다형성 활용 : 메소드 오버라이드, 메소드 오버로드
	// 은닉성 활용 : 멤버변수에 private 키워드 사용

	// Access Modifiers : public, protected, default, private
	// public : 접근제한을 하지 않는다(완전공개)
	// protected : 현재 패키지에 있는 클래스와 자식 클래스에게 공개
	// default : 키워드를 사용하지 않는 경우, 현재 패키지에 있는 클래스들에게 공개
	// private : 현재 클래스에게만 접근을 허용함
	
	public static void main(String[] args) {
//		Vehicle v = new Vehicle(2,"Ship",4,2.5F);
//		v.setKind("Ship");
//		System.out.println(v.maxloads);	// 변수에 대한 직접 접근
//		v.maxloads = 3.2F; // 직접 접근이 허용될 때는 외부에서 변경 가능
//		System.out.println(v.maxloads);
//		v.print();
//		Arith.add(3, 4);
//		Arith.add(3.14, 3.141592);
		
//		Truck t = new Truck(2, "Truck", 4, 10.0F,"Diesel");
//		Motocycle m = new Motocycle(1, "Motocycle", 2, 2.5F, 10);
//		int cost = t.getCost();
//		System.out.println("유지비: "+cost);
//		t.print();

//		System.out.println(m.getCost());
//		m.print();
		
//		Vehicle v = t;
//		v = m;
		
//		Vehicle[] v;
//		v = new Vehicle[2];
//		v[0] = t;
//		v[1] = m;
//		
//		for(int i =0; i<v.length; i++) {
//			v[i].print();
//		}
		
		Animal[] a = new Animal[5];
		Cat c1 = new Cat("먼치킨", 2, 15000, 1.2F, "갈색", "관절이 좋지 않으니 주의해주세요");
		Cat c2 = new Cat("페르시안", 1, 10000, 1.5F, "흰색", "털이 많이 날릴 수 있습니다");
		Dog d1 = new Dog("리트리버", 1, 20000, 3.0F, "황금", "사료");
		Dog d2 = new Dog("허스키", 2, 30000, 4.3F, "검흰", "사료&고기" );
		Dog d3 = new Dog("시츄", 3, 21000, 1.9F, "흰색", "사료");
		
		a[0] = c1;
		a[1] = c2;
		a[2] = d1;
		a[3] = d2;
		a[4] = d3;
		for(int i = 0; i<a.length; i++) {
			if(a[i] instanceof Cat) {
				System.out.println("고양이 정보------");
			} else if(a[i] instanceof Dog) {
				System.out.println("강아지 정보------");
			}
			a[i].print();
			a[i].sound();
		}
		
		// 추상클래스로 설정하면 새로운 인스턴스를 생성할 수 없다.
//		Pet p = new Pet();
	}

}
