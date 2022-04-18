package com.test1;

import java.io.*;
import java.util.*;

/* 텍스트 파일(member.txt)을 대상으로 CRUD 구현
 * 프로그램이 시작되면 화면에 회원목록 5인정보가 표시된다
 * 리스트 하단에 메뉴가 표시된다(목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x))
 * 텍스트 파일에 저장될 데이터 포맷 : num|name|phone|email
 */
public class StreamEx_T 
{
	static File src = new File("D:/JavaTest/member.txt");
	
	static List<Member> loadList() throws Exception {
		FileReader fr = new FileReader(src);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		List<Member> list = new ArrayList<>();
		while((line=br.readLine())!=null) {
			String[] token = line.split("\\|");
			// Integer.parseInt를 사용해서 token[0]부분에 String으로 들어온 걸 int로 변환
			int num = Integer.parseInt(token[0]);
			list.add(new Member(num, token[1], token[2], token[3]));
		}
		br.close();
		return list;
	}
	
	static void showList(List<Member> list) {
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
		int num = Integer.parseInt(kbd.nextLine().trim());
		return search(num);
	}
	
	static Member search(int num) throws Exception {
		List<Member> list = loadList();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).num == num) {
				return list.get(i);
			}
		}
		throw new Exception("번호로 검색 오류");
	}
	
	static boolean add() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("번호 이름 전화 메일:");
		int num = kbd.nextInt();
		String name = kbd.next();
		String phone = kbd.next();
		String email = kbd.nextLine().trim();
		return appendFile(new Member(num,name,phone,email));
	}
	
	static boolean appendFile(Member m) {
		File dest = new File("D:/JavaTest/member.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(dest, true);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.printf("%d|%s|%s|%s\n", m.num, m.name, m.phone, m.email);
		pw.close();
		return true;
	}
	
	static boolean update() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("수정할 회원번호:");
		int num = Integer.valueOf(kbd.nextLine().trim());
		try {
			Member m = search(num);
			if(m!=null) {
				System.out.print("새 전화번호 새 이메일:");
				String newPhone = kbd.next();
				String newEmail = kbd.nextLine().trim();
				List<Member> list = loadList();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).num == num) {
						list.get(i).phone = newPhone;
						list.get(i).email = newEmail;
					}
				}
				return overwrite(list);  // 기존 파일에 덮어쓰기
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	static boolean overwrite(List<Member> list)  {
		File dest = new File("D:/JavaTest/member.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(dest);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
		PrintWriter pw = new PrintWriter(fw);
		Member m = null;
		for(int i=0;i<list.size();i++) {
			m = list.get(i);
			pw.printf("%d|%s|%s|%s\n", m.num, m.name, m.phone, m.email);
			pw.flush();
		}
		pw.close();
		return true;
	}
	
	static boolean delete() {
		Scanner kbd = new Scanner(System.in);
		System.out.print("삭제할 회원번호:");
		int num = Integer.valueOf(kbd.nextLine().trim());
		try {
			Member m = search(num);
			List<Member> list = loadList();
			list.remove(m);
			System.out.println("원소수:"+list.size());
			return overwrite(list);  // 기존 파일에 덮어쓰기
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		List<Member> list = null;
		try {
			list = loadList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		showList(list);
		
		boolean go = true;
		while(go) 
		{
			String m = menu();
			try {
				switch(m) {
				case "s":
					showList( loadList() );
					break;
				case "f":
					find().printMem();
					break;
				case "a":
					if(add()) System.out.println("회원정보 추가 성공!");
					else System.err.println("회원정보 추가 실패!!!");
					break;
				case "u":
					//몇번 회원 변경? -> 리스트 -> 수정대상 Member객체 찾음
					//검색된 Member객체에 새 전화, 새 이메일을 설정
					//리스트 -> 파일에 덮어쓰기
					if(update()) System.out.println("회원정보 수정 성공!");
					else System.err.println("회원정보 수정 실패!!!");
					break;
				case "d":
					if(delete()) System.out.println("회원정보 삭제 성공!");
					else System.err.println("회원정보 삭제 실패!!!");
					break;
				case "x":
					go = false;
					break;
				default:
					System.err.println("메뉴입력 오류");
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}	
		}
		
		System.out.println("프로그램 종료...");
	}
}
