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
		//abstract�� ������ interface�������� �ڵ������� ���� ������ �ν�
		abstract void print();
		abstract int add(int a, int b);
	}
	
	//�߻� �޼ҵ尡 �Ѱ��� ������ �Լ��� �������̽�
	interface Ifunc{
		int add(int a, int b);
	}
	
	//�������̽� ������� : �̸��� ���� Ŭ�������� ����, �͸� Ŭ�������� ����, Lambda������ ����
	class IfuncImpl implements Ifunc{

		@Override
		public int add(int a, int b) {
			// TODO Auto-generated method stub
			return a+b;
		}
		
	}
	
	//�����Ѵ�.
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

		//�������̽��� ������ �͸� Ŭ����
//		int v = new Ifunc() {
//			@Override
//			public int add(int a, int b) {
//				return a+b;
//			}
//		}.add(3, 5);
//		
//		System.out.println(v);
		
		//Lambda������ �Լ��� �������̽�(�޼ҵ尡 1���� �������̽�) ����
//		Ifunc f = (a,b) ->{
//			return a+b;
//		};
//		v = f.add(2, 4);
//		System.out.println(v);
		
		//Lambda�� �� �� ������
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
		
		//Anonymous Class(�͸�Ŭ����)
//		new LocalCls() {
//			@Override
//			public void print() {
//				System.out.println("This is Anonymous Class");
//			}
//		}.print();
		
		
	}

}
