package com.test1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ExceptionMain {
	
	static void inputMiss() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				
				System.out.println("ù��° ���� �Է�: ");
				int a = sc.nextInt();
				System.out.println("�ι�° ���� �Է�: ");
				int b = sc.nextInt();
				
				System.out.printf("%d + %d = %d \n",a,b,a+b);
					break;
				// catch (InputMismatchException ime)
			} catch (Exception e) {
				System.err.println("���ڸ� �Է����ּ���.");
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
				System.out.printf("%d / %d = ��:%d, ������:%d \n",a,b,a/b,a%b);
				break;
				// ArithmeticException
			} catch (Exception e) {
				System.err.println("0���� ���� �� �����ϴ�.");
			}
		}
		
		
	}
	
	static void inputDivide() {
		Scanner sc = new Scanner(System.in);

		while(true) {
			try {
				System.out.println("ù��° ���� �Է�: ");
				int a = sc.nextInt();
				System.out.println("�ι�° ���� �Է�: ");
				int b = sc.nextInt();
				System.out.printf("%d / %d = ��:%d, ������:%d \n",a,b,a/b,a%b);
				break;
				// ArithmeticException
			} catch (ArithmeticException ae) {
				System.err.println("0���� ���� �� �����ϴ�.");
				sc.nextLine();
			} catch(InputMismatchException ime) {
				System.err.println("���ڸ� �Է����ּ���.");
				sc.nextLine();
			} catch(Exception e) {
				// catch�� �ȿ��� �����༭ ������ ������ ��
//				if(e instanceof ArithmeticException){
//					
//				} else if(e instanceof InputMismatchException) {
//					
//				}
				e.printStackTrace(); //������ ���� �󼼼����� �� �� ����
//				System.err.println(e.getMessage());
			}
		}
	}
	
	
	static User login() throws PasswordInputException {
		//Ű���忡�� id,pwd �Է¹޾Ƽ� ����2�� �̻�, ������ 4�� �̻����� �˻��Ͽ� ������ ������ User �ν��Ͻ� ���� �� ����
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� �Է����ּ���: ");
		String uid = sc.next();
		System.out.println("��й�ȣ�� �Է����ּ���: ");
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
				throw new PasswordInputException("��ȣ �Է� ����");
//				throw new RuntimeException("��ȣ �Է� ����");
//			} catch(Exception ex) {
//				System.err.println("��ȣ�� �䱸���ǿ� ���� �Է�");
//			}
//			return null;
		}

		
	}
	
	public static void main(String[] args) {

//		inputMiss();
		
//		divide();
//		inputDivide();
		
		// ����ó��
		// Exception : ���� ����(�Է� ����, ��� ����)
		// Error : ġ���� ����(�޸� ����, ��Ʈ��ũ �������)
		
//		try {
//			// ���� �߻� ������ �ڵ�
//			1.
//			2.
//			3.
//		} catch(xxxxException ex) {
//			// ���� �߻� �� �������� �ǵ�(����ó�� ����)
//			ex.printStackTrace(); // ���� ���� ���� �޽���
//			String msg = ex.getMessage();
//			System.out.println("���� ����:"+msg);
//		} finally {
//			
//		}
		while(true) {
			try {
				login();
				System.out.println("��ȿ�� ��й�ȣ�Դϴ�.");
				break;
			} catch (PasswordInputException pie) {
				//String msg = pie.getMessage();
				System.err.println(pie.getAdvice());
//				System.err.println("���� 2�� �̻�, ���ĺ� 4�� �̻����� �������ּ���.");
			}
		}
		
//		User u = login();
//		if(u==null) {
//			System.err.println("���� 2�� �̻�, ���ĺ� 4�� �̻����� �������ּ���.");
//		} else {
//			System.out.println("��ȿ�� ��й�ȣ�Դϴ�.");
//		}
		
//		String str = "a123b";
//		char ch = str.charAt(0);
//		char ch2 = str.charAt(1);
//		
//		System.out.println(Character.isLetter(ch));		//true
//		System.out.println(Character.isAlphabetic(ch));	//true
//		System.out.println(Character.isLetter(ch2));	//false
//		System.out.println(Character.isDigit(ch2));		//true

		
		System.out.println("���α׷� ����");
		
	}

}
