package com.test1;

public class Phone {
	
	// non-static member(instance variable, 객체 변수)
	// 프로그램 실행 중에 new 명령에 의해 중복되어 Heap영역에 생성되는 변수
	int price;
	int screenSize;
	String model;
	String madeBy;
	
	// 스태틱 멤버 변수(클래스 변수, 정적 변수)
	// static의 경우 바뀌지 않는 것, 프로그램이 시작되면 자동으로 메모리에 1개만 로드되어 즉시 사용될 수 있다.
	static String seller = "더조은폰";
	
	// 기본 생성자 : 생성자가 정의되지 않을 때 컴파일러에 의해서 자동으로 정의됨.
	public Phone() {}
	
	// 생성자 오버로드(Constructor Overload, 생성자 중복정의)
	// 생성자: 객체 생성 직후에 자동으로 실행되는 코드 블럭
	// 리턴 타입이 없고 클래스 명과 동일한 이름을 가져야 함
	// 아래와 같은 생성자를 생성할 경우 기본 생성자를 만들어 주는 것이 좋음
	public Phone(int price, int ss, String model, String made) {
		this.price = price;
		screenSize = ss;
		this.model = model;
		madeBy = made;
	}

}
