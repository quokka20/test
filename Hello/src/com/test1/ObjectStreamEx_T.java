package com.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ObjectStreamEx_T {
	
		static File file = new File("C:/Users/ysmin/Javatest/member_T.obj");
		
		static void init() {
			List<Member> list = new LinkedList<>();
			
			list.add(new Member(11,"Smith","010-2547-2590","smith@naver.com"));
			list.add(new Member(12,"손흥민","010-3694-2149","son@gmail.com"));
			list.add(new Member(13,"이재명","010-2597-2103","leejm@daum.net"));
			list.add(new Member(14,"윤설아","010-1294-6930","yoons@yahoo.com"));
			list.add(new Member(15,"Daniel","010-2140-1593","daniel@naver.com"));
			try {
				FileOutputStream fout = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				
				oos.writeObject(list);
				oos.close();
				System.out.println("\t-------> 초기목록 저장 성공");
				
			}catch(Exception e) {
				System.err.println("\t-------> 초기목록 저장 실패");
			}
		}
		static List<Member> loadList() {
			try {
				FileInputStream fin = new FileInputStream(file);
				ObjectInputStream oin = new ObjectInputStream(fin);
				List<Member> list = (List<Member>)oin.readObject();
				oin.close();
				return list;
			}catch(Exception e) {
				System.err.println("loadList() 오류");
				return null;
			}
		}
		static void print(List<Member> list) {
			for(int i=0;i<list.size();i++) {
				list.get(i).printMem();
			}
		}
		static String menu() {
			System.out.println("------------------------------------------------");
			Scanner kbd = new Scanner(System.in);
			System.out.print("목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x):");
			String m = kbd.nextLine().trim();
			System.out.println("------------------------------------------------");
			return m;
		}
		static Member find() throws Exception {
			Scanner kbd = new Scanner(System.in);
			System.out.print("검색할 회원번호:");
			int num = kbd.nextInt();
			kbd.nextLine();
			return search(num);
		}
		static Member search(int num) throws Exception {
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream oin = new ObjectInputStream(fin);
			List<Member> list = (List<Member>)oin.readObject();
			oin.close();
			for(int i=0;i<list.size();i++) {
				if(list.get(i).num==num){
					return list.get(i);
				}
			}
			throw new Exception(num+" <-- 회원번호 검색결과 없음");
		}
		
		static void add() {
			Scanner kbd = new Scanner(System.in);
			System.out.print("번호 이름 전화 메일:");
			int num = kbd.nextInt();
			String name = kbd.next();
			String phone = kbd.next();
			String email = kbd.nextLine().trim();
			List<Member> list = loadList();
			list.add(new Member(num,name,phone,email));
			overwrite(list);
		}
		static boolean overwrite(List<Member> list) {
			try {
				FileOutputStream fout = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				
				oos.writeObject(list);
				oos.close();
				System.out.println("\t-------> Overwrite OK");
				return true;
			}catch(Exception e) {
				System.err.println("\t-------> Overwrite Fail");
			}
			return false;
		}
		static void update() throws Exception {
			Scanner kbd = new Scanner(System.in);
			System.out.print("수정할 회원번호:");
			int num = kbd.nextInt();
			kbd.nextLine();
			search(num);
			System.out.print("전화번호 이메일:");
			String phone = kbd.next();
			String email = kbd.nextLine().trim();
			List<Member> list = loadList();
			for(int i=0;i<list.size();i++) {
				if(list.get(i).num==num) {
					list.get(i).phone = phone;
					list.get(i).email = email;
					break;
				}
			}
			overwrite(list);
		}
		static void delete() throws Exception {
			Scanner kbd = new Scanner(System.in);
			System.out.print("삭제할 회원번호:");
			int num = kbd.nextInt();
			kbd.nextLine();
			Member m = search(num);
			List<Member> list = loadList();
			list.remove(m);
			overwrite(list);
		}
		
		public static void main(String[] args) 
		{
			if(!file.exists()) {  // 데이터 파일이 없을 때만 파일 생성
				init();  // 파일에 List<Member> 저장
			}
			List<Member> list = loadList(); // 직렬화하여 저장한 파일로 부터 목록 로드
			print(list);
			
			boolean go = true;
			while(go) {
				String m = menu();
				try {
					switch(m)
					{
					case "s": print(loadList()); break;
					case "f": find().printMem(); break;
					case "a": add();             break;
					case "u": update();          break;
					case "d": delete();          break;
					case "x": go = false;        break;
					default:
						System.err.println("메뉴입력 오류!");
					}
				}catch(Exception e) {
					System.err.println(e.getMessage());
				}
			}
			System.out.println("프로그램 종료...");
		}
	}