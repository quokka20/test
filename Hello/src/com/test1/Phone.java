package com.test1;

public class Phone {
	
	// non-static member(instance variable, ��ü ����)
	// ���α׷� ���� �߿� new ��ɿ� ���� �ߺ��Ǿ� Heap������ �����Ǵ� ����
	int price;
	int screenSize;
	String model;
	String madeBy;
	
	// ����ƽ ��� ����(Ŭ���� ����, ���� ����)
	// static�� ��� �ٲ��� �ʴ� ��, ���α׷��� ���۵Ǹ� �ڵ����� �޸𸮿� 1���� �ε�Ǿ� ��� ���� �� �ִ�.
	static String seller = "��������";
	
	// �⺻ ������ : �����ڰ� ���ǵ��� ���� �� �����Ϸ��� ���ؼ� �ڵ����� ���ǵ�.
	public Phone() {}
	
	// ������ �����ε�(Constructor Overload, ������ �ߺ�����)
	// ������: ��ü ���� ���Ŀ� �ڵ����� ����Ǵ� �ڵ� ��
	// ���� Ÿ���� ���� Ŭ���� ��� ������ �̸��� ������ ��
	// �Ʒ��� ���� �����ڸ� ������ ��� �⺻ �����ڸ� ����� �ִ� ���� ����
	public Phone(int price, int ss, String model, String made) {
		this.price = price;
		screenSize = ss;
		this.model = model;
		madeBy = made;
	}

}
