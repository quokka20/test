package com.test1;

public class Interface_main {

	// Inner Class
	class Test{
		public void print() {
			System.out.println("This is Test");
		}
	}
	
	static class Test2{
		public void print() {
			System.out.println("This is Test2");
		}
	}
	
	interface iTest{
		//abstract를 지워도 interface내에서는 자동적으로 붙은 것으로 인식
		abstract void print();
		abstract int add(int a, int b);
	}
	
	//추상 메소드가 한개만 있으면 함수형 인터페이스
	interface Ifunc{
		int add(int a, int b);
	}
	
	//인터페이스 구현방법 : 이름을 가진 클래스에서 구현, 익명 클래스에서 구현, Lambda식으로 구현
	class IfuncImpl implements Ifunc{

		@Override
		public int add(int a, int b) {
			// TODO Auto-generated method stub
			return a+b;
		}
		
	}
	
	//구현한다.
	class TestImpl implements iTest{

		@Override
		public void print() {
			System.out.println("TestImpl.print()");
		}

		@Override
		public int add(int a, int b) {
			// TODO Auto-generated method stub
			return a+b;
		}
		
	}
	
	public static void main(String[] args) {

		//인터페이스를 구현한 익명 클래스
//		int v = new Ifunc() {
//			@Override
//			public int add(int a, int b) {
//				return a+b;
//			}
//		}.add(3, 5);
//		
//		System.out.println(v);
		
		//Lambda식으로 함수적 인터페이스(메소드가 1개인 인터페이스) 구현
//		Ifunc f = (a,b) ->{
//			return a+b;
//		};
//		v = f.add(2, 4);
//		System.out.println(v);
		
		//Lambda식 좀 더 간단히
//		Ifunc f2 = (a,b) -> a+b;
//		f2.add(5, 6);
		
		
//		Interface_main m = new Interface_main();
//		TestImpl t = m.new TestImpl();
//		t.print();
//		System.out.println(t.add(2, 3));
//		
//		iTest itest = t;
//		itest.print();
//		System.out.println(itest.add(1, 2));
		
		
//		Interface_main m = new Interface_main();
//		Test t = m.new Test();
//		t.print();
//		
//		Test2 t2 = new Test2();
//		t2.print();
//		
//		Interface_main.Test2 tt = new Interface_main.Test2();
//		tt.print();
		
		//Local Class
//		class LocalCls{
//			public void print() {
//				System.out.println("Local Class");
//			}
//		}
//		
//		LocalCls lc = new LocalCls();
//		lc.print();
		
		//Anonymous Class(익명클래스)
//		new LocalCls() {
//			@Override
//			public void print() {
//				System.out.println("This is Anonymous Class");
//			}
//		}.print();
		
		
	}

}
