package com.test1;

public class InheritanceTest {
	
	// ��ü���� ����� 3��Ư¡ (��Ӽ�, ������, ���м�)
	// Inheritance(��Ӽ�) : �ٸ� Ŭ������ �Ӽ��� ����� ���� Ŭ������ �״�� �޾Ƽ� ���ο� Ŭ���� ����
	// Polymorphism(������) : ����Ͽ� �Ļ��� Ŭ������ ����� �θ�� �ణ �ٸ� Ư�� ����� ���� ����
	// Encapsulation(���м�) : �Ӽ��� �ٸ� Ŭ�������� �������� ���ϵ��� ���ߴ� ��
	// ��Ӽ� Ȱ�� : �θ� Ŭ���� ���� > �ڽ� Ŭ���� �Ļ�, class Child extends Parents{ }
	// ������ Ȱ�� : �޼ҵ� �������̵�, �޼ҵ� �����ε�
	// ���м� Ȱ�� : ��������� private Ű���� ���

	// Access Modifiers : public, protected, default, private
	// public : ���������� ���� �ʴ´�(��������)
	// protected : ���� ��Ű���� �ִ� Ŭ������ �ڽ� Ŭ�������� ����
	// default : Ű���带 ������� �ʴ� ���, ���� ��Ű���� �ִ� Ŭ�����鿡�� ����
	// private : ���� Ŭ�������Ը� ������ �����
	
	public static void main(String[] args) {
//		Vehicle v = new Vehicle(2,"Ship",4,2.5F);
//		v.setKind("Ship");
//		System.out.println(v.maxloads);	// ������ ���� ���� ����
//		v.maxloads = 3.2F; // ���� ������ ���� ���� �ܺο��� ���� ����
//		System.out.println(v.maxloads);
//		v.print();
//		Arith.add(3, 4);
//		Arith.add(3.14, 3.141592);
		
//		Truck t = new Truck(2, "Truck", 4, 10.0F,"Diesel");
//		Motocycle m = new Motocycle(1, "Motocycle", 2, 2.5F, 10);
//		int cost = t.getCost();
//		System.out.println("������: "+cost);
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
		Cat c1 = new Cat("��ġŲ", 2, 15000, 1.2F, "����", "������ ���� ������ �������ּ���");
		Cat c2 = new Cat("�丣�þ�", 1, 10000, 1.5F, "���", "���� ���� ���� �� �ֽ��ϴ�");
		Dog d1 = new Dog("��Ʈ����", 1, 20000, 3.0F, "Ȳ��", "���");
		Dog d2 = new Dog("�㽺Ű", 2, 30000, 4.3F, "����", "���&���" );
		Dog d3 = new Dog("����", 3, 21000, 1.9F, "���", "���");
		
		a[0] = c1;
		a[1] = c2;
		a[2] = d1;
		a[3] = d2;
		a[4] = d3;
		for(int i = 0; i<a.length; i++) {
			if(a[i] instanceof Cat) {
				System.out.println("����� ����------");
			} else if(a[i] instanceof Dog) {
				System.out.println("������ ����------");
			}
			a[i].print();
			a[i].sound();
		}
		
		// �߻�Ŭ������ �����ϸ� ���ο� �ν��Ͻ��� ������ �� ����.
//		Pet p = new Pet();
	}

}
