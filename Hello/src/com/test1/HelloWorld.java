package com.test1;
import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
//		System.out.println("Hello World");
//		
//		byte b;
//		b=-128; // �ʱ�ȭ
//		System.out.println(b);
		
//		int max = Short.MAX_VALUE;
//		int min = Short.MIN_VALUE;
//		System.out.printf("Short�� �ִ밪: %d, �ּҰ�: %d \n", max, min);
		
//		System.out.println(Long.MIN_VALUE);
		
//		float f = 3.1415926535f;
//		System.out.println(f);
		
//    	Scanner sc = new Scanner(System.in);
//		
//		System.out.println("�Ǽ��Է�: ");
//		float f1 = ssd.nextFloat();
//		System.out.println("�Էµ� ��: " + f1);
		
//		char ch = '��';
//		System.out.println((int)ch);
//		System.out.println((int)Character.MAX_VALUE);
//		ch=0x61; //97�� 16����
    	Scanner sc = new Scanner(System.in);
    	System.out.println("������ �Է�: ");
    	int i1 = sc.nextInt();
		String res = (i1 % 2) == 0 ? "¦��":	"Ȧ��";
		System.out.println(i1+"��(��) "+res+"�Դϴ�.");
	    String msg = String.format("%d�� %s�Դϴ�\n", i1, res);
	    System.out.println(msg);
	}

}
