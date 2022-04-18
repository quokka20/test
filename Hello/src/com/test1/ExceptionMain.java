package com.test1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ExceptionMain {
	
	static void inputMiss() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				
				System.out.println("첫번째 숫자 입력: ");
				int a = sc.nextInt();
				System.out.println("두번째 숫자 입력: ");
				int b = sc.nextInt();
				
				System.out.printf("%d + %d = %d \n",a,b,a+b);
					break;
				// catch (InputMismatchException ime)
			} catch (Exception e) {
				System.err.println("숫자를 입력해주세요.");
				System.out.println();
				sc.nextLine();
			}
		}
	}
	

	static void divide() {
		while(true) {
			try {
				Random rd = new Random();
				int a = rd.nextInt(6);
				int b = rd.nextInt(6);
				System.out.printf("%d / %d = 몫:%d, 나머지:%d \n",a,b,a/b,a%b);
				break;
				// ArithmeticException
			} catch (Exception e) {
				System.err.println("0으로 나눌 수 없습니다.");
			}
		}
		
		
	}
	
	static void inputDivide() {
		Scanner sc = new Scanner(System.in);

		while(true) {
			try {
				System.out.println("첫번째 숫자 입력: ");
				int a = sc.nextInt();
				System.out.println("두번째 숫자 입력: ");
				int b = sc.nextInt();
				System.out.printf("%d / %d = 몫:%d, 나머지:%d \n",a,b,a/b,a%b);
				break;
				// ArithmeticException
			} catch (ArithmeticException ae) {
				System.err.println("0으로 나눌 수 없습니다.");
				sc.nextLine();
			} catch(InputMismatchException ime) {
				System.err.println("숫자를 입력해주세요.");
				sc.nextLine();
			} catch(Exception e) {
				// catch문 안에서 조건줘서 오류를 나눠도 됨
//				if(e instanceof ArithmeticException){
//					
//				} else if(e instanceof InputMismatchException) {
//					
//				}
				e.printStackTrace(); //에러에 대한 상세설명을 볼 수 있음
//				System.err.println(e.getMessage());
			}
		}
	}
	
	
	static User login() throws PasswordInputException {
		//키보드에서 id,pwd 입력받아서 숫자2개 이상, 영문자 4개 이상인지 검사하여 문제가 없으면 User 인스턴스 생성 및 리턴
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요: ");
		String uid = sc.next();
		System.out.println("비밀번호를 입력해주세요: ");
		String pwd = sc.next();
		
		int numcnt = 0;
		int alpacnt = 0;
		
		for(int i = 0; i<pwd.length(); i++) {
			char ch = pwd.charAt(i);
			if(Character.isDigit(ch)) {
				numcnt ++;
			} else if(Character.isAlphabetic(ch)) {
				alpacnt ++;
			}
		}
		
		if(numcnt>=2 && alpacnt>=4) {
			User user = new User();
			user.setId(uid);
			user.setPwd(pwd);
			return user;
		} else {
//			try {
				throw new PasswordInputException("암호 입력 오류");
//				throw new RuntimeException("암호 입력 오류");
//			} catch(Exception ex) {
//				System.err.println("암호는 요구조건에 따라 입력");
//			}
//			return null;
		}

		
	}
	
	public static void main(String[] args) {

//		inputMiss();
		
//		divide();
//		inputDivide();
		
		// 예외처리
		// Exception : 순한 오류(입력 오류, 산술 오류)
		// Error : 치명적 오류(메모리 부족, 네트워크 연결오류)
		
//		try {
//			// 예외 발생 가능한 코드
//			1.
//			2.
//			3.
//		} catch(xxxxException ex) {
//			// 예외 발생 시 개발자의 의도(예외처리 로직)
//			ex.printStackTrace(); // 가장 상세한 예외 메시지
//			String msg = ex.getMessage();
//			System.out.println("에외 원인:"+msg);
//		} finally {
//			
//		}
		while(true) {
			try {
				login();
				System.out.println("유효한 비밀번호입니다.");
				break;
			} catch (PasswordInputException pie) {
				//String msg = pie.getMessage();
				System.err.println(pie.getAdvice());
//				System.err.println("숫자 2개 이상, 알파벳 4개 이상으로 구성해주세요.");
			}
		}
		
//		User u = login();
//		if(u==null) {
//			System.err.println("숫자 2개 이상, 알파벳 4개 이상으로 구성해주세요.");
//		} else {
//			System.out.println("유효한 비밀번호입니다.");
//		}
		
//		String str = "a123b";
//		char ch = str.charAt(0);
//		char ch2 = str.charAt(1);
//		
//		System.out.println(Character.isLetter(ch));		//true
//		System.out.println(Character.isAlphabetic(ch));	//true
//		System.out.println(Character.isLetter(ch2));	//false
//		System.out.println(Character.isDigit(ch2));		//true

		
		System.out.println("프로그램 종료");
		
	}

}
