package com.test1;

import java.util.Calendar;
import java.util.Scanner;

public class ControlStatements {

	public static void main(String[] args) {
//		String id = "smith";
//		String pw = "a123";
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("���̵� �Է����ּ���: ");
//    	String id_input = sc.next();
//    	System.out.println("��й�ȣ�� �Է����ּ���: ");
//    	String pw_input = sc.next();
//    	
//    	if(id.equals(id_input) && pw.equals(pw_input)) {
//    		System.out.println("�α��� ����");
//    	} else {
//    		System.out.println("�α��� ����");
//    	}
		
//		Calendar cal = Calendar.getInstance();
//		int y = cal.get(Calendar.YEAR);
//		int m = cal.get(Calendar.MONTH)+1;
//		int d = cal.get(Calendar.DAY_OF_MONTH);
//		int w = cal.get(Calendar.DAY_OF_WEEK);
//		String week = null;
//		if(w==1) {
//			week = "�Ͽ���";
//		} else if (w==2) {
//			week = "������";
//		} else if (w==3) {
//			week = "ȭ����";
//		} else if (w==4) {
//			week = "������";
//		} else if (w==5) {
//			week = "�����";
//		} else if (w==6) {
//			week = "�ݿ���";
//		} else if (w==7) {
//			week = "�����";
//		} else {
//			System.err.println("�߸��� ����");
//		}
//		
//		System.out.printf("%d-%d-%d %s \n", y, m, d, week);
		
//		ifTest();
//		switchDemo(5);
//		gugudan(3);
		
//		if(login()) {
//			System.out.println("�α��� ����");
//		} else {
//			System.out.println("�α��� ����");
//		}

//		for1();
//		System.out.println(kk());
		
//		System.out.println(testWhile(1,10));
		showGugu(inputDan());
	}
	//����� ���� �޼ҵ�(Method)
	static void ifTest() {
		System.out.println("test �޼ҵ�");
	}
	
	static void switchDemo(int dow) {
		String sDay = null;
		switch(dow) {
		case 1:
			sDay = "�Ͽ���";
			break;
		case 2:
			sDay = "������";
			break;
		case 3:
			sDay = "ȭ����";
			break;
		case 4:
			sDay = "������";
			break;
		case 5:
			sDay = "�����";
			break;
		case 6:
			sDay = "�ݿ���";
			break;
		case 7:
			sDay = "�����";
			break;
		}
		System.out.println(sDay);
	}
	
	static void gugudan(int dan) {
		for(int i =1; i<=9; i++) {
			System.out.printf("%d * %d = %d \n", dan, i, dan*i);
		}
	}
	
	static boolean login() {
		String id = "smith";
		String pw = "a123";
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� �Է����ּ���: ");
		String id_input = sc.next();
		System.out.println("�н����带 �Է����ּ���: ");
		String pw_input = sc.next();
		
		if(id.equals(id_input)) {
			if(pw.equals(pw_input)) {
				return true;
			}
		}
		return false;
		
		
	}
	
	static void for1() {
		int count = 0;
		
		for(int i = 1; i<=100; i++) {
			if((i%2 == 0) && (i%3 == 0)) {
				count += 1;
			}
		}
		
		System.out.println(count);
	}
	
	static void ss() {
		for(int i = 10; i>=0; i--) {
			System.out.println(i);
		}
	}
	
	static int kk( ) {
		int sum = 0;
		for(int i = 1; i<=20; i++) {
			if(i % 2 != 0) {
				sum += i;
			}
		}
		return sum;
	}

	static int testWhile(int s, int e) {
		int sum = 0;
		while(s++ < e+1) {
			sum += s-1;
//			if(s == e) {
//				break;
//			}
//			s++;
		}
		return sum;
	}

	static void doWhileTest() {
		int i = 0;
		do {
			i++;
		} while(i<10);
		System.out.println(i);
	}

	static int inputDan() {
		int dan = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �� ��? ");
		dan = sc.nextInt();
		
		return dan;
	}

	static void showGugu(int dan) {
		int i = 0;
//		while(i<9) {
//			i++;
//			System.out.printf("%d * %d = %d \n", dan, i, dan*i);}
		
		do {
			i++;
			System.out.printf("%d * %d = %d \n", dan, i, dan*i);
		} while(i<9);
	 }
		
	static void continueTest() {
		int i = 1;
		int sum = 0;
		while(i<=10) {
			if(i%2==0) {
				i++;
				continue;
			}
			if(sum>=30) {
				break;
			}
			sum += 1;
			System.out.println(i);
		}
	}

}




