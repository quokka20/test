package com.test1;

import java.io.Serializable;
import java.util.Scanner;

public class Member implements Serializable{
	int num;
	String name;
	String phone;
	String email;
	
	public Member() {}
	
	public Member(int num, String name, String phone, String email) {
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public void printMem() {
		System.out.printf("%d\t%s\t%s\t%s \n",num,name, phone, email);
	}

	@Override
	public boolean equals(Object obj) {
		Member m = (Member) obj;
		if(m.num == num && m.name.equals(m.name)) {
			return true;
		}
		return false;
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		
//		
//		Member[] mb = new Member[5];
//		
//		for(int i = 0; i<mb.length; i++) {
//			System.out.println("번호 이름 전화 메일");
//			int id = sc.nextInt();
//			String name = sc.next();
//			String phone = sc.next();
//			String email = sc.nextLine();
//			mb[i] = new Member(id, name, phone, email);
//		}
//		
//		System.out.println();
//		System.out.println("멤버 명부");
//		for(int i = 0; i<mb.length; i++) {
//			mb[i].printMem();
//	}
//		
//		Member m1 = new Member();
//		Member m2 = new Member();
//		Member m3 = new Member();
//		Member m4 = new Member();
//		Member m5 = new Member();
//
//		Member[] mb = new Member[5];
//		mb[0] = m1;
//		mb[1] = m2;
//		mb[2] = m3;
//		mb[3] = m4;
//		mb[4] = m5;
//		
//		for(int i = 0; i<mb.length; i++) {
//			 mb[i].id = i+1;
//			 System.out.println("이름을 입력해주세요: ");
//			 mb[i].name = sc.nextLine();
//			 System.out.println("핸드폰번호를 입력해주세요: ");
//			 mb[i].phone = sc.nextLine();
//			 System.out.println("이메일을 입력해주세요: ");
//			 mb[i].email = sc.nextLine();
//		 }
//		
//		System.out.println();
//		System.out.println("멤버 명부");
//		for(int i = 0; i<mb.length; i++) {
//			System.out.printf("%d\t%s\t%s\t%s \n",mb[i].id, mb[i].name, mb[i].phone, mb[i].email);
//	}
//
//}
}
