package com.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectStreamEX_Review {

	// ObjectInputStream / ObjectOutputStream
	// FileInputStream / FileOutputStream
	// List<Member>
	// 프로그램 시작되면 Member 5인의 정보 목록이 표시되고 메뉴가 하단에 표시
	
	//파일 소스
	static File src = new File("C:/Users/ysmin/Javatest/member_test.obj");
	
	// 초기값 설정 및 오브젝트에 삽입
	static void init() {
		List<Member> list = new ArrayList<>();
		list.add(new Member(1,"김일등","010-1111-1111","first@naver.com"));
		list.add(new Member(2,"이세컨","010-2222-2222","2222@naver.com"));
		list.add(new Member(3,"박삼삼","010-3333-3333","samsam@naver.com"));
		list.add(new Member(4,"최너이","010-4444-4444","four@naver.com"));
		list.add(new Member(5,"오오","010-5555-5555","oioi@naver.com"));
		
		try {
			FileOutputStream fout = new FileOutputStream(src);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("오브젝트 초기값 입력 실패");
		}
	}
	
	// 오브젝트에 있는 리스트 값 가져오기
	static List<Member> loadList() {
		try {
			FileInputStream fin = new FileInputStream(src);
			ObjectInputStream ois = new ObjectInputStream(fin);
			List<Member> list = (ArrayList<Member>) ois.readObject();
			ois.close();

			return list;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("loadList() 오류");
			return null;
		}
	}
	
	// 리스트값 한 줄씩 출력하기
	static void printList(List<Member> list) {
		System.out.println("-----------------------------------------------");
		for(int i = 0; i<list.size(); i++) {
			list.get(i).printMem();
		}
	}
	
	// 메뉴 출력
	static String menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------------------------");
		System.out.print("목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x):");
		String m = sc.next();
		
		return m;
		
	}
	
	static int searchNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하실 회원의 번호를 입력해주세요: ");
		int num = sc.nextInt();
		sc.nextLine();
		
		return num;
	}
	
	static Member search(int num) throws Exception {
		List<Member> list = loadList();
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).num == num) {
				return list.get(i);
			}
		}
		throw new Exception("없는 회원번호입니다.");
	}
	
	static List<Member> addInfo() {

			Scanner sc = new Scanner(System.in);
			System.out.print("추가하실 회원의 번호를 입력해주세요: ");
			int num = sc.nextInt();
			System.out.print("추가하실 회원의 이름을 입력해주세요: ");
			String name = sc.next();
			System.out.print("추가하실 회원의 전화를 입력해주세요: ");
			String phone = sc.next();
			System.out.print("추가하실 회원의 이메일을 입력해주세요: ");
			String email = sc.next();
			sc.nextLine();
			
			List<Member> list = loadList();
			list.add(new Member(num,name,phone,email));
			
			return list;

	}
	
	static void overwrite(List<Member> list) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(src);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);
			oos.close();
			System.out.println("성공했습니다");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("실패했습니다");
		}
	}
	
	static int deleteNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제하실 회원의 회원번호를 입력해주세요: ");
		int num = sc.nextInt();
		sc.nextLine();
		
		return num;
	}
	
	static List<Member> delete(int num) throws Exception {
		Member m = search(num);
		List<Member> list = loadList();
		list.remove(m);
		return list;
	}
	
	static void updateInfo() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("수정하실 회원의 회원번호를 입력해주세요: ");
		int num = sc.nextInt();
		search(num);
		System.out.print("수정 희망하는 이름을 입력해주세요: ");
		String name = sc.next();
		System.out.print("수정 희망하는 전화번호를 입력해주세요: ");
		String phone = sc.next();
		System.out.print("수정 희망하는 이메일을 입력해주세요: ");
		String email = sc.next();
	
		List<Member> list = loadList();
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).num== num) {
				list.get(i).name = name;
				list.get(i).phone = phone;
				list.get(i).email = email;
				break;
			}
		}
		overwrite(list);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(!src.exists()) {
			init();
		}
		List<Member> list = loadList();
		printList(list);
		boolean go = true;
		
		while(go) {
			try {
				switch(menu()) {
				case("x") : System.out.println("프로그램 종료"); go=false; break;
				case("s") : printList(loadList()); break;
				case("f") : search(searchNum()).printMem();
				case("a") : overwrite(addInfo()); break;
				case("u") : updateInfo(); break;
				case("d") : overwrite(delete(deleteNum())); break;
				default : System.err.println("없는 메뉴입니다 다시 입력해주세요");
				}
			} catch(Exception e) {
				System.err.println(e.getMessage());
				
			}
			
		}
		
		
		
		
	}

}
