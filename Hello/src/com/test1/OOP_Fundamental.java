package com.test1;

public class OOP_Fundamental {

	public static void main(String[] args) {
		// Object Oriented Programming
		// Object : ������ �Ӽ�, ����� ���� �繰
		// ��ü: ��ȭ��, ���, �� �ڵ���...
		// ����Ʈ����: ���� ó��
		// ��ȭ�� �Ǹ� : ������, ����, ������, ũ��, ����
		// �ǹ���ü ���(�߻�ȭ)�Ͽ� Ŭ���� �𵨸�
		// �ǹ���ü �߻�ȭ -> Ŭ����(�ڵ�)
		Phone.seller = "��������";
		
		//������ü ����, �ʱ�ȭ
		Phone p = new Phone(30000, 20, "cp-1029", "Modern");
		Phone p2 = new Phone(42000, 19, "cp-3210", "Samsung");

//		System.out.printf("%s\t%s\t%d\t%d \n",p.model, p.madeBy, p.price, p.screenSize);
//		System.out.printf("%s\t%s\t%d\t%d \n",p2.model, p2.madeBy, p2.price, p2.screenSize);
		
		Phone[] pn = new Phone[2];
		pn[0] = p;
		pn[1] = p2;
		
		System.out.println(Phone.seller+"�� ��ǰ����");
		for(int i = 0; i<pn.length; i++) {
			System.out.printf("%s\t%s\t%d\t%d \n",pn[i].model, pn[i].madeBy, pn[i].price, pn[i].screenSize);
		}
	}

}
