package com.test1;
import java.util.Random;
import java.util.Scanner;

public class Operators {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//    	System.out.println("구구단 몇 단을 출력할까요?: ");
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
//    	System.out.println("나이를 입력해주세요: ");
//    	int age = sc.nextInt();
    	
//    	if(age>=20) {
//    		System.out.println("성인입니다.");
//    	} else {
//    		System.out.println("성인이 아닙니다.");
//    	}
//    	
//    	String adult = age < 20 ? "성인 아님" : "성인";
//    	System.out.println(adult);
//    	
//    	boolean res = "A" == "A";
//    	String msg = res ? "동일" : "다름";
//    	System.out.println(msg);
    	
//		String son1 = "손흥민";
//		String son2 = "손흥민";
//		System.out.println(son1.equals(son2));
		
//		String id = "smith";
//		String pw = "a123";
//		
//		Scanner sc = new Scanner(System.in);
//    	System.out.println("아이디를 입력해주세요: ");
//    	String id_input = sc.nextLine();
//    	System.out.println("비밀번호를 입력해주세요: ");
//    	String pw_input = sc.nextLine();
//		String login=id.equals(id_input) && pw.equals(pw_input) ? "로그인 성공" : "로그인 실패";
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
		
		String ss = (num1 % 2 != 0) && (num2 % 2 != 0) ? "유효" : "무효" ;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(ss);
	}

}
