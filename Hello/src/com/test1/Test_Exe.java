package com.test1;

public class Test_Exe {

	public static void main(String[] args) {
		// ������ ����
//		Gugudan gd = new Gugudan(5);
//		gd.printGugudan();
		
		//���� ����
//		Vector v1 = new Vector(2,3);
//		Vector v2 = new Vector(3,6);
//		
//		Vector v3 = v1.add(v2);
//		Vector v4 = v1.sub(v2);
//
//		v3.print();	//(5,9)
//		v4.print();
		
		//���� ����
//		int res = Arith.add(3,5);	// 8
//		System.out.println(res);
//		res = Arith.sub(3,5);		// -2
//		System.out.println(res);
//		res = Arith.mul(3,5);		// 15
//		System.out.println(res);
//		res = Arith.div(10,2);		// 5
//		System.out.println(res);
		
		//�Խ��� ����
//		BBS[] b = new BBS[5];
//		
//		b[0] = new BBS(1, "�ȳ�", "sm", "2021-10-29");
//		b[1] = new BBS(2, "����", "tts", "2021-07-20");
//		b[2] = new BBS(3, "����", "����", "2021-10-03");
//		b[3] = new BBS(4, "�̾�", "jj", "2021-08-17");
//		b[4] = new BBS(5, "�ݰ�", "ik", "2021-03-10");
//
//		for(int i = 0; i<b.length; i++) {
//			b[i].print();
//		}
		
		ElectronicDevices[] e = new ElectronicDevices[3];
		Desktop d1 = new Desktop("�׷�", 1000000, "LG", "2018");
		Desktop d2 = new Desktop("�����ν���", 600000, "�����", "2019");
		SmartPhone p1 = new SmartPhone("������", 900000, "�Ｚ", 270);
		
		e[0] = d1;
		e[1] = d2;
		e[2] = p1;
		
		int price = 0;
		
		for(int i = 0; i<e.length; i++) {
			e[i].print();
			price += e[i].getPrice();
		}
		System.out.println("�� ��ǰ ����: "+price+"�� �Դϴ�.");
		
		
	}

}
