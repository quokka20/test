package com.test1;
import java.util.Random;
import java.util.Scanner;

public class Operators {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//    	System.out.println("������ �� ���� ����ұ��?: ");
//    	int dan = sc.nextInt();
    	
//    	for(int i=1; i<10; i++) {
//    		System.out.println(i1+"*"+i+"="+i1*i);
//    	};
//    	String format = "%d * %d = %d \n";
//    	int num = 1;
//    	System.out.printf(format,dan,num,dan*num++);
//    	System.out.printf(format,dan,num,dan*num++);
//    	System.out.printf(format,dan,num,dan*num++);
//    	System.out.printf(format,dan,num,dan*num++);
//    	System.out.printf(format,dan,num,dan*num++);
//    	System.out.printf(format,dan,num,dan*num++);
//    	System.out.printf(format,dan,num,dan*num++);
//    	System.out.printf(format,dan,num,dan*num++);
//    	System.out.printf(format,dan,num,dan*num++);
//		Scanner sc = new Scanner(System.in);
//    	System.out.println("���̸� �Է����ּ���: ");
//    	int age = sc.nextInt();
    	
//    	if(age>=20) {
//    		System.out.println("�����Դϴ�.");
//    	} else {
//    		System.out.println("������ �ƴմϴ�.");
//    	}
//    	
//    	String adult = age < 20 ? "���� �ƴ�" : "����";
//    	System.out.println(adult);
//    	
//    	boolean res = "A" == "A";
//    	String msg = res ? "����" : "�ٸ�";
//    	System.out.println(msg);
    	
//		String son1 = "�����";
//		String son2 = "�����";
//		System.out.println(son1.equals(son2));
		
//		String id = "smith";
//		String pw = "a123";
//		
//		Scanner sc = new Scanner(System.in);
//    	System.out.println("���̵� �Է����ּ���: ");
//    	String id_input = sc.nextLine();
//    	System.out.println("��й�ȣ�� �Է����ּ���: ");
//    	String pw_input = sc.nextLine();
//		String login=id.equals(id_input) && pw.equals(pw_input) ? "�α��� ����" : "�α��� ����";
//    	System.out.println(login);
    	
    	
//    	Random rd;
//    	rd = null;
//    	rd = new Random();
//    	int num = rd.nextInt(10);
//    	System.out.println(num);
//    	
//    	char ch = (char)rd.nextInt(1000);
//    	System.out.println(ch);
		
//		System.out.println(5 ^ 3);
		
		Random rd;
		rd = null;
		rd = new Random();
		int num1 = rd.nextInt();
		int num2 = rd.nextInt();
		
		String ss = (num1 % 2 != 0) && (num2 % 2 != 0) ? "��ȿ" : "��ȿ" ;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(ss);
	}

}
