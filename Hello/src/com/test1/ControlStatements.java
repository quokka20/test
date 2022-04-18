package com.test1;

import java.util.Calendar;
import java.util.Scanner;

public class ControlStatements {

	public static void main(String[] args) {
//		String id = "smith";
//		String pw = "a123";
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("아이디를 입력해주세요: ");
//    	String id_input = sc.next();
//    	System.out.println("비밀번호를 입력해주세요: ");
//    	String pw_input = sc.next();
//    	
//    	if(id.equals(id_input) && pw.equals(pw_input)) {
//    		System.out.println("로그인 성공");
//    	} else {
//    		System.out.println("로그인 실패");
//    	}
		
//		Calendar cal = Calendar.getInstance();
//		int y = cal.get(Calendar.YEAR);
//		int m = cal.get(Calendar.MONTH)+1;
//		int d = cal.get(Calendar.DAY_OF_MONTH);
//		int w = cal.get(Calendar.DAY_OF_WEEK);
//		String week = null;
//		if(w==1) {
//			week = "일요일";
//		} else if (w==2) {
//			week = "월요일";
//		} else if (w==3) {
//			week = "화요일";
//		} else if (w==4) {
//			week = "수요일";
//		} else if (w==5) {
//			week = "목요일";
//		} else if (w==6) {
//			week = "금요일";
//		} else if (w==7) {
//			week = "토요일";
//		} else {
//			System.err.println("잘못된 요일");
//		}
//		
//		System.out.printf("%d-%d-%d %s \n", y, m, d, week);
		
//		ifTest();
//		switchDemo(5);
//		gugudan(3);
		
//		if(login()) {
//			System.out.println("로그인 성공");
//		} else {
//			System.out.println("로그인 실패");
//		}

//		for1();
//		System.out.println(kk());
		
//		System.out.println(testWhile(1,10));
		showGugu(inputDan());
	}
	//사용자 정의 메소드(Method)
	static void ifTest() {
		System.out.println("test 메소드");
	}
	
	static void switchDemo(int dow) {
		String sDay = null;
		switch(dow) {
		case 1:
			sDay = "일요일";
			break;
		case 2:
			sDay = "월요일";
			break;
		case 3:
			sDay = "화요일";
			break;
		case 4:
			sDay = "수요일";
			break;
		case 5:
			sDay = "목요일";
			break;
		case 6:
			sDay = "금요일";
			break;
		case 7:
			sDay = "토요일";
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
		System.out.println("아이디를 입력해주세요: ");
		String id_input = sc.next();
		System.out.println("패스워드를 입력해주세요: ");
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
		System.out.println("구구단 몇 단? ");
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




