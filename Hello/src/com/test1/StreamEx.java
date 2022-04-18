//package com.test1;
//
//import java.io.*;
//import java.util.*;
//
//// 텍스트 파일(member.txt)을 대상으로 CRUD 구현
//// 프로그램이 시작되면 화면에 회원목록 5인 정보가 표시
//// 리스트 하단에 메뉴가 표시(목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x))
//// 텍스트 파일에 저장될 데이터 포맷 : id|name|phone|email
//
//public class StreamEx {
//
//	static File src = new File("C:/Users/ysmin/Javatest/member.txt");
//	
//	static List<Member> loadList() throws Exception{
//		FileReader fr = new FileReader(src);
//		BufferedReader br = new BufferedReader(fr);
//		String line = null;
//		List<Member> list = new ArrayList<Member>();
//		while(( line = br.readLine()) != null) {
//			String[] token = line.split("\\|");
//			int id = Integer.parseInt(token[0]);
//			list.add(new Member(id, token[1], token[2], token[3]));
//		}
//		br.close();
//		return list;
//	}
//	
//	static void showList(List<Member> list) {
//		for(int i = 0; i<list.size(); i++) {
//			list.get(i).printMem();
//		}
//	}
//	
//	static String menu() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("목록(s), 검색(f), 추가(a), 수정(u), 삭제(d), 종료(x): ");
//		String m = sc.nextLine().trim();
//		return m;
//	}
//	
//	static List<Member> deleteList() {
//		List<Member> list = new ArrayList<Member>();
//		try {
//			list = loadList();
//			FileWriter fw = new FileWriter(src);
//			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("삭제할 이름을 입력해주세요: ");
//			String m = sc.nextLine().trim();
//			
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		list.get(0).printMem();
//		return null;
//	}
//	
//	static Member find() throws Exception{
//		Scanner sc = new Scanner(System.in);
//		System.out.println("검색할 번호를 입력해주세요 ");
//		int m = sc.nextInt();
//		
//		return null;
//	}
//	
//	static void search() {
//		List<Member> list = new ArrayList<Member>();
//		try {
//			list = loadList();
//			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("검색할 번호를 입력해주세요 ");
//			int m = sc.nextInt();
//			
//			for(int i = 0; i<list.size(); i++) {
//				if(m==list.get(i).id) {
//					list.get(i).printMem();
//					break;
//				} else {
//					System.err.println("없는 번호입니다. 다시 입력해주세요");
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	static boolean add() {
//
//			Scanner sc = new Scanner(System.in);
//			System.out.println("추가할 번호를 입력해주세요: ");
//			int id = sc.nextInt();
//			System.out.println("추가할 이름을 입력해주세요: ");
//			String name = sc.next();
//			System.out.println("추가할 전화번호를 입력해주세요: ");
//			String phone = sc.next();
//			System.out.println("추가할 이메일을 입력해주세요: ");
//			String email = sc.next();
//			sc.nextLine();
//			
//		return appendFile(new Member(id, name, phone, email));
//	}
//	
//	static boolean appendFile(Member m) {
//		File dest = new File("C:/Users/ysmin/Javatest/member.txt");
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(dest, true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.err.println(e.getMessage());
//			return false;
//		}
//		PrintWriter pw = new PrintWriter(fw);
////		String line = String.format("%d|%s|%s|%s", m.id, m.name, m.phone, m.email);
////		pw.println(line);
//		pw.printf("%d|%s|%s|%s\n", m.id, m.name, m.phone, m.email);
//		pw.close();
//		return true;
//	}
//	
//	static boolean update() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("수정할 번호를 입력해주세요: ");
//		int num = Integer.valueOf(sc.nextLine().trim());
//		try {
//			Member m = search(num);
//			if(m!=null) {
//				System.out.println("새로운 전화번호를 입력해주세요: ");
//				String newPhone = sc.next();
//				System.out.println("새로운 이메일을 입력해주세요: ");
//				String newEmail = sc.next();
//				sc.nextLine();
//				//리스트에서 수정 후 리스트의 내용을 파일에 반영
//				List<Member> list = loadList();
//				for(int i=0; i<list.size(); i++) {
//					if(list.get(i).id == num) {
//						list.get(i).phone = newPhone;
//						list.get(i).email = newEmail;
//					}
//				}
//				return overwrite(list);
//			}
//		} catch(Exception e){
//			System.err.println(e.getMessage());
//		} 
//		return false;
//	}
//	 
//	static boolean overwrite(List<Member> list) {
//		File dest = new File("C:/Users/ysmin/Javatest/member.txt");
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(dest);
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//			return false;
//		}
//		PrintWriter pw = new PrintWriter(fw);
//		Member m = null;
//		for(int i=0; i<list.size(); i++) {
//			m = list.get(i);
//			pw.printf("%d|%s|%s|%s\n", m.id, m.name, m.phone, m.email);
//			pw.flush();
//		}
//		pw.close();
//		return true;
//	}
//	
//	static boolean delete() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("수정할 번호를 입력해주세요: ");
//		int num = Integer.valueOf(sc.nextLine().trim());
//		try {
//			Member m = search(num);
//				List<Member> list = loadList();
//				list.remove(m);
//				return overwrite(list);
//		} catch(Exception e){
//			System.err.println(e.getMessage());
//		} 
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//		
//		try {
//			List<Member> list = loadList();
//			showList(list);
//			boolean go = true;
//			while(go) {
//				String m = menu();
//				switch(m) {
//				case "s": 
//					showList(loadList());
//					break;
//				case "f":
//					search();
//					break;
//				case "a":
//					if(add()) {
//						System.out.println("회원정보 추가 성공");
//					} else {
//						System.err.println("회원정보 추가 실패");
//					}
//					break;
//				case "u":
//					if(update()) {
//						System.out.println("회원정보 수정 성공");
//					} else {
//						System.out.println("회원정보 수정 실패");
//					}
//					break;
//				case "d":
//					if(delete()) {
//						System.out.println("회원정보 삭제 성공");
//					} else {
//						System.out.println("회원정보 삭제 실패");
//					}
//					break;
//				case "x": 
//					System.out.println("프로그램이 종료되었습니다");
//					go = false;
//					break;
//				default :
//					System.err.println("메뉴입력 오류");
//				}
//			}
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
