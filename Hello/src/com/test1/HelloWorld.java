package com.test1;
import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
//		System.out.println("Hello World");
//		
//		byte b;
//		b=-128; // 초기화
//		System.out.println(b);
		
//		int max = Short.MAX_VALUE;
//		int min = Short.MIN_VALUE;
//		System.out.printf("Short형 최대값: %d, 최소값: %d \n", max, min);
		
//		System.out.println(Long.MIN_VALUE);
		
//		float f = 3.1415926535f;
//		System.out.println(f);
		
//    	Scanner sc = new Scanner(System.in);
//		
//		System.out.println("실수입력: ");
//		float f1 = ssd.nextFloat();
//		System.out.println("입력된 값: " + f1);
		
//		char ch = '가';
//		System.out.println((int)ch);
//		System.out.println((int)Character.MAX_VALUE);
//		ch=0x61; //97의 16진수
    	Scanner sc = new Scanner(System.in);
    	System.out.println("정수를 입력: ");
    	int i1 = sc.nextInt();
		String res = (i1 % 2) == 0 ? "짝수":	"홀수";
		System.out.println(i1+"은(는) "+res+"입니다.");
	    String msg = String.format("%d는 %s입니다\n", i1, res);
	    System.out.println(msg);
	}

}
